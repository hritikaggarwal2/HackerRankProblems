import java.util.*;
import java.security.MessageDigest;

public class Solution {

    public static void main(String[] args) throws Throwable {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
         * class should be named Solution.
         */
        Scanner scan = new Scanner(System.in);
        MessageDigest md = MessageDigest.getInstance("MD5");

        String toEncode = scan.next();
        scan.close();

        byte[] mdBytes = md.digest(toEncode.getBytes());

        for (byte perByte : mdBytes) {
            System.out.printf("%02x", perByte);
        }

        System.out.println();
    }
}