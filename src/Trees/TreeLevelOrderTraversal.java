package Trees;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/n-ary-tree-level-order-traversal/submissions/
 */
public class TreeLevelOrderTraversal {


// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};



        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> ans = new ArrayList<>();

            if(root==null){
                return ans;
            }
            List<Integer> temp = new ArrayList<>();
            ans.add(temp);
            temp.add(root.val);
            int index = 0;
            ans(ans,root,index+1);

            return ans;

        }

        private void ans(List<List<Integer>> ans,Node root,int index){
            if(root==null){
                return ;
            }
            List<Node> children = root.children;
            if(children==null||children.size()==0){
                return ;
            }
            List<Integer> temp;
            if(index<ans.size()){
                temp = ans.get(index);
            }else{
                temp = new ArrayList<>();
                ans.add(temp);
            }
            for(Node ch: children){
                temp.add(ch.val);
                ans(ans,ch,index+1);
            }

    }
}
