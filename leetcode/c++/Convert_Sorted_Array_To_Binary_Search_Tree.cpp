/* Given an array where elements are sorted in ascending order, 
 * convert it to a height balanced BST. 
 */

#include <iostream>
#include <vector>

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

TreeNode* generateBST(vector<int> &num, int left, int right) {
    if(left > right) return NULL;
    int center = (left + right) / 2;
    TreeNode* node = new TreeNode(num[center]);
    node->left = generateBST(num, left, center - 1);
    node->right = generateBST(num, center + 1, right);
    return node;
}

TreeNode* sortedArrayToBST(vector<int>& num) {
    return generateBST(num, 0, num.size() - 1);
}

int main() {
    vector<int> num(3,3);
    num[1] = 5;
    num[2] = 8;
    printByFirstOrder(sortedArrayToBST(num));
    cout << endl;
    return 0;
}

