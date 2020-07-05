public class LC129 {
    int total_sum = 0;

    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        DFS(root, 0);
        return total_sum;
    }

    public void DFS(TreeNode root, int currentNum) {
        currentNum = currentNum * 10 + root.val;
        if (root.left == null && root.right == null) {
            total_sum += currentNum;
        }
        else if(root.left == null){
            DFS(root.right, currentNum);
        }
        else if(root.right == null){
            DFS(root.left, currentNum );
        }
        else {
            DFS(root.left, currentNum );
            DFS(root.right, currentNum);
        }

    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
