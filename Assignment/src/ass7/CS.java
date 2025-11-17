package ass7;
import java.util.*;
public class CS {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 图的邻接表：u -> v (u 是前置，v 是后修)
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // 入度数组：inDegree[v] 表示 v 还有多少门课没修完（前置）
        int[] inDegree = new int[numCourses];

        // 建图 & 统计入度
        for (int[] edge : prerequisites) {
            int a = edge[0]; // 目标课
            int b = edge[1]; // 前置课
            graph.get(b).add(a);
            inDegree[a]++;
        }

        // 队列：存入度为 0 的课程
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] order = new int[numCourses];
        int idx = 0;

        // BFS 拓扑排序
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            order[idx++] = cur;

            for (int next : graph.get(cur)) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        // 如果没能把所有课程放进结果，说明有环 → 无法完成
        if (idx != numCourses) {
            return new int[0];
        }
        return order;
    }
}
