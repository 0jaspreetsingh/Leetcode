package Trees;

/**
 * todo
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class ConstructBinaryTree {


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


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        boolean processed[] = new boolean[len];
        int in_start = 0, pre_start = 0, end = len - 1;
        return buildTree(preorder, inorder, 0, end, 0, end);
    }


    private TreeNode buildTree(int[] preorder, int[] inorder, int pre_start, int pre_end, int in_start, int in_end) {
        if (pre_start > pre_end) {
            return null;
        }
        TreeNode ans = new TreeNode(preorder[pre_start]);
        int mid = -1;
        for (int i = in_start; i <= in_end; i++) {
            if (inorder[i] == ans.val) {
                mid = i;
                break;
            }
        }
        int lpreS = pre_start + 1;
        int lpreE = pre_start + mid - in_start;
        int linS = in_start;
        int linE = mid - 1;
        int RpreS = pre_start + mid - in_start + 1;
        int RpreE = pre_end;
        int RinS = mid + 1;
        int RinE = in_end;
        ans.left = buildTree(preorder, inorder, lpreS, lpreE, linS, linE);
        ans.right = buildTree(preorder, inorder, RpreS, RpreE, RinS, RinE);
        return ans;
    }


    public static void main(String[] args) {
        int preorder[] = {3, 9, 20, 15, 7}, inorder[] = {9, 3, 15, 20, 7};
        ConstructBinaryTree c = new ConstructBinaryTree();
        c.buildTree(preorder, inorder);
    }
}
