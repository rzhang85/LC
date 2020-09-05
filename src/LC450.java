public class LC450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return null;

        if(root.val < key){
            root.right = deleteNode(root.right, key);
        }
        else if (root.val > key){
            root.left = deleteNode(root.left, key);
        }
        else{ // delete current node;
            if (root.left == null && root.right == null)
                root = null;
            else if(root.right != null){        // by default, bring it's successor to this position, then delete successor node
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
            }
            else {
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }

        }

        return root;
    }

    public int predecessor(TreeNode node){ // the one just less than current node
        node = node.left;
        while(node.right != null)
            node = node.right;
        return node.val;
    }

    public int successor(TreeNode node){ // the one just greater than current node
        node = node.right;
        while(node.left != null)
            node = node.left;
        return node.val;
    }

}
