/* Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined 
 * as a binary tree in which the depth of the two subtrees of 
 * every node never differ by more than 1.
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

bool isBalancedTree(TreeNode *root, int &depth) {
    if(root == NULL) return true;
    int leftdepth = 0;
    int rightdepth = 0;
    if(!isBalancedTree(root->left, leftdepth)) return false;
    if(!isBalancedTree(root->right, rightdepth)) return false;
    if(abs(rightdepth - leftdepth) > 1) return false;
    depth = max(leftdepth, rightdepth) + 1;
    return true;
}

bool isBalanced(TreeNode *root) {
    int depth = 0;
    return isBalancedTree(root, depth);
}

int main() {
    TreeNode t0(1);
    TreeNode t1(2);
    TreeNode t2(3);
    TreeNode t3(4);
    TreeNode t4(5);
    TreeNode t5(6);
    t0.left = &t1;
    t0.right = &t4;
    t1.left = &t2;
    t1.right = &t3;
    t4.right = &t5;
    printByFirstOrder(&t0);
    cout << endl << isBalanced(&t0) <<endl;
    return 0;
}
