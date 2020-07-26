import java.util.*;

class Solution {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] argh) {
        while (sc.hasNext()) {
            String input = sc.next();
            System.out.println(checkStack(input.toCharArray()));
        }

        sc.close();
    }

    private static boolean checkStack(char[] input) {
        Stack<Character> stack = new Stack<>();

        for (char curr : input) {
            if (curr == '(' || curr == '[' || curr == '{') {
                stack.push(curr);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }

            char popped = stack.pop();
            if ((popped == '(' && curr != ')') || (popped == '[' && curr != ']') || (popped == '{' && curr != '}')) {
                return false;
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }
}
