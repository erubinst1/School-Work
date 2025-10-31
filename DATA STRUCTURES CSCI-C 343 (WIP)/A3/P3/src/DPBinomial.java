public class DPBinomial extends AbstractBinomial {
    @Override
    public long binom(int n, int k) {
        validate(n, k);

        long[][] C = new long[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            // Only need to compute up to min(i, k)
            for (int j = 0; j <= Math.min(i, k); j++) {
                // C[i][0]=C[i][i]=1
                if (j == 0 || j == i) {
                    C[i][j] = 1;
                } else {
                    // else C[i][j]=C[i-1][j-1]+C[i-1][j]
                    C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
                }
            }
        }
        return C[n][k];
    }
}
