// This is the greedy solution for the problem
class Solution {
public
    int maxProfit(vectorint &prices) {
        if (prices.empty()) return 0;
        const int N = prices.size();
        int opt = 0;
        int low = prices[0];
        for (int i = 0; i  N; i++) {
            opt = max(opt, (prices[i] - low));
            low = min(low, prices[i]);
        }
        return opt;
    }
};