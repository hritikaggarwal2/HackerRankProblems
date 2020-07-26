import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
         * class should be named Solution.
         */
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            list.add(scan.nextInt());
        }

        int operationCount = scan.nextInt();

        for (int i = 0; i < operationCount; i++) {
            String opt = scan.next();
            if (opt.equalsIgnoreCase("Insert")) {
                list.add(scan.nextInt(), scan.nextInt());
            } else if (opt.equalsIgnoreCase("Delete")) {
                list.remove(scan.nextInt());
            }
        }

        for (Integer i : list) {
            System.out.print(i + " ");
        }

        scan.close();
    }
}