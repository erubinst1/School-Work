import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class P2StudentTest {

    private int scoreOf(String ax, String ay, int match, int mismatch, int gap) {
        int s = 0;
        for (int i = 0; i < ax.length(); i++) {
            char a = ax.charAt(i), b = ay.charAt(i);
            if (a == '-' || b == '-') s += gap;
            else s += (a == b ? match : mismatch);
        }
        return s;
    }

    @Test
    void bothEmpty() {
        AlignmentStrategy nw = new NeedlemanWunsch();
        AlignmentResult r = nw.align("", "");
        assertEquals(0, r.score);
        assertEquals("", r.alignedX);
        assertEquals("", r.alignedY);
        assertEquals(r.score, scoreOf(r.alignedX, r.alignedY, 1, -1, -2));
    }

    @Test
    void singleMismatchBetterThanTwoGaps() {
        AlignmentStrategy nw = new NeedlemanWunsch();
        AlignmentResult r = nw.align("A", "G");
        // best is mismatch (-1) vs two gaps (-4)
        assertEquals(-1, r.score);
        assertEquals(1, r.alignedX.length());
        assertEquals(1, r.alignedY.length());
        assertEquals(r.score, scoreOf(r.alignedX, r.alignedY, 1, -1, -2));
    }

    @Test
    void stringVsEmpty() {
        AlignmentStrategy nw = new NeedlemanWunsch();
        AlignmentResult r = nw.align("AGT", "");
        assertEquals(3 * -2, r.score);
        assertEquals("AGT", r.alignedX);
        assertEquals("---", r.alignedY);
        assertEquals(r.score, scoreOf(r.alignedX, r.alignedY, 1, -1, -2));
    }

    @Test
    void insertionsRequired_shorterVsLonger() {
        AlignmentStrategy nw = new NeedlemanWunsch();
        AlignmentResult r = nw.align("AAAA", "AA");
        // Optimal: 2 matches + 2 gaps => 2*1 + 2*(-2) = -2
        assertEquals(-2, r.score);
        assertEquals(r.alignedX.length(), r.alignedY.length());
        assertEquals(r.score, scoreOf(r.alignedX, r.alignedY, 1, -1, -2));
    }

    @Test
    void deletionRequired_longerVsShorter() {
        AlignmentStrategy nw = new NeedlemanWunsch();
        AlignmentResult r = nw.align("GCGT", "GCT");
        // Optimal: G C - T vs G C T -> 3 matches + 1 gap = 1
        assertTrue(r.score >= 1, "Expected score at least 1");
        assertEquals(r.alignedX.length(), r.alignedY.length());
        assertEquals(r.score, scoreOf(r.alignedX, r.alignedY, 1, -1, -2));
    }

    @Test
    void symmetryOfScore() {
        AlignmentStrategy nw = new NeedlemanWunsch();
        String x = "TACG";
        String y = "TAG";
        AlignmentResult r1 = nw.align(x, y);
        AlignmentResult r2 = nw.align(y, x);
        // With symmetric scoring and global alignment, total score should match.
        assertEquals(r1.score, r2.score);
        assertEquals(r1.score, scoreOf(r1.alignedX, r1.alignedY, 1, -1, -2));
        assertEquals(r2.score, scoreOf(r2.alignedX, r2.alignedY, 1, -1, -2));
    }

    @Test
    void manyMismatchesWorseThanGaps() {
        AlignmentStrategy nw = new NeedlemanWunsch();
        AlignmentResult r = nw.align("AAAA", "GGGG");
        // Best is either all mismatches (-4) or introduce gaps; optimal score should be <= -4
        assertTrue(r.score <= -4);
        assertEquals(r.score, scoreOf(r.alignedX, r.alignedY, 1, -1, -2));
    }

    @Test
    void lowerBoundByAllGaps() {
        AlignmentStrategy nw = new NeedlemanWunsch();
        String x = "ACGTAC";
        String y = "T";
        AlignmentResult r = nw.align(x, y);
        // Absolute lower bound: align everything with gaps -> (maxLen) * gap
        int lowerBound = Math.max(x.length(), y.length()) * -2;
        assertTrue(r.score >= lowerBound);
        assertEquals(r.score, scoreOf(r.alignedX, r.alignedY, 1, -1, -2));
    }

    @Test
    void identicalPrefixDifferentSuffix() {
        AlignmentStrategy nw = new NeedlemanWunsch();
        AlignmentResult r = nw.align("GATTACA", "GATTA");
        // 5 matches + 2 gaps (or mismatches) expected; ensure consistent scoring recomputation
        assertEquals(r.score, scoreOf(r.alignedX, r.alignedY, 1, -1, -2));
        assertEquals(r.alignedX.length(), r.alignedY.length());
    }
}
