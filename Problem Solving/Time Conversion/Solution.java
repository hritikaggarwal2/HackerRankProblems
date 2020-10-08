import java.io.*;
import java.util.*;

public class Solution {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        /*
         * Write your code here.
         */
        String[] split = s.split(":");
        String isAm = split[2].substring(2);

        int hour = Integer.parseInt(split[0]);
        if (hour == 12) {
            hour = 0;
        }

        if (!isAm.equalsIgnoreCase("AM")) {
            hour += 12;
        }

        String time = hour < 10 ? "0" + hour : "" + hour;
        time += ":" + split[1] + ":" + split[2].substring(0, 2);

        return time;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
