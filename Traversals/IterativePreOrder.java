package Traversals;

import java.util.*;

public class IterativePreOrder {

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
    

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer>  preorder = new ArrayList<>();
        if(root == null){
            return preorder;
        }
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode curr = s.pop();
            preorder.add(curr.val);
            if(curr.right!=null){
                s.push(curr.right);
            }
            if(curr.left!=null){
                s.push(curr.left);
            }
        }
        return preorder;
    }

    @SuppressWarnings("static-access")
    public static void main(String args[]){
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        TreeNode root = tree.buildTree(nodes);
        List<Integer> list = new ArrayList<>();
        list = preorderTraversal(root);
        System.out.println(list);
    }
}
