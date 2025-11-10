package ass6;

import java.util.*;

public class TKFE {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums) freq.put(x, freq.getOrDefault(x, 0) + 1);

        // 最小堆：按频次升序
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            pq.offer(new int[]{e.getKey(), e.getValue()});
            if (pq.size() > k) pq.poll();
        }

        int[] ans = new int[k];
        int i = 0;
        while (!pq.isEmpty()) {
            ans[i++] = pq.poll()[0];
        }
        return ans;
    }
}
