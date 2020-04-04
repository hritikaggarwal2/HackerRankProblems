import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();

        /* Enter your code here. Print output to STDOUT. */
        System.out.println(A.length() + B.length());
        if (A.compareTo(B) <= 0) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }

        System.out.println(capitalFirstLetter(A) + " " + capitalFirstLetter(B));
    }

    public static String capitalFirstLetter(String word) {
        if (word != null && word.length() > 0) {
            return word.substring(0, 1).toUpperCase() + word.substring(1);
        }

        return "";
    }
}