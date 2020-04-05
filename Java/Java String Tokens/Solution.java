import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        // Write your code here.
        s = s.replaceAll("[!?,._'@]", " ");
        s = s.replaceAll("[ ]+", " ").trim();
        
        String[] splitString = s.split(" ");

        if (splitString.length == 1 && splitString[0].equals("")) {
            System.out.println(0);
        } else {
            System.out.println(splitString.length);
            for (String word: splitString) {
                System.out.println(word);
            }
        }
        
        scan.close();
    }
}