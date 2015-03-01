class Solution {
public:
    vector<vector<int> > permute(vector<int> &num) {
        vector<vector<int> > result;
        permuteHelper(result, num, 0);
        return result;
    }
private:
    void permuteHelper(vector<vector<int> > &result, vector<int> &num, int start) {
        const int N = num.size();
        if (start == N - 1) {
            result.push_back(num);
            return;
        }
        for (int i = start; i < N; i++) {
            swap(num[i], num[start]);
            permuteHelper(result, num, start + 1);
            swap(num[i], num[start]);
        }
    }
};