package ass2;

import java.util.ArrayList;
import java.util.List;

public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int n = s.length(), m = p.length();
        if (n < m) return res;

        int[] freq = new int[26];
        for (char c : p.toCharArray()) {
            freq[c - 'a']++;  // 统计 p 的需求
        }

        int need = m; // 还需要匹配的字符总数
        int left = 0;

        for (int right = 0; right < n; right++) {
            int in = s.charAt(right) - 'a';
            // 扩窗加入 s[right]
            if (freq[in] > 0) {
                need--;        // 这是一个我们需要的字符
            }
            freq[in]--;        // 不管需不需要，都要占一个频次位

            // 保证窗口长度不超过 m
            if (right - left + 1 > m) {
                int out = s.charAt(left) - 'a';
                // 移出 s[left]，如果移出前 freq[out] >= 0，说明这是之前有效匹配的字符
                if (freq[out] >= 0) {
                    need++;
                }
                freq[out]++;   // 归还频次
                left++;
            }

            // 窗口长度正好为 m 且 need==0，记录起点
            if (right - left + 1 == m && need == 0) {
                res.add(left);
            }
        }

        return res;
    }
}
