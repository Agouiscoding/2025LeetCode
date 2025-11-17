package ass7;

import java.util.*;

public class RO {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        int fresh = 0;

        // 1. 初始化：统计新鲜橘子，收集所有腐烂橘子
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) return 0; // 没有新鲜橘子

        int minutes = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        // 2. 多源 BFS
        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();
            minutes++; // 开始这一分钟
            for (int k = 0; k < size; k++) {
                int[] cur = q.poll();
                int x = cur[0], y = cur[1];
                for (int[] d : dirs) {
                    int nx = x + d[0];
                    int ny = y + d[1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                    if (grid[nx][ny] != 1) continue; // 不是新鲜橘子
                    grid[nx][ny] = 2; // 被感染
                    fresh--;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        return fresh == 0 ? minutes : -1;
    }
}
