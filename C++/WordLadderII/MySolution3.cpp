#include <iostream>
#include <string>
#include <vector>

using std::vector;
using std::string;

/** This is the accepted solution for the word ladder problem. */

class MySolution3 {
public:
    vector<vector<string> > findLadders(string start, string end, const unordered_set<string> &dict) {
		unordered_set<string> current, next;
		unordered_set<string> visited;
		unordered_map<string, vector<string> > father;

		bool found = false;
		
		auto state_is_target = [&] (const string & s) {return s == end;};
		auto state_extend = [&] (const string & s) {
			string str(s);
			unordered_set<string> result;
			for (int i = 0; i < str.size(); i++) {

				for (char c = 'a'; c <= 'z'; c++) {
					if (str[i] == c) continue;
					swap(str[i], c);
					if (dict.count(str) > 0 && visited.count(str) == 0) {
						result.insert(str);
					}
					swap(str[i], c);
				}
			}
			return result;
		};

		current.insert(start);

		while (!current.empty() && !found) {
			for (const string & word : current) {
				visited.insert(word);
			}
			for (const string & word : current) {
				const auto new_states = state_extend(word);
				for (const string & state : new_states) {
					if (state_is_target(state)) {
						found = true;
					}
					father[state].push_back(word);
					next.insert(state);
				}
			}
			current.clear();
			swap(current, next);
		}
		vector<string> path;
		vector<vector<string> > result;

		if (found) {
			gen_path(result, path, start, end, father);
		}
		
		return result; 
	}
private:
		void gen_path(vector<vector<string> > &result, vector<string> &path, const string & start, const string & target, unordered_map
				<string, vector<string> > &father) {
			path.push_back(target);
			if (start == target) {
				result.push_back(path);
				reverse(result.back().begin(), result.back().end());
			} else {
				for (const auto & state : father[target]) {
					gen_path(result, path, start, state, father);
				}
			}
			path.pop_back();
		}
};


			
		

