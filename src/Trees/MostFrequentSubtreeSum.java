package Trees;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/most-frequent-subtree-sum/
 * 508. Most Frequent Subtree Sum
 */
public class MostFrequentSubtreeSum {


    /**
     * Definition for a binary tree node.
     */
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

    //solution

    int highestFreq = 0;
    int counter = 0;
    HashMap<Integer, Integer> hm = new HashMap<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        sum(root);
        int arr[] = new int[counter];
        int p = 0;
        for (int key : hm.keySet()) {
            if (hm.get(key) == highestFreq) {
                arr[p] = key;
                p++;
            }
        }
        return arr;
    }

    public int sum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = sum(node.left);
        int right = sum(node.right);

        int ans = left + right + node.val;
        int val = hm.getOrDefault(ans, 0) + 1;
        hm.put(ans, val);
        if (val > highestFreq) {
            highestFreq = val;
            counter = 1;
        } else if (val == highestFreq) {
            counter++;
        }
        return ans;
    }


    public static void main(String[] args) {

    }
}
