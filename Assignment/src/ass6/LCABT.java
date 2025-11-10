package ass6;

public class LCABT {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 基本情况：空、命中 p 或 q
        if (root == null || root == p || root == q) return root;

        // 在左右子树分别寻找
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 若左右均非空，当前节点即为 LCA
        if (left != null && right != null) return root;

        // 否则返回非空的一侧（可能是命中节点，也可能是更下方的 LCA）
        return (left != null) ? left : right;
    }
}
