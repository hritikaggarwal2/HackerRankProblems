import java.util.*;

public class Solution {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        int positive = 0;
        int negative = 0;
        int zeros = 0;

        for (int i : arr) {
            if (i > 0) {
                positive++;
            } else if (i < 0) {
                negative++;
            } else {
                zeros++;
            }
        }

        int total = positive + negative + zeros;
        printTo5Digit(1.0 * positive / total);
        printTo5Digit(1.0 * negative / total);
        printTo5Digit(1.0 * zeros / total);
    }

    private static void printTo5Digit(double number) {
        number *= 1000000;
        number = Math.round(number);
        System.out.println(number / 1000000);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}
