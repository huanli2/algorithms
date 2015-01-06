/* write a program to find the node at which the intersection of two singly linked lists begins.
 *
 * For example, the following two linked lists:
 * A:          a1 → a2
 *                    ↘
 *                      c1 → c2 → c3
 *                    ↗            
 * B:     b1 → b2 → b3
 * begin to intersect at node c1.
 *
 * Notes:
 *     If the two linked lists have no intersection at all, return null.
 *     The linked lists must retain their original structure after the function returns.
 *     You may assume there are no cycles anywhere in the entire linked structure.
 *     Your code should preferably run in O(n) time and use only O(1) memory.
 */

#include <iostream>

using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

int getLength(ListNode* head) {
    int res = 0;
    while(head) {
        ++res;
        head = head->next;
    }
    return res;
}

ListNode* removeHead(ListNode* head, int n) {
    while(n-- > 0 && head)
        head = head->next;
    return head;
}

ListNode* getIntersectionNode(ListNode* headA, ListNode* headB) {
    int lenA = getLength(headA);
    int lenB = getLength(headB);
    headA = removeHead(headA, lenA - lenB);
    headB = removeHead(headB, lenB - lenA);
    while(headA && headB) {
        if(headA == headB) return headA;
        headA = headA->next;
        headB = headB->next;
    }
    return NULL;
}

int main() {
    ListNode t0(3);
    ListNode t1(2);
    t1.next = &t0;
    ListNode* res = getIntersectionNode(&t0, &t1);
    if(res) cout << "Intersected at " << res->val << endl;
    else cout << "No intersection" << endl;
    return 0;
}
