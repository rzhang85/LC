public class LC1022 {

    int total = 0;
    public int sumRootToLeaf(TreeNode root) {
        if(root == null)
            return total;
        DFS(root, 0);
        return total;
    }

    public void DFS(TreeNode node, int currentValue){
        if(node.left == null && node.right == null){
            total += currentValue * 2 + node.val;
        }
        if (node.left != null){
            DFS(node.left, currentValue * 2 + node.val);
        }
        if(node.right != null){
            DFS(node.right, currentValue * 2 + node.val);
        }

    }

}
