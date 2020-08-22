import java.util.LinkedList;

public class LC143 {
    public void reorderList(ListNode head) {
        if(head == null)
            return;
        // 1-2-3-4-5
        // first split into two linked list
        // 1-2 & 3-4-5
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null ) {
            slow = slow.next;
            fast = fast.next;
            fast = fast.next;
        }

        // second reverse the second linked list (slow node will be the start of second half due to fast/slow iterate)
        // 1-2 & 5-4-3
        ListNode prev = null;
        ListNode current = slow;
        while(current != null){
            ListNode tmp = current.next;
            current.next = prev;
            prev = current;
            current = tmp;
        }


        // last merge two together (Now merge head & current)
        // 1-5-2-4-3
        ListNode a = head;
        ListNode b = prev;
        while(b.next != null){
            ListNode tmp = a.next;
            a.next = b;
            a = tmp;

            tmp = b.next;
            b.next = a;
            b = tmp;


        }

    }
}
