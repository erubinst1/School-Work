import java.util.*;

public class DPJustifier extends AbstractJustifier {

    @Override
    public List<String> justify(List<String> words, int L, double b) {
        /** Build a DP solution that minimizes total L1 ugliness.
         *   Definitions:
         *    - a_i = word lengths; L = target line length; b = ideal blank.
         *    - For candidate line w_i..w_j (inclusive):
         *        k = j - i           // number of gaps
         *        W = sum_{t=i}^j a_t // total word length
         *        S = L - W           // free space for blanks (sum of gap lengths)
         *   Feasibility:
         *    - If k == 0 (single word):
         *        * non-last line requires S == 0
         *        * last line allows S >= 0
         *    - If k > 0 (multiple words): require S >= k  // strictly positive gaps
         *   Cost (L1 via average blank b' = S/k, with k>0):
         *    - non-last: k * |b' - b|
         *    - last:     k * max(0, b - b')   // only shrinking is charged
         *    - If k == 0, cost is 0 when feasible, +∞ otherwise.
         *   DP:
         *    - DP(i) = min over j>=i of [ lineCost(i..j) + DP(j+1) ], scanning i from n-1 down to 0.
         *  Steps:
         *    1) Precompute a[0..n-1] (and optionally prefix sums).
         *    2) Fill dp[n]=0, then dp[i] for i=n-1..0; keep next[i] to reconstruct.
         *    3) Reconstruct lines with render(words, i, j, L, last) using integer gaps.
         */

        final int n = words.size();
        List<String> result = new ArrayList<>();
        if (n == 0) return result;

        // 1) lengths a[i] and prefix sums ps (so W(i..j) = ps[j+1] - ps[i])
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = words.get(i).length();
        int[] ps = new int[n + 1];
        for (int i = 0; i < n; i++) ps[i + 1] = ps[i] + a[i];

        // 2) DP arrays: dp[i] = min ugliness from i..end; next[i] = best j for line i..j
        double[] dp = new double[n + 1];
        int[] next = new int[n + 1];
        Arrays.fill(dp, Double.POSITIVE_INFINITY);
        Arrays.fill(next, -1);
        // empty suffix costs 0
        dp[n] = 0.0;

        // Fill from right to left
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                // number of gaps on line
                int k = j - i;
                // total word length on line
                int W = ps[j + 1] - ps[i];
                // total blank space to distribute
                int S = L - W;
                boolean last = (j == n - 1);

                // Early pruning: if S < 0, adding more words only increases W → break
                if (S < 0) break;

                double cost = lineCost(k, S, b, last);
                if (cost == Double.POSITIVE_INFINITY) continue;

                double cand = cost + dp[j + 1];
                if (cand < dp[i]) {
                    dp[i] = cand;
                    next[i] = j;
                }
            }
        }

        // 3) Reconstruct lines using next[] and render(...)
        int i = 0;
        while (i < n) {
            int j = next[i];
            // fallback if no j recorded
            if (j < i) j = i;
            boolean last = (j == n - 1);

            // Adjust indices for AbstractJustifier.render's subList(i-1, j) behavior:
            // pass (i+1, j+1) so it slices [i, j] inclusively.
            result.add(render(words, i + 1, j + 1, L, last));

            i = j + 1;
        }

        return result;
    }

    /**
     * L1 line cost with strictly positive gaps.
     * - k == 0 (single word):
     * non-last: feasible iff S == 0 (cost 0); else INF
     * last:     feasible iff S >= 0 (cost 0); else INF
     * - k > 0:
     * feasible iff S >= k (each gap >= 1 space)
     * cost = k*|S/k - b| for non-last
     * cost = k*max(0, b - S/k) for last
     */
    static double lineCost(int k, int S, double b, boolean last) {
        if (k == 0) {
            if (!last) return (S == 0) ? 0.0 : Double.POSITIVE_INFINITY;
            return (S >= 0) ? 0.0 : Double.POSITIVE_INFINITY;
        }
        if (S < k) return Double.POSITIVE_INFINITY;
        double avg = (double) S / k;
        return last ? k * Math.max(0.0, b - avg) : k * Math.abs(avg - b);
    }
}
