import java.util.*;

class Solution {
    public static void main(String[] argh) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {

            try {
                long x = sc.nextLong();

                System.out.println(x + " can be fitted in:");
                if ((byte) x == x)
                    System.out.println("* byte");

                if ((short) x == x)
                    System.out.println("* short");

                if ((int) x == x)
                    System.out.println("* int");

                if ((long) x == x)
                    System.out.println("* long");
            } catch (Exception e) {
                System.out.println(sc.next() + " can't be fitted anywhere.");
            }

        }

        sc.close();
    }
}