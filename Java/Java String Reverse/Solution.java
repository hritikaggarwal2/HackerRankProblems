import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        boolean flag = true;
        
        /* Enter your code here. Print output to STDOUT. */
        int len = A.length();
        for (int i = 0; i < len / 2; i++) {
            if (A.charAt(i) != A.charAt(len - 1 - i)) {
                flag = false;
            }
        }

        if (flag) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}