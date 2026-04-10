package Traversals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativePostOrder {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree{
        static int idx = -1;
        public static TreeNode buildTree(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }
            TreeNode newNode = new TreeNode(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }
    

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer>  postorder = new ArrayList<>();
        if(root == null){
            return postorder;
        }
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode curr = s.pop();
            if(curr.right!=null){
                s.push(curr.right);
            }
            if(curr.left!=null){
                s.push(curr.left);
            }
            postorder.add(curr.val);
        }
        return postorder;
    }

    @SuppressWarnings("static-access")
    public static void main(String args[]){
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        TreeNode root = tree.buildTree(nodes);
        List<Integer> list = new ArrayList<>();
        list = postorderTraversal(root);
        System.out.println(list);
    }
}
