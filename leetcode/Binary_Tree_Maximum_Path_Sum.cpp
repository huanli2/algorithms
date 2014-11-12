
/* Given a binary tree, find the maximum path sum.
 *
 * The path may start and end at any node in the tree.
 *
 * For example:
 * Given binary tree {1,#,2,3},
 *     1
 *    / \
 *   2   3
 * Return 6.
 */
#include <iostream>
#include <vector>
#include <stack>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

int calMaxPath(TreeNode* root, int &maxSum) {
    if(root == NULL) return 0;
    int left = calMaxPath(root->left, maxSum);
    int right = calMaxPath(root->right, maxSum);
    maxSum = max(maxSum, left + right + root->val);
    return max(0, max(left, right) + root->val);
}

int maxPathSum(TreeNode *root) {
    if(root == NULL) return 0;
    int msum = root->val;
    calMaxPath(root, msum);
    return msum;
}

int main()
{
    TreeNode t0(9);
    TreeNode t1(6);
    TreeNode t2(-3);
    TreeNode t3(-6);
    TreeNode t4(2);
    TreeNode t5(2);
    TreeNode t6(-6);
    TreeNode t7(-6);
    TreeNode t8(-6);
    t0.left = &t1;
    t0.right = &t2;
    t2.left = &t3;
    t2.right = &t4;
    t4.left = &t5;
    t5.left = &t6;
    t5.right = &t7;
    t6.left = &t8;
    cout << maxPathSum(&t0) << endl;
    getchar();
    return 0;
}
