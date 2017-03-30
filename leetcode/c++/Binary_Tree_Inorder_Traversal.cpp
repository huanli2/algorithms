
/* Given a binary tree, return the postorder traversal of its nodes' values.
 *
 * For example:
 * Given binary tree {1,#,2,3},
 *  1
 *   \
 *   2
 *  /
 * 3
 * return [1,3,2].
 *
 * Recursive solution is trivial, could you do it iteratively?
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

/* using stack, not modify the original tree */ 
vector<int> inorderTraversal(TreeNode *root) {
    stack<TreeNode*> s;
    vector<int> res;
    TreeNode* cur = root;
    while(!s.empty() || cur) {
        if(cur) {
	    s.push(cur);
	    cur = cur->left;
	}
	else {
       	    res.push_back(s.top()->val);
	    cur = s.top()->right;
	    s.pop();
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

void printByInorder(TreeNode* root) {
    if(root) {
	printByInorder(root->left);
	cout << root->val << " ";
	printByInorder(root->right);
	
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
    t2.left = &t5;
    cout << "input tree:  " << endl;
    printByInorder(&t0);
    cout <<endl << "inorder_traversal using stack without modify the original tree: " << endl;
    print(inorderTraversal(&t0));
    getchar();
    return 0;
}
