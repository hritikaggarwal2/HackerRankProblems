import java.util.*;

public class Solution {

    public static boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.
        return canWin(leap, game, 0);
    }

    private static boolean canWin(int leap, int[] game, int index) {
        if (index >= game.length) {
            return true;
        }

        if (index < 0 || game[index] == 1) {
            return false;
        }

        game[index] = 1;

        return canWin(leap, game, index + 1) || canWin(leap, game, index - 1) || canWin(leap, game, index + leap);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println((canWin(leap, game)) ? "YES" : "NO");
        }
        scan.close();
    }
}