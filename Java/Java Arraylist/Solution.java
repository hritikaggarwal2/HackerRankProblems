import java.util.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<ArrayList<Integer>> outerList = new ArrayList<ArrayList<Integer>>();
        int rowCountA = scanner.nextInt();

        for (int i = 0; i < rowCountA; i++) {
            ArrayList<Integer> innerList = new ArrayList<Integer>();
            int colCount = scanner.nextInt();

            for (int j = 0; j < colCount; j++) {
                innerList.add(scanner.nextInt());
            }

            outerList.add(innerList);
        }

        int rowCountB = scanner.nextInt();

        for (int i = 0; i < rowCountB; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            try {
                int num = outerList.get(a - 1).get(b - 1);
                System.out.println(num);
            } catch (Exception E) {
                System.out.println("ERROR!");
            }

        }

    }
}