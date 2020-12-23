package Trees;

/**
 * https://leetcode.com/problems/flip-equivalent-binary-trees/
 */
public class FlipTrees {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }
        if (root1.left == null && root2.left == null) {
            return flipEquiv(root1.right, root2.right);
        }

        if (root1.left == null || root2.left == null || (root1.left.val != root2.left.val)) {
            TreeNode temp = root2.left;
            root2.left = root2.right;
            root2.right = temp;
        }


        return flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);

    }
}
