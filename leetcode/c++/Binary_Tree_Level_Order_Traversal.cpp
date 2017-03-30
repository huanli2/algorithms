/* Given a binary tree, return the level order traversal of its nodes' values. 
 * (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *         3
 *        / \
 *       9  20
 *         /  \
 *        15   7
 * return its level order traversal as:
 * [
 *    [3],
 *    [9,20],
 *    [15,7]
 * ]
 *
 */
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

vector<vector<int> > levelOrder(TreeNode* root) {
    vector<vector<int> > res;
    if(root) {
        int cur = 1;
        int next = 0;
        queue<TreeNode*> q;
        q.push(root);
        TreeNode* tmp;
        vector<int> v;
        while(!q.empty()) {
            tmp = q.front();
            q.pop();
            v.push_back(tmp->val);
            --cur;
            if(tmp->left) {
                q.push(tmp->left);
                ++next;
            }
            if(tmp->right) {
                q.push(tmp->right);
                ++next;
            }
            if(cur == 0) {
                cur = next;
                next = 0;
                res.push_back(v);
                v.clear();
            }
        }
    }
    return res;
}

void print(vector<vector<int> > v) {
    for(int i = 0; i < v.size(); ++i) {
        vector<int> &vv = v[i];
        for(int j = 0; j < vv.size(); ++j) {
            cout << vv[j] << " ";
        }
        cout << endl;
    }
    cout << endl;
}

int main() {
    TreeNode t0(0);
    TreeNode t1(1);
    TreeNode t2(2);
    TreeNode t3(3);
    TreeNode t4(4);
    TreeNode t5(5);
    TreeNode t6(6);
    t0.left = &t1;
    t0.right = &t2;
    t1.left = &t3;
    t2.left = &t4;
    t2.right = &t5;
    t3.right = &t6;
    print(levelOrder(&t0));
    return 0;
}
