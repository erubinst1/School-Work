public class NeedlemanWunsch extends AbstractAlignment {
    public NeedlemanWunsch() {
        super(+1, -1, -2); // default scoring: match=+1, mismatch=-1, gap=-2
    }

    @Override
    public AlignmentResult align(String X, String Y) {
        final int MATCH = +1, MISMATCH = -1, GAP = -2;
        final int DIAG = 0, UP = 1, LEFT = 2;

        int n = X.length();
        int m = Y.length();

        // 1) DP and backtrack tables
        // 0=DIAG, 1=UP, 2=LEFT
        int[][] dp = new int[n + 1][m + 1];
        int[][] bt = new int[n + 1][m + 1];

        // 2) initialize first row/col with gap penalties
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] + GAP;
            bt[i][0] = UP;
        }
        for (int j = 1; j <= m; j++) {
            dp[0][j] = dp[0][j - 1] + GAP;
            bt[0][j] = LEFT;
        }

        // 3) fill DP using match/mismatch and gapPenalty
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int scoreDiag = dp[i - 1][j - 1] + (X.charAt(i - 1) == Y.charAt(j - 1) ? MATCH : MISMATCH);
                // gap in Y
                int scoreUp = dp[i - 1][j] + GAP;
                // gap in X
                int scoreLeft = dp[i][j - 1] + GAP;

                int best = scoreDiag;
                int dir = DIAG;
                if (scoreUp > best) {
                    best = scoreUp;
                    dir = UP;
                }
                if (scoreLeft > best) {
                    best = scoreLeft;
                    dir = LEFT;
                }

                dp[i][j] = best;
                bt[i][j] = dir;
            }
        }

        // 4) traceback to build aligned strings
        StringBuilder ax = new StringBuilder();
        StringBuilder ay = new StringBuilder();
        int i = n, j = m;
        while (i > 0 || j > 0) {
            if (i == 0) {
                ax.append('-');
                ay.append(Y.charAt(j - 1));
                j--;
            } else if (j == 0) {
                ax.append(X.charAt(i - 1));
                ay.append('-');
                i--;
            } else {
                int dir = bt[i][j];
                if (dir == DIAG) {
                    ax.append(X.charAt(i - 1));
                    ay.append(Y.charAt(j - 1));
                    i--;
                    j--;
                } else if (dir == UP) {
                    ax.append(X.charAt(i - 1));
                    ay.append('-');
                    i--;
                } else { // LEFT
                    ax.append('-');
                    ay.append(Y.charAt(j - 1));
                    j--;
                }
            }
        }

        // 5) return result
        return new AlignmentResult(ax.reverse().toString(), ay.reverse().toString(), dp[n][m]);
    }
}
