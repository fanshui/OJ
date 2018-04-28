package algorithm_question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*1 5 10 20 50 100 面值人民币组成N*/
public class Coins {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();

        int n = 5;
        int[] coins = {1,2,5};
        int result = change(n, coins);
        System.out.println(result);

    }

    public static int change(int amount, int[] coins) {
        int[] count = new int[amount + 1];
//        Arrays.fill(count,0);
        count[0] = 1;
        for(int i = 0; i < coins.length; i++) {
            for(int j = 0; j <= amount; j++) {
                if (j >= coins[i]) {
                    count[j] = count[j] + count[j - coins[i]];
                }
            }
        }
        return count[amount];
    }
}
