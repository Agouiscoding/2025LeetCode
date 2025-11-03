package ass4;

public class People {
    private static final int MOD = 1_000_000_007;

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long[] newKnow = new long[n + 1]; // newKnow[i]: 第 i 天新知道的人数
        long share = 0;                  // share: 第 i 天会分享的人数（滚动维护）

        newKnow[1] = 1; // 第 1 天有 1 人知道

        for (int day = 2; day <= n; day++) {
            // 滚动更新 share：进入分享的人（day - delay），退出的人（day - forget）
            int start = day - delay;
            if (start >= 1) {
                share = (share + newKnow[start]) % MOD;
            }
            int stop = day - forget;
            if (stop >= 1) {
                share = (share - newKnow[stop]) % MOD;
                if (share < 0) share += MOD;
            }

            // 当天新知道的人等于当天会分享的人
            newKnow[day] = share;
        }

        // 统计第 n 天仍未遗忘的人数：最近 forget-1 天内的新知
        long ans = 0;
        for (int day = Math.max(1, n - forget + 1); day <= n; day++) {
            ans = (ans + newKnow[day]) % MOD;
        }
        return (int) ans;
    }
}
