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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
         ArrayList<Integer> list = new ArrayList<>();

        // add list1 values
        while (list1 != null) {
            list.add(list1.val);
            list1 = list1.next;
        }

        // add list2 values
        while (list2 != null) {
            list.add(list2.val);
            list2 = list2.next;
        }

        // sort values
        Collections.sort(list);

        // convert ArrayList back to Linked List
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        for (int val : list) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }

        return dummy.next;
    }
}