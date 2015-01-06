/* Given two binary trees, write a function to check if they are equal or not.
 *
 * Two binary trees are considered equal if 
 * they are structurally identical and the nodes have the same value.
 */

#include <iostream>

using namespace std;

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

bool isSameTree(TreeNode* p, TreeNode *q) {
    if(p == NULL) return q == NULL;
    if(q == NULL) return false;
    if(p->val == q->val)
        return (isSameTree(p->left, q->left) &&
            isSameTree(p->right, q->right));
    return false;
}

int main() {
    TreeNode t1(1);
    TreeNode t2(2);
    TreeNode t3(3);
    t1.left = &t2;
    t1.right = &t3;
    cout << isSameTree(&t1, NULL) << endl;
    cout << isSameTree(&t1, &t1) << endl;
    return 0;
}

