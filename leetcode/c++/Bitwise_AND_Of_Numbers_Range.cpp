/*
* Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
* 
* For example, given the range [5, 7], you should return 4.
*/

#include <iostream>

using namespace std;

int _rangeBitwiseAnd(int m, int n) {
    while (n > m) {
        n &= n - 1;
    }
    return n;
}

int rangeBitwiseAnd(int m, int n) {
    if (m <= 0 || m > n) return 0;
    int testBit = sizeof(int) == 4 ? 31 : 63;
    int res = 0;
    while (testBit >= 0) {
        int a = m & (1 << testBit);
        int b = n & (1 << testBit);
        if (b > 0 && a == b) {
            res += (1 << testBit);
        }
        else if (a == 0 && b > 0) {
            break;
        }
        --testBit;
    }
    return res;
}

int main() {
    cout << rangeBitwiseAnd(1, 1) << endl;
    return 0;
}
