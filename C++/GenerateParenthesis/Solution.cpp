class Solution {
public:
    vector<string> generateParenthesis(int n) {
        vector<string> result;
        string candidate;
        gen_paren(result, candidate, n, n);
        return result;
    }
    
private:
    void gen_paren(vector<string> &result, string &candidate, int leftCount, int rightCount) {
        if (leftCount < 0 || rightCount < leftCount) {
            return;
        }
        if (leftCount == rightCount && leftCount == 0) {
            result.push_back(candidate);
            return;
        }
        
        candidate.push_back('(');
        gen_paren(result, candidate, leftCount - 1, rightCount);
        candidate.pop_back();
        
        candidate.push_back(')');
        gen_paren(result, candidate, leftCount, rightCount - 1);
        candidate.pop_back();
        
        return;
        
    }
};