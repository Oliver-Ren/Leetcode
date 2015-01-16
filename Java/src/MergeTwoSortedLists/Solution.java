package MergeTwoSortedLists;
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead =  new ListNode(0);
        mergeLists(l1,l2,dummyHead);
        return dummyHead.next;
    }
    
    public void mergeLists(ListNode l1, ListNode l2, ListNode current){
        if ( (l1 == null && l2 == null) || current == null) return;
        else if ( l1 != null && l2 != null){
            if (l1.val < l2.val){
                current.next = l1;
                l1 = l1.next;
            }
            else{
                current.next = l2;
                l2 = l2.next;
            }
        }
        else if ( l1 == null && l2 != null){
            current.next = l2;
            l2 = l2.next;
        }
        else if ( l1 != null && l2 == null){
            current.next = l1;
            l1 = l1.next;
        }
        mergeLists(l1,l2,current.next);
    }
}
