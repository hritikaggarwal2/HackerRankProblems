import java.util.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
         * class should be named Solution.
         */
        int num = scanner.nextInt();
        int[] arr = new int[num];

        for (int i = 0; i < num; i++) {
            arr[i] = scanner.nextInt();
        }

        int counter = 0;
        for (int i = 0; i < num; i++) {
            int sum = 0;
            for (int j = i; j < num; j++) {
                sum += arr[j];
                if (sum < 0) {
                    counter++;
                }
            }
        }

        System.out.println(counter);
    }
}