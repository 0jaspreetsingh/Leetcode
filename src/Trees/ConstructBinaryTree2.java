package Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class ConstructBinaryTree2 {


    //Definition for a binary tree node.
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


    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            hm.put(inorder[i], i);
        }
        return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1, hm);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int indorderLeft, int indorderRight, int postorderStart, int postOrderEnd, HashMap<Integer, Integer> hm) {
        if (postorderStart > postOrderEnd || indorderLeft > indorderRight) {
            return null;
        }

        TreeNode node = new TreeNode(postorder[postOrderEnd]);
        int mid = hm.get(postorder[postOrderEnd]);

        //check the count of how many nodes will be left and right children from the inorder node index
        //then divide postorder array based on these values
        node.left = buildTree(inorder, postorder, indorderLeft, mid - 1, postorderStart, postorderStart + mid - indorderLeft - 1, hm);
        node.right = buildTree(inorder, postorder, mid + 1, indorderRight, postorderStart + mid - indorderLeft, postOrderEnd - 1, hm);
        return node;
    }

    public static void main(String[] args) {
        int inorder[] = {9, 3, 15, 20, 7}, postorder[] = {9, 15, 7, 20, 3};
        ConstructBinaryTree2 sb = new ConstructBinaryTree2();
        System.out.println(sb.buildTree(inorder, postorder));
    }
}
