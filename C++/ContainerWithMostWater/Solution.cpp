/** This is O^2 Brute Force solution for the problem */
class Solution {
public:
    int maxArea(vector<int> &height) {
        const int N = height.size();
        if (N < 2) return 0;
        int maxArea = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                int currMax = min(height[i], height[j]) * (i-j);
                maxArea = max(maxArea, currMax);
            }
        }
        return maxArea;
    }
};