import javafx.util.Pair;

import java.util.LinkedList;

public class LC662 {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }

        int maxWidth = 0;

        LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 1));

        while(queue.size() > 0){
            // keep first node in this level.
            Pair<TreeNode, Integer> left = queue.getFirst();

            // loop through every node in this level, poll each of them and push their children
            Pair<TreeNode, Integer> current = null;
            int levelSize = queue.size();
            for(int i = 0; i < levelSize; i ++){
                current = queue.poll();
                // add left child
                if(current.getKey().left != null){
                    queue.add(new Pair<>(current.getKey().left, current.getValue() * 2));
                }
                // add right child
                if(current.getKey().right != null){
                    queue.add(new Pair<>(current.getKey().right, current.getValue() * 2 + 1));
                }

            }

            maxWidth = Math.max(maxWidth, current.getValue() - left.getValue() + 1);
        }

        return maxWidth;
    }
}
