class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // dummy node banaya jo head se pehle hai
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode curr = dummy;
        
        while (curr.next != null) {
            if (curr.next.val == val) {
                // node ko skip kar diya
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        
        return dummy.next;
    }
}

