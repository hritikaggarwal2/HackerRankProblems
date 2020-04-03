import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int totalLines = 0;
        
        while (in.hasNextLine()) {
            String line = in.nextLine();
            totalLines++;

            System.out.println(totalLines + " " + line);
        }
        
        in.close();
    }
}