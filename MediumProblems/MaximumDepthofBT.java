package MediumProblems;

public class MaximumDepthofBT {

    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static int idx = -1;
    static class BinaryTree{
        public static TreeNode buildPreorder(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }
            TreeNode newNode = new TreeNode(nodes[idx]);
            newNode.left = buildPreorder(nodes);
            newNode.right = buildPreorder(nodes);
            return newNode;
        }
    }

    public static int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }

    @SuppressWarnings("static-access")
    public static void main(String args[]){
        int nodes[] = {3, 9, -1, -1, 20, 15, -1, -1, 7, -1, -1};
        BinaryTree tree = new BinaryTree();
        TreeNode root = tree.buildPreorder(nodes);
        int depth = maxDepth(root);
        System.out.println(depth);
    }
}
