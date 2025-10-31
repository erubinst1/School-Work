public class RecursiveBinomial extends AbstractBinomial {
    @Override
    public long binom(int n, int k) {
        validate(n, k);

        // base cases: C(n,0)=1, C(n,n)=1
        if (k == 0 || k == n) {
            return 1;
        }

        // recurrence: C(n,k)=C(n-1,k-1)+C(n-1,k)
        return binom(n - 1, k - 1) + binom(n - 1, k);
    }
}

//The recursive binomial method has exponential running time because it repeatedly recomputes the same subproblems,
// with each call splitting into two more until reaching the base cases, resulting in roughly O(2^n) work for midrange k.
// In contrast, the dynamic programming (DP) version computes each subproblem only once and stores the results in a table,
// giving a much faster O(nk) running time with O(nk) space. Thus, the DP method is far more efficient for larger inputs,
// while the recursive approach is only reasonable for very small n or k.