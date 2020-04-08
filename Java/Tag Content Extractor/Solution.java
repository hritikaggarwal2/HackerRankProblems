import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		
        while(testCases > 0){
			String line = in.nextLine();
            boolean found = false;

            Matcher m = Pattern.compile("<(.+)>([^<]+)</\\1>").matcher(line);
            
            while (m.find()) {
                found = true;
                System.out.println(m.group(2));
            }

            if (!found) {
                System.out.println("None");
            }

			testCases--;
		}

        in.close();
	}
}