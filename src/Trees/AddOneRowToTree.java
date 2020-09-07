package Trees;

/**
 * https://leetcode.com/problems/add-one-row-to-tree/
 */
class AddOneRowToTree {

    // Definition for a binary tree node.
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

    TreeNode ans;

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        ans = root;
        if (d == 1) {
            ans = new TreeNode(v);
            ans.left = root;
            return ans;
        }
        add(root, v, 1, d);
        return ans;
    }


    public void add(TreeNode node, int v, int d, int n) {
        if (node == null) return;
        if (d == n - 1) {
            TreeNode tleft = node.left;
            node.left = new TreeNode(v);
            node.left.left = tleft;
            TreeNode tright = node.right;
            node.right = new TreeNode(v);
            node.right.right = tright;
        } else {
            add(node.left, v, d + 1, n);
            add(node.right, v, d + 1, n);
        }
    }
}