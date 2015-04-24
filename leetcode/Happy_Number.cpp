#include <iostream>

using namespace std;

int doCalculate(int n) {
    int res = 0;
    int num;
    while (n > 0) {
        num = n % 10;
        res += num * num;
        n /= 10;
    }
    return res;
}

bool isHappy(int n) {
    int slow = n;
    int fast = n;
    do {
        slow = doCalculate(slow);
        fast = doCalculate(fast);
        fast = doCalculate(fast);
    } while (fast != slow);
    return slow == 1;
}

int main() {
    cout << isHappy(7) << endl;
    return 0;
}
