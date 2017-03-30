/* Given a singly linked list where elements are sorted in ascending order, 
 * convert it to a height balanced BST. 
 */

#include <iostream>

using namespace std;

struct ListNode {
    int val;
    ListNode* next;
    ListNode(int x) : val(x), next(NULL) {}
};

struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

void printByFirstOrder(TreeNode* root) {
    if(root) {
        cout << root->val << " ";
        printByFirstOrder(root->left);
        printByFirstOrder(root->right);
    }
}

TreeNode* generateBST(ListNode** head, int n) {
    if(n == 0) return NULL;
    TreeNode* node = new TreeNode((*head)->val);
    node->left = generateBST(head, n / 2);
    node->val = (*head)->val;
    *head = (*head)->next;
    node->right = generateBST(head, n - n / 2 - 1);
    return node;
}

TreeNode* sortedListToBST(ListNode* head) {
    int n = 0;
    ListNode* tmp = head;
    while(tmp) {
        tmp = tmp->next;
        ++n;
    }
    return generateBST(&head, n);
}

int main() {
    ListNode l1(3);
    ListNode l2(5);
    ListNode l3(8);
    l1.next = &l2;
    l2.next = &l3;
    printByFirstOrder(sortedListToBST(&l1));
    cout << endl;
    return 0;
}

