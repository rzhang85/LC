import java.util.Stack;

public class LC430 {
    public Node430 flatten(Node430 head) {
        if(head == null){
            return head;
        }

        Stack<Node430> stack = new Stack<>();
        stack.push(head);
        Node430 virtualHead = new Node430(0, null, head, null);   // keep track or head position
        Node430 prevNode = virtualHead;
        while(!stack.empty()){
            Node430 current = stack.pop();
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

class Node430 {
    public int val;
    public Node430 prev;
    public Node430 next;
    public Node430 child;
    public Node430(int val, Node430 prev, Node430 next, Node430 child){
        this.val = val;
        this.prev = prev;
        this.next = next;
        this.child = child;
    }
};