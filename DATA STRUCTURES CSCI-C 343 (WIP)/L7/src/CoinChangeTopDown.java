import java.util.HashMap;
import java.util.Arrays;
import java.util.Scanner;

public class CoinChangeTopDown {
    // memo[amount] = min #coins to make 'amount' (or -1 if impossible)
    private static final HashMap<Integer, Integer> memo = new HashMap<>();

    public static int minChangeMemo(int amount, int[] denominations) {
        if (amount == 0) return 0;
        if (amount < 0)  return -1;
        if (memo.containsKey(amount)) return memo.get(amount);

        int best = Integer.MAX_VALUE;
        for (int d : denominations) {
            int sub = minChangeMemo(amount - d, denominations);
            if (sub >= 0) {
                best = Math.min(best, 1 + sub);
            }
        }

        int res = (best == Integer.MAX_VALUE) ? -1 : best;
        memo.put(amount, res);
        return res;
    }

    //for cases where the denomination input changes
    public static void clearMemo() {
        memo.clear();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter coin denominations separated by spaces:");
        String[] input = scanner.nextLine().split(" ");
        int[] denominations = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

        for (int i = 23; i < 70; i += 23) {
            long start = System.currentTimeMillis();
            System.out.println("Min coins for " + i + " cents: " + minChangeMemo(i, denominations));
            long end = System.currentTimeMillis();
            System.out.println("Time taken WITH memoization: " + (end - start) + "ms");
        }

        scanner.close();
    }
}
