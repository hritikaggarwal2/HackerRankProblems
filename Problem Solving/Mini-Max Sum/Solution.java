import java.util.*;

public class Solution {

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
        PriorityQueue<Integer> pqSmall = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pqLarge = new PriorityQueue<>();

        for (int i : arr) {
            if (pqSmall.size() < 4) {
                pqSmall.add(i);
            } else {
                int store = pqSmall.remove();
                if (store > i) {
                    pqSmall.add(i);
                } else {
                    pqSmall.add(store);
                }
            }

            if (pqLarge.size() < 4) {
                pqLarge.add(i);
            } else {
                int store = pqLarge.remove();
                if (store < i) {
                    pqLarge.add(i);
                } else {
                    pqLarge.add(store);
                }
            }
        }

        long low = 0;
        for (int i : pqSmall) {
            low += i;
        }

        long high = 0;
        for (int i : pqLarge) {
            high += i;
        }

        System.out.println(low + " " + high);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}
