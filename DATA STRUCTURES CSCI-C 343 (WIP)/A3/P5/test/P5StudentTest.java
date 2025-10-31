import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

/**
 * Additional tests for the DPJustifier implementation under the L1 model.
 * Mirrors the structure of JustifyTest with helpers for brute force and cost checks.
 */
public class P5StudentTest {

    // ===== Helpers (L1 spec) =====

    /** L1 per-line cost according to the assignment spec. */
    static double l1LineCost(int wordsCount, int totalWordLen, int L, double b, boolean last) {
        int k = wordsCount - 1;                // number of gaps
        int S = L - totalWordLen;              // total spaces on the line
        if (S < 0) return Double.POSITIVE_INFINITY;

        if (k == 0) { // single-word line
            return last ? (S >= 0 ? 0.0 : Double.POSITIVE_INFINITY)
                    : (S == 0 ? 0.0 : Double.POSITIVE_INFINITY);
        }

        if (S < k) return Double.POSITIVE_INFINITY; // strictly positive gaps when k>0

        double avg = (double) S / k;
        return last ? k * Math.max(0.0, b - avg) : k * Math.abs(avg - b);
    }

    /** L1 cost of a paragraph given concrete line breaks [i..j], using only counts. */
    static double l1BreaksCost(List<String> words, int L, double b, List<Integer> starts) {
        int n = words.size();
        int[] len = words.stream().mapToInt(String::length).toArray();
        double total = 0.0;
        for (int t = 0; t + 1 < starts.size(); t++) {
            int i = starts.get(t), j = starts.get(t + 1) - 1;
            int W = 0; for (int u = i; u <= j; u++) W += len[u];
            int wc = j - i + 1;
            boolean last = (t + 1 == starts.size() - 1);
            double c = l1LineCost(wc, W, L, b, last);
            if (!Double.isFinite(c)) return Double.POSITIVE_INFINITY;
            total += c;
        }
        return total;
    }

    /** Brute-force the optimal L1 paragraph cost (small n). */
    static double bruteForceBestCost(List<String> words, int L, double b) {
        int n = words.size();
        int[] len = words.stream().mapToInt(String::length).toArray();
        return dfs(0, words, len, L, b);
    }

    static double dfs(int i, List<String> words, int[] len, int L, double b) {
        int n = words.size();
        if (i == n) return 0.0;
        double best = Double.POSITIVE_INFINITY;
        for (int j = i; j < n; j++) {
            int W = 0; for (int t = i; t <= j; t++) W += len[t];
            int wc = j - i + 1;
            boolean last = (j == n - 1);
            double c = l1LineCost(wc, W, L, b, last);
            if (!Double.isFinite(c)) continue;
            double tail = dfs(j + 1, words, len, L, b);
            if (Double.isFinite(tail)) best = Math.min(best, c + tail);
        }
        return best;
    }

    /** Validate rendered lines (feasibility) and compute L1 cost from the rendering. */
    static double l1CostFromRendered(List<String> lines, List<String> words, int L, double b) {
        int n = words.size();
        int idx = 0;
        double total = 0.0;

        for (int li = 0; li < lines.size(); li++) {
            boolean last = (li == lines.size() - 1);
            String line = lines.get(li);
            if (!last) assertEquals(L, line.length(), "Non-last line must be exactly L");

            // parse words from this line
            int pos = 0, used = 0, W = 0;
            while (idx + used < n) {
                String w = words.get(idx + used);
                // skip spaces (esp. on last line)
                while (pos < line.length() && line.charAt(pos) == ' ') pos++;
                if (pos + w.length() > line.length()) break;
                if (!line.regionMatches(pos, w, 0, w.length())) break;
                pos += w.length();
                used++;
                W += w.length();
            }
            if (used == 0) throw new AssertionError("Rendered line has no recognizable words.");

            int wc = used;
            int k = wc - 1;
            int S = line.length() - W;

            if (k == 0) {
                if (!last) assertEquals(0, S, "Single-word non-last must fit exactly");
                else assertTrue(S >= 0, "Single-word last must have non-negative slack");
            } else {
                assertTrue(S >= k, "Strictly positive gaps required for multi-word lines");
            }

            total += l1LineCost(wc, W, L, b, last);
            idx += used;
        }
        assertEquals(n, idx, "Rendered lines must consume all words");
        return total;
    }

    // ===== Tests =====

    @Test
    void singleWord_paragraph_variousL() {
        RightJustifier just = new DPJustifier();
        List<String> words = List.of("hello");
        double b = 2.0;

        // Non-last lines don't exist here; only last line.
        assertEquals(List.of("hello"), just.justify(words, 5, b));
        assertEquals(List.of("hello  "), just.justify(words, 7, b)); // trailing spaces allowed on last
        assertEquals(List.of("hello     "), just.justify(words, 10, b));
    }

