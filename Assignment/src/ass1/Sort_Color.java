package ass1;

public class Sort_Color {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int low = 0;         // 下一个 0 应该放到的位置
        int mid = 0;         // 当前处理的位置
        int high = n - 1;    // 下一个 2 应该放到的位置

        // 不变式（Invariant）：
        // [0..low-1] 全是 0
        // [low..mid-1] 全是 1
        // [mid..high] 未处理
        // [high+1..n-1] 全是 2
        while (mid <= high) {
            if (nums[mid] == 0) {
                // 把 0 交换到前面区域
                swap(nums, mid, low);
                low++;
                mid++; // mid位置换来的一定是1（或同为0），可直接越过
            } else if (nums[mid] == 1) {
                // 1 已经在中间区域，无需处理
                mid++;
            } else { // nums[mid] == 2
                // 把 2 交换到后面区域
                swap(nums, mid, high);
                high--;
                // 注意：此时 mid 不++，因为换过来的元素还未检查
            }
        }
    }
    private void swap(int[] a, int i, int j) {
        if (i == j) return;
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
