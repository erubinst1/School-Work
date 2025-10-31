import java.util.Arrays;
import java.util.Scanner;

public class CoinChange {

    public static int minChange(int amount, int[] denominations) {
        // Hint: Use an array dp[] where dp[i] represents the minimum number of coins needed for amount

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int coin : denominations) {
            for (int i = coin; i <= amount; i++) {
                if (dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return (dp[amount] == Integer.MAX_VALUE) ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter coin denominations separated by spaces:");
        String[] input = scanner.nextLine().split(" ");
        int[] denominations = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i <= 10; i++) {
            System.out.println("Minimum coins for " + i + " cents: " + minChange(i, denominations));
        }

        scanner.close();
    }
}

//Step 3: Explore Different Denominations
//
//When using {1, 3, 4} instead of {1, 5, 10, 25}, the number of coins needed for smaller amounts often decreases because 3 and 4
//fill gaps efficiently. Removing the 1-cent coin, however, makes some amounts impossible to form—for example, with {5, 10} you can’t
//make 3 or 8. In general, denominations that include smaller coins or have a greatest common divisor (GCD) of 1 make the problem easier
//because every amount can be reached, while larger or poorly spaced denominations make it harder and increase the number of coins needed.
//
//Step 4: Explain the Differences Between Approaches
//
//Both the Top-Down and Bottom-Up methods have roughly the same time complexity of O(n × amount) and space complexity of O(amount).
//However, the Top-Down approach uses recursion and memoization, which can consume more memory and time from function call overhead.
//The Bottom-Up approach builds the solution iteratively and is generally faster and more memory-efficient for large amounts.
//Recursion (Top-Down) is preferable when the problem space is sparse or when you only need a few specific subproblems, while iteration
//(Bottom-Up) works best when computing all results up to the target efficiently.