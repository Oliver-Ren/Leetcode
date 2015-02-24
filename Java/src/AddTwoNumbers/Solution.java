package AddTwoNumbers;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    private int carry = 0;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            if (this.carry == 0) {
                return null;
            } else {
                return new ListNode(this.carry);
            }
        }
        int v1 = l1 == null ? 0 : l1.val;
        int v2 = l2 == null ? 0 : l2.val;
        int value = (v1 + v2 + this.carry) % 10;
        this.carry = (v1 + v2 + this.carry) / 10;
        ListNode thisDigit = new ListNode(value);
        thisDigit.next = addTwoNumbers(l1 == null ? null : l1.next, l2 == null ? null : l2.next);
        return thisDigit;
    }
}