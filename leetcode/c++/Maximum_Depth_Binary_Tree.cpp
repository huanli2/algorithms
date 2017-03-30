
/* Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path 
 * from the root node down to the farthest leaf node.
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

int maxDepth(TreeNode *root) {
    if(root == NULL) return 0;
    int leftDepth = maxDepth(root->left) + 1;
    int rightDepth = maxDepth(root->right) + 1;
    return leftDepth > rightDepth ? leftDepth : rightDepth;
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
    cout << maxDepth(&t0) << endl;
    getchar();
    return 0;
}
