import java.util.*;

public class LC103 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null)
            return result;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);    // used to split level of nodes

        boolean leftToRight = true;
        LinkedList<Integer> values = new LinkedList<>();

        while(!queue.isEmpty()){
            TreeNode current = queue.pollFirst();
            if(current != null){
                if(leftToRight)
                    values.add(current.val);
                else
                    values.addFirst(current.val);

                // add child to queue
                if(current.left != null)
                    queue.add(current.left);
                if(current.right != null)
                    queue.add(current.right);

            }
            else{ // end of current level
                result.add(values);
                values = new LinkedList<>();
                leftToRight = ! leftToRight;
                if(!queue.isEmpty())
                    queue.add(null);    // used to split level of nodes
            }

        }


        return result;
    }
}
