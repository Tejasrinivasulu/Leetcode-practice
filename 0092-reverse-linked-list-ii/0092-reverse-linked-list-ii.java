import java.util.*;
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        ListNode curr = prev.next;
        ListNode tail = curr;
        ListNode prevSub = null;
        ListNode next = null;

        for (int i = left; i <= right; i++) {
            next = curr.next;
            curr.next = prevSub;
            prevSub = curr;
            curr = next;
        }

        prev.next = prevSub;
        tail.next = curr;

        return dummy.next;
    }
}