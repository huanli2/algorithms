
/* Given a binary tree, return the postorder traversal of its nodes' values.
 *
 * For example:
 * Given binary tree {1,#,2,3},
 *  1
 *   \
 *   2
 *  /
 * 3
 * return [3,2,1].
 *
 * Recursive solution is trivial, could you do it iteratively?
 */
#include <iostream>
#include <vector>
#include < stack>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

vector<int> postorderTraversal(TreeNode *root) {
    stack<TreeNode*> s;
    vector<int> res;
    if(root != NULL) s.push(root);
    while(!s.empty()){
        TreeNode* cur = s.top();
	if(cur->left == NULL && cur->right == NULL){
            res.push_back(cur->val);
            s.pop();
        }
        if(cur->right != NULL) {
	    s.push(cur->right);
	    cur->right = NULL;
	}
	if(cur->left != NULL) {
	    s.push(cur->left);
	    cur->left = NULL;
	} 
    }
    return res;
}

void print(vector<int> &v) {
    for(vector<int>::iterator t = v.begin(); t != v.end(); ++t) {
	cout << *t << " ";
    }
    cout << endl;
}

void printByPostorder(TreeNode* root) {
    if(root) {
	printByPostorder(root->left);
	printByPostorder(root->right);
	cout << root->val << " ";
    }
}

int main()
{
    TreeNode t0(1);
    TreeNode t1(2);
    TreeNode t2(3);
    TreeNode t3(4);
    TreeNode t4(5);
    TreeNode t5(7);
    t0.left = &t1;
    t0.right = &t2;
    t1.left = &t3;
    t1.right = &t4;
    t2.right = &t5;
    cout << "input tree:  " << endl;
    printByPostorder(&t0);
    cout << endl << "post_order_traversal
    print(postorderTraversal(&t0));
    getchar();
    return 0;
}
