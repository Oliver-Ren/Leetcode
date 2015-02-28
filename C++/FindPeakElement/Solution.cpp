class Solution {
public:
    int findPeakElement(const vector<int> &num) {
        const int N = num.size();
        if (N == 1) return 0;
        for (int i = 0; i < N - 2; i++) {
            if (num[i] < num[i+1] && num[i+1] > num[i+2]) {
                return i + 1;
            }
        }
        return num[0] > num[N-1] ? 0 : N-1;
    }
};