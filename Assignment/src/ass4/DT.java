package ass4;

import java.util.*;

class DT {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>(); // 存索引，保持温度递减

        for (int i = 0; i < n; i++) {
            int t = temperatures[i];
            while (!stack.isEmpty() && temperatures[stack.peek()] < t) {
                int j = stack.pop();
                ans[j] = i - j; // i 是 j 之后第一个更高温度的天
            }
            stack.push(i);
        }
        return ans; // 栈里剩余的默认为 0
    }
}
