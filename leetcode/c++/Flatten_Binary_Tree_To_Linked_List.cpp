/* Given a binary tree, flatten it to a linked list in-place.
 *
 * For example,
 *  Given
 *            1
 *           / \
 *          2   5
 *         / \   \
 *        3   4   6
 *  The flattened tree should look like:
 *        1
 *         \
 *          2
 *           \
 *            3
 *             \
 *              4            
 *               \
 *                5          
 *                 \
 *                  6
 */

#include <iostream>

using namespace std;

struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

TreeNode* transfer(TreeNode* root) {
    if(root == NULL || 
       (root->left == NULL && root->right == NULL)) 
        return root;
    TreeNode* left = transfer(root->left);
    TreeNode* right = transfer(root->right);
    if(left != NULL) {
        left->right =root->right;
        root->right = root->left;
        root->left = NULL;
    }
    if(right != NULL) return right;
    else return left;
}

void flatten(TreeNode* root) {
    transfer(root);
}

void printByFirstOrder(TreeNode* root) {
    if(root) {
        cout << root->val << " ";
        printByFirstOrder(root->left);
        printByFirstOrder(root->right);
    }
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
    cout << endl;
    flatten(&t0);
    printByFirstOrder(&t0);
    cout << endl;
    return 0;
}
