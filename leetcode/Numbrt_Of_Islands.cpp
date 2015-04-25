/*
* Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
* An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
* You may assume all four edges of the grid are all surrounded by water.
*
* Example 1:
*
* 11110
* 11010
* 11000
* 00000
* Answer: 1
*
* Example 2:
*
* 11000
* 11000
* 00100
* 00011
* Answer: 3
*/

#include <iostream>
#include <vector>
using namespace std;

template <typename T>
void print(vector<vector<T> > &grid) {
    int m = grid.size();
    if (m == 0) return;
    int n = grid[0].size();
    for (int i = 0; i < m; ++i) {
        vector<T> v = grid[i];
        for (int j = 0; j < n; ++j) {
            cout << v[j] << " ";
        }
        cout << endl;
    }
}

void dfs(vector<vector<char> > &arr, vector<vector<int> > &mark, int label, int i, int j, int m, int n) {
    mark[i][j] = label;
    if (i > 0 && arr[i - 1][j] == '1' && mark[i - 1][j] == 0) {
        dfs(arr, mark, label, i - 1, j, m, n);
    }
    if (j > 0 && arr[i][j - 1] == '1' && mark[i][j - 1] == 0) {
        dfs(arr, mark, label, i, j - 1, m, n);
    }
    if (j < n - 1 && arr[i][j + 1] == '1' && mark[i][j + 1] == 0) {
        dfs(arr, mark, label, i, j + 1, m, n);
    }
    if (i < m - 1 && arr[i + 1][j] == '1' && mark[i + 1][j] == 0) {
        dfs(arr, mark, label, i + 1, j, m, n);
    }
}

int numIslands(vector<vector<char>> &grid) {
    int m = grid.size();
    if (m == 0) return 0;
    int n = grid[0].size();
    vector<vector<int> > mark(m, vector<int>(n, 0));
    int label = 1;
    for (int i = 0; i < m; ++i) {
        for (int j = 0; j < n; ++j) {
            if (grid[i][j] == '1' && mark[i][j] == 0) {
                dfs(grid, mark, label++, i, j, m, n); 
            }
        }
    }
    return label - 1;
}

int main() {
    //vector<vector<char> > vv;
    //vector<char> v1(5, '1');
    //v1[4] = '0';
    //vv.push_back(v1);
    //vector<char> v2(v1);
    //v2[2] = '0';
    //vv.push_back(v2);
    //vector<char> v3(v2);
    //v3[3] = '0';
    //vv.push_back(v3);
    //vector<char> v4(5, '0');
    //vv.push_back(v4);
    //------------------------------------
    //vector<vector<char> > vv;
    //vector<char> v1(5, '0');
    //v1[0] = v1[1] = '1';
    //vv.push_back(v1);
    //vector<char> v2(v1);
    //vv.push_back(v2);
    //vector<char> v3(5, '0');
    //v3[2] = '1';
    //vv.push_back(v3);
    //vector<char> v4(5, '0');
    //v4[3] = v4[4] = '1';
    //vv.push_back(v4);
    vector<vector<char> > vv;
    vv.push_back(vector<char>(1, '1'));
    vv.push_back(vector<char>(1, '1'));
    print(vv);
    cout << endl << numIslands(vv) << endl;
    return 0;
}
