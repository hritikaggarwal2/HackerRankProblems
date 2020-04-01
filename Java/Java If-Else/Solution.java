import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        method(N);
        scanner.close();
    }

    public static void method(int num) {
        if (num % 2 != 0 || (num <= 20 && num >=6)) {
            System.out.println("Weird");
        } else if ((num <= 5 && num >=2) || num > 20) {
            System.out.println("Not Weird");
        }
    }
}