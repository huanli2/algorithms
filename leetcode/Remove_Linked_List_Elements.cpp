/*
* Remove all elements from a linked list of integers that have value val.
*
* Example
* Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
* Return: 1 --> 2 --> 3 --> 4 --> 5
*/
#include <iostream>

using namespace std;

struct  ListNode
{
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

ListNode* removeElements(ListNode* head, int val) {
    ListNode vir(0);
    vir.next = head;
    ListNode* prev = &vir;
    ListNode* cur = head;
    while (cur) {
        if (val == cur->val) {
            prev->next = cur->next;
            cur = prev->next;
        }
        else {
            prev = prev->next;          
        }
        cur = prev->next;
    }
    return vir.next;
}

void printList(ListNode * head) {
    while (head) {
        cout << head->val << " ";
        head = head->next;
    }
    cout << endl;
}

int main() {
    ListNode l1(1);
    ListNode l2(2);
    ListNode l3(3);
    ListNode l4(4);
    ListNode l5(5);
    ListNode l6(6);

    l1.next = &l2;
    l2.next = &l3;
    l3.next = &l4;
    l4.next = &l5;
    l5.next = &l6;
    printList(&l1);
    printList(removeElements(&l1, 4));
    return 0;
}
