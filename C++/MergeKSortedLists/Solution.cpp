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
    ListNode *mergeKLists(vector<ListNode *> &lists) {
        if (lists.size() == 0) return nullptr;
        ListNode *first = lists[0];
        return partition(lists, 0, lists.size() - 1);
    }

private:
    ListNode *partition(vector<ListNode *> &lists, int left, int right) {
        if (right - left == 1) {
            return mergeTwoLists(lists[left], lists[right]);
        }
        if (right == left) {
            return lists[left];
        }
        int middle = (left + right) / 2;
        return mergeTwoLists(partition(lists, left, middle), partition(lists, middle + 1, right));
    }
    ListNode *mergeTwoLists(ListNode* listLeft, ListNode* listRight) {
        ListNode dummy(-1);
        ListNode *current = &dummy;
        while (listLeft != nullptr && listRight != nullptr) {
            if (listLeft->val < listRight->val) {
                current->next = listLeft;
                listLeft = listLeft->next;
            } else {
                current->next = listRight;
                listRight = listRight->next;
            }
            current = current->next;
        }
        
        if (listLeft != nullptr) {
            current->next = listLeft;
        } else {
            current->next = listRight;
        }
        return dummy.next;
    }
    
};