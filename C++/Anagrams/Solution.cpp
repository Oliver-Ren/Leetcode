class Solution {
public:
    vector<string> anagrams(vector<string> &strs) {
        unordered_map<string, vector<string> > group;
        for (const auto &s : strs) {
            string candidate(s);
            sort(candidate.begin(),candidate.end());
            group[candidate].push_back(s);
        }
        
        vector<string> result;
        for (const auto &kv : group) {
            if (kv.second.size() > 1) {
                for (const auto &word : kv.second) {
                    result.push_back(word);
                }
            }
        }
        return result;
    }
};