package Trees;

/**
 * https://leetcode.com/problems/delete-node-in-a-bst/
 */
public class DeleteInBST {


    //  Definition for a binary tree node.
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

    TreeNode curr, prev;

    public TreeNode deleteNode(TreeNode root, int key) {
        this.curr = root;
        this.prev = null;
        find(curr, prev, key);
        if (prev == null) {
            return deleteRoot(curr);
        } else {
            if (prev.left == curr) {
                prev.left = deleteRoot(curr);
            } else {
                prev.right = deleteRoot(curr);
            }
        }
        return root;
    }

    // important
    private TreeNode deleteRoot(TreeNode node) {
        if (node == null) return node;
        if (node.left == null) return node.right;
        if (node.right == null) return node.left;
        TreeNode previous = null;
        TreeNode current = node.right;
        while (current.left != null) {
            previous = current;
            current = current.left;
        }
        current.left = node.left;
        if (node.right != current) {
            previous.left = current.right;
            current.right = node.right;
        }
        return current;
    }

    private void find(TreeNode curr, TreeNode prev, int key) {
        if (curr == null || curr.val == key) {
            this.curr = curr;
            this.prev = prev;
            return;
        }
        if (curr.val < key) {
            find(curr.right, curr, key);
        } else {
            find(curr.left, curr, key);
        }
    }
}
