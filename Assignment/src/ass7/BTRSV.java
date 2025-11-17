package ass7;

import java.util.*;

public class BTRSV {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                if (cur.left != null)  q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
                if (i == sz - 1) res.add(cur.val); // 该层最后一个就是右视图
            }
        }
        return res;
    }
}
