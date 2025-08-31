package Day38;
import java.util.*;

class DailyTemperatures {
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Deque<Integer> stack = new ArrayDeque<>(); // stack stores indices

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                result[idx] = i - idx;  // distance to next warmer day
            }
            stack.push(i);
        }
        return result;
    }

    // Quick demo
    public static void main(String[] args) {
        int[] t1 = {30, 38, 30, 36, 35, 40, 28};
        System.out.println(Arrays.toString(dailyTemperatures(t1))); 
        // Output: [1, 4, 1, 2, 1, 0, 0]

        int[] t2 = {22, 21, 20};
        System.out.println(Arrays.toString(dailyTemperatures(t2))); 
        // Output: [0, 0, 0]
    }
}
