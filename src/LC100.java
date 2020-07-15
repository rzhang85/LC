import java.util.LinkedList;

public class LC100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if(p == null && q != null || p != null && q == null){
            return false;
        }
        if(p.val != q.val){
            return false;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);
        while(queue.size() > 0){
            TreeNode first = queue.removeFirst();
            TreeNode second = queue.removeFirst();
            if(first == null && second == null){
                continue;
            }
            if(first == null && second != null || first != null && second == null){
                return false;
            }
            if(first.val != second.val)
                return false;

            // add into queue in order
            queue.add(first.left);
            queue.add(second.left);
            queue.add(first.right);
            queue.add(second.right);

        }
        return true;
    }
}
