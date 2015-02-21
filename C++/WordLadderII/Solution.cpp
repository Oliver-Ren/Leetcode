#include <iostream>
#include <string>
#include <vector>

using namespace std;

class Solution {
public:
	vector<vector<string> > findLadders(string start, string end, const unordered_set<string> &dict) {
		unordered_set<string> current, next;
		unordered_set<string> visited;
		unordered_map<string> fathrer;

		bool found = false;
		int level;

		auto state_is_found = [&] (const string &s) {return s == end;};
		auto state_extend = [&] (const string &s) {
			vector<string> extend_result;
			for (int i = 0; i < s.size(); i++) {
				string cand = s;
				for (char c = 'a'; c <= 'z'; c++) {
					if (cand[i] == c) continue;
					swap(cand[i], c);
					if (dict.count(cand) > 0 && visited.count(cand) == 0) {
						extend_result.push_back(cand);
						visited.insert(cand);
					}
					swap(cand[i], c);
				}
			}
			return extend_result;
		}

		current.insert(start);
		while (!current.empty() && !found) {
			for (const auto& word : current) {
				visited.insert(word);
			}
			for (const auto& word : current) {
				const auto& new_states = state_extend(word);
				for (const auot& state : new_states) {
					if (state_is_found(state)) found = true;
					next.insert(state);
					father[state].push_back(word);
				}
			}
			current.clear();
			swap(current, next);
		}

		vector<vector<string> > result;
		if (found) {
			vector<string> path;
			gen_path(father, path, start, end, result);
		}
		return_result;
	}
private:
	void gen_path(unordered_map<string, vector<string> > &father, vecotr<string> & path, const string & start, const string & target, vector<vector<string> > &result) {
		path.push_back(target);
		if (target == start) {
			result.push_back(path);
			reverse(result.back().begin(), result.back().end());
		}
		else {
			for (const auto& f : father[word]) {
				gen_path(father, path, start, f, result);
			}
		}
		path.pop_back();
	}
};

		
		


