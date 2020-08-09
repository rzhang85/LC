import java.util.HashMap;

public class LC437 {


    public int total = 0;
    public int sum = 0;
    HashMap<Integer, Integer> hashmap = new HashMap<>();

    public int pathSum(TreeNode root, int sum) {
        this.sum = sum;
        preorder(root, 0);
        return total;
    }

    public void preorder(TreeNode node, int currSum){
        if(node == null)
            return;

        currSum += node.val;

        // first situation
        if(currSum == sum){
            total ++;
        }

        // second situation
        int diff = currSum - sum;
        total += hashmap.getOrDefault(diff, 0);

        hashmap.put(currSum, hashmap.getOrDefault(currSum, 0) + 1);

        // preorder left and right node
        preorder(node.left, currSum);
        preorder(node.right, currSum);

        // remove current sum from hashmap
        hashmap.put(currSum, hashmap.get(currSum) - 1);

    }

}
