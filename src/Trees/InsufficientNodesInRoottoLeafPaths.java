package Trees;

/**
 * https://leetcode.com/problems/insufficient-nodes-in-root-to-leaf-paths/
 */
public class InsufficientNodesInRoottoLeafPaths {

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

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        TreeNode node = new TreeNode();
        node.left = root;
        traverse(node.left, node, true, limit, 0);
        return node.left;
    }

    private int traverse(TreeNode node, TreeNode prev, boolean isLeft, int limit, int sum) {
        if (node == null) return sum;
        sum += node.val;
        if (node.left == null && node.right == null) {
            if (sum < limit) {
                if (isLeft) {
                    prev.left = null;
                } else {
                    prev.right = null;
                }
            }
            return sum;
        }

        int left = traverse(node.left, node, true, limit, sum);
        int right = traverse(node.right, node, false, limit, sum);
        if (left < limit) node.left = null;
        if (right < limit) node.right = null;
        if (left < limit && right < limit) {
            if (isLeft) {
                prev.left = null;
            } else {
                prev.right = null;
            }
        }
        return sum;
    }

    // https://leetcode.com/problems/insufficient-nodes-in-root-to-leaf-paths/discuss/308326/JavaC%2B%2BPython-Easy-and-Concise-Recursion
    public TreeNode sufficientSubsetBetterWay(TreeNode root, int limit) {
        if (root == null)
            return null;
        if (root.left == null && root.right == null)
            return root.val < limit ? null : root;
        root.left = sufficientSubset(root.left, limit - root.val);
        root.right = sufficientSubset(root.right, limit - root.val);
        return root.left == root.right ? null : root;
    }

    public static void main(String[] args) {
    }


}
