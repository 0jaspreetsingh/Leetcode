package Trees;

/**
 * https://leetcode.com/problems/house-robber-iii/
 */
public class HouseRobber3 {


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

    int maxProfit = Integer.MIN_VALUE;

    public int rob(TreeNode root) {
        canRob(root, 1, 0, 0);
        return maxProfit;
    }

    private int canRob(TreeNode node, int depth, int ans, int prev) {

        maxProfit = Math.max(maxProfit, ans);

        if (node == null) {
            return ans;
        }

        int ans1;

        if (prev > depth - 1) {
            //choose
            ans1 = canRob(node.left, depth + 1, ans + node.val, depth) + canRob(node.right, depth + 1, ans + node.val, depth) - node.val;

        } else {
            //reset ans to zero if you want to choose
            //choose
            ans1 = canRob(node.left, depth + 1, node.val, depth) + canRob(node.right, depth + 1, node.val, depth) - node.val;

        }


        //discard
        int ans2 = canRob(node.left, depth + 1, ans, prev) + canRob(node.right, depth + 1, ans, prev) - ans;

        return Math.max(ans1, ans2);
    }
}
