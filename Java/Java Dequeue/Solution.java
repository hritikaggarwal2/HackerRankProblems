import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();

        int n = in.nextInt();
        int m = in.nextInt();
        int maxCounter = 0;

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();

            if (m <= i) {
                int removed = deque.removeFirst();
                if (map.get(removed) == 1) {
                    map.remove(removed);
                } else {
                    map.put(removed, map.get(removed) - 1);
                }
            }

            if (!map.containsKey(num)) {
                map.put(num, 0);
            }

            deque.addLast(num);
            map.put(num, map.get(num) + 1);

            if (maxCounter < map.size()) {
                maxCounter = map.size();
            }

            if (maxCounter == m) {
                break;
            }
        }

        in.close();
        System.out.println(maxCounter);
    }
}
