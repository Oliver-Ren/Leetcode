/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *swapPairs(ListNode *head) {
        if (head == nullptr) return head;
        ListNode dummy(-1);
        dummy.next = head;
        ListNode *prev = &dummy;
        ListNode *curr = head;
        ListNode *next;
        while (curr != nullptr) {
            next = curr->next;
            if (next == nullptr) break;
            prev->next = next;
            curr->next = next->next;
            next->next = curr;
            prev = curr;
            curr = curr->next;
        }
        return dummy.next;
    }
};