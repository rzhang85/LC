public class LC270 {

    public int closestValue(TreeNode root, double target) {
        int cloest = root.val;
        while(root != null){
            int val = root.val;

            // compare current node with cloest value so fat has seen
            cloest = Math.abs(cloest - target) < Math.abs(val - target) ? cloest : val;

            // go deeper on this tree
            if(target < val)
                root = root.left;
            else
                root = root.right;

        }

        return cloest;
    }

}