    @Test
    void exactFit_multiWord_nonLastMustReachL() {
        RightJustifier just = new DPJustifier();
        List<String> words = List.of("ab","cd","efg","h");
        int L = 7; // "ab cd" -> 2+2 + 1 space = 5 -> must place 2 spaces to reach L=7, avg=2
        double b = 2.0;

        List<String> lines = just.justify(words, L, b);
        // Feasibility & cost check
        double cost = l1CostFromRendered(lines, words, L, b);
        assertTrue(Double.isFinite(cost));
        // Non-last lines length L
        for (int i = 0; i + 1 < lines.size(); i++) assertEquals(L, lines.get(i).length());
    }

    @Test
    void dpMatchesBruteforce_smallHandcrafted() {
        RightJustifier just = new DPJustifier();
        List<String> words = List.of("This","is","an","L1","test");
        int L = 10;
        double b = 1.5;

        List<String> lines = just.justify(words, L, b);
        double dpCost = l1CostFromRendered(lines, words, L, b);
        double opt = bruteForceBestCost(words, L, b);
        assertEquals(opt, dpCost, 1e-9);
    }

    @Test
    void lastLine_onlyShrinkingPenalty_variedB() {
        RightJustifier just = new DPJustifier();
        List<String> words = List.of("end","line","free","to","expand");
        int L = 16;

        // Larger b means last-line shrink is more likely penalized; expansion never penalized.
        double b1 = 1.0, b2 = 3.0;

        List<String> lines1 = just.justify(words, L, b1);
        List<String> lines2 = just.justify(words, L, b2);

        double c1 = l1CostFromRendered(lines1, words, L, b1);
        double c2 = l1CostFromRendered(lines2, words, L, b2);

        assertTrue(Double.isFinite(c1) && Double.isFinite(c2));
        // Not necessarily monotone in b, but both must be finite and satisfy feasibility.
        for (int i = 0; i + 1 < lines1.size(); i++) assertEquals(L, lines1.get(i).length());
        for (int i = 0; i + 1 < lines2.size(); i++) assertEquals(L, lines2.get(i).length());
    }

    @Test
    void strictPositivity_enforced_multiword() {
        RightJustifier just = new DPJustifier();
        List<String> words = List.of("aa","bb","c");
        int L = 6;   // sums: ("aa","bb") = 4 -> S=2 >= k=1 is OK; ("bb","c") = 3 -> S=3 >=1 is OK
        double b = 1.0;

        List<String> lines = just.justify(words, L, b);
        double dpCost = l1CostFromRendered(lines, words, L, b);
        assertTrue(Double.isFinite(dpCost));
    }

    @Test
    void dpEqualsBruteforce_randomSmall() {
        RightJustifier just = new DPJustifier();
        Random rnd = new Random(42);

        for (int trial = 0; trial < 30; trial++) {
            int n = 3 + rnd.nextInt(5);
            List<String> words = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int len = 1 + rnd.nextInt(6);
                char base = (char) ('a' + rnd.nextInt(26));
                words.add(String.valueOf(base).repeat(len));
            }
            int sum = words.stream().mapToInt(String::length).sum();
            int L = Math.max(6, Math.min(sum + n - 1, 14)); // keep small to allow brute force
            double b = 1.0 + rnd.nextInt(3);

            List<String> lines = just.justify(words, L, b);
            double dpCost = l1CostFromRendered(lines, words, L, b);
            double best = bruteForceBestCost(words, L, b);

            assertEquals(best, dpCost, 1e-9, "Mismatch on trial " + trial);
        }
    }

    @Test
    void largeB_prefersExpandingNonLastTowardB() {
        RightJustifier just = new DPJustifier();
        List<String> words = List.of("a","bbb","c","dd");
        int L = 10;
        double b = 4.0; // encourages wider average gaps on non-last lines

        List<String> lines = just.justify(words, L, b);
        double cost = l1CostFromRendered(lines, words, L, b);
        assertTrue(Double.isFinite(cost));
        // Non-last lines must be exactly L
        for (int i = 0; i + 1 < lines.size(); i++) assertEquals(L, lines.get(i).length());
    }

    @Test
    void minimalWidth_lineBreaksExistOrDPHandles() {
        RightJustifier just = new DPJustifier();
        List<String> words = List.of("longword","x","y");
        int L = 8; // "longword" fits alone only if last (S>=0). But as non-last, must fit exactly (S==0) -> infeasible.
        double b = 1.0;

        // The DP should choose a feasible partition where "longword" is last line,
        // or otherwise render should throw; at minimum the result must be finite cost.
        List<String> lines = just.justify(words, L, b);
        double cost = l1CostFromRendered(lines, words, L, b);
        assertTrue(Double.isFinite(cost));
    }
}
