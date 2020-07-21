public class LC203 {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null)
            return null;
        ListNode tmp = head;
        while(tmp.next != null){
            if(tmp.next.val == val){
                tmp.next = tmp.next.next;
            }
            else{
                tmp = tmp.next;
            }
        }
        if(head.val == val)
            return head.next;
        return head;
    }
}



class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
