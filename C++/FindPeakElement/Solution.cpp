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
    
    // The logrithmic complexity solution
    int findPeakElement2(const vector<int> &num) {
        const int N = num.size();
        int left = 0;
        int right = N - 1;
        int mid;
        
        while (left <= right) {
            mid = (left + right) / 2;
            if ((mid == 0 || num[mid - 1] < num[mid]) && (mid == N - 1 || num[mid] > num[mid + 1])) {
                return mid;
            } else if (num[mid] < num[mid - 1]) {
                right = mid - 1;
            } else if (num[mid] < num[mid + 1]) {
                left = mid + 1;
            }
            
            return -1;
        }
    }
};