import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
         * class should be named Solution.
         */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        BitSet B1 = new BitSet(N);
        BitSet B2 = new BitSet(N);

        int M = sc.nextInt();

        for (int i = 0; i < M; i++) {
            String command = sc.next();
            command = command.toUpperCase();
            int o1 = sc.nextInt();
            int o2 = sc.nextInt();

            if (o1 == 1) {
                execute(command, B1, B2, o2);
            } else {
                execute(command, B2, B1, o2);
            }

            System.out.println(B1.cardinality() + " " + B2.cardinality());
        }

        sc.close();
    }

    private static void execute(String command, BitSet B1, BitSet B2, int o2) {
        switch (command) {
            case "AND":
                B1.and(B2);
                break;
            case "OR":
                B1.or(B2);
                break;
            case "XOR":
                B1.xor(B2);
                break;
            case "FLIP":
                B1.flip(o2);
                break;
            case "SET":
                B1.set(o2);
            default:
                break;
        }
    }

}