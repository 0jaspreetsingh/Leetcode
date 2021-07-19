package CompanyQuestions;

public class SwapInvalidNodesInBinaryTree {

    private class TreeNode {
        int data;
        TreeNode left, right;
    }

    // to make them accessible by traverse method during recursion
    TreeNode first, middle, last, prev;

    private void fixTree(TreeNode root) {
        first = middle = last = prev = null;
        traverse(root);
        if (first != null && last != null) {
            // i.e both nodes were not adjacent in the tree
            swap(first, last);
        } else if (first != null && middle != null) {
            // i.e nodes were adjacent
            swap(first, middle);
        }
    }

    private void swap(TreeNode n1, TreeNode n2) {
        int temp = n1.data;
        n1.data = n2.data;
        n2.data = temp;
    }

    /**
     * finds the refrence to the first and the second treeNode whose place is not valid in a tree
     *
     * @param root
     */
    public void traverse(TreeNode root) {
        // no need to traverse further if all values are found already
        if (first != null && middle != null && last != null && prev != null) return;
        if (root != null) {
            traverse(root.left);
            if (prev != null && root.data < prev.data) {
                if (first == null) {
                    first = prev;
                    middle = root;
                } else {
                    last = root;
                }
            }
            prev = root;
            traverse(root.right);
        }
    }

}
