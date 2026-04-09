package Traversals;

import java.util.*;


public class LevelOrderTraversal {

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

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        List<Integer> list = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode curr = q.remove();
            if(curr==null){
                res.add(list);
                list = new ArrayList<>();
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{   
                list.add(curr.val);
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
        }
        return res;
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

    @SuppressWarnings("static-access")
    public static void main(String args[]){
        int nodes[] = {3, 9, -1, -1, 20, 15, -1, -1, 7, -1, -1};
        BinaryTree tree = new BinaryTree();
        TreeNode root = tree.buildTree(nodes);
        List<List<Integer>> list = new ArrayList<>();
        list = levelOrder(root);
        System.out.println(list);

    }
}
