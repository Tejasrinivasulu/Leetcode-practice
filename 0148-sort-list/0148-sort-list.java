/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
         if (head == null || head.next == null) return head;

        // Convert LinkedList to ArrayList
        List<Integer> arr = new ArrayList<>();
        ListNode curr = head;

        while (curr != null) {
            arr.add(curr.val);
            curr = curr.next;
        }

        // Inbuilt sorting
        Collections.sort(arr);

        // Put sorted values back into linked list
        curr = head;
        for (int val : arr) {
            curr.val = val;
            curr = curr.next;
        }

        return head;
    }
}