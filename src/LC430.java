import java.util.Stack;

public class LC430 {
    public Node flatten(Node head) {
        if(head == null){
            return head;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(head);
        Node virtualHead = new Node(0, null, head, null);   // keep track or head position
        Node prevNode = virtualHead;
        while(!stack.empty()){
            Node current = stack.pop();
            prevNode.next = current;
            current.prev = prevNode;

            // push next to the bottom in stack, so that we can pop child first
            if(current.next != null){
                stack.push(current.next);
            }
            if(current.child != null){
                stack.push(current.child);
                current.child = null;   // clean child
            }
            // move prevNode forward
            prevNode = prevNode.next;


        }
        virtualHead.next.prev = null;   // set head.prev to null;
        return virtualHead.next;
    }
}

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
    public Node(int val, Node prev, Node next, Node child){
        this.val = val;
        this.prev = prev;
        this.next = next;
        this.child = child;
    }
};