public class OddEvenLinkedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * LeetCode Stats:
     * Runtime: 0 ms, faster than 100.00% of Java online submissions.
     * Memory Usage: 39.4 MB, less than 5.00% of Java online submissions.
     * */
    public ListNode oddEvenList(ListNode head) {
        if(head == null)
            return null;

        ListNode odd = head;
        ListNode evenHead = head.next;
        ListNode even = evenHead;

        while(even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
