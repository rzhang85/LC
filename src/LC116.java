import java.util.LinkedList;
import java.util.Queue;

public class LC116 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node head = root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if(current != null){
                current.next = queue.peek();
                if(current.left != null && current.right != null){
                    queue.add(current.left);
                    queue.add(current.right);
                }
                if (queue.peek() == null){
                    queue.add(null);
                }
            }
        }

        return head;
    }
}

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

