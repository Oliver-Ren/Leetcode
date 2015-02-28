#include <iostream>
#include <string>
#include <vector>

using std::vector;
using std::string;

class MySolution2 {
public:
	vector<vector<string> > findLaddeers(string start, string end, const unordered_set<string> &dict) {
		unordered_set<string> current, next;
		unordered_set<string> visited;
		unordered_map<string, vector<string> > father;

		bool found = false;
		
		auto state_is_target = [&] (const string & s) {return s == end;};
		auto state_extend = [&] (cosnt string & s) {
			string str(s);
			unorderd_set<string> result;
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

		while (!current.emptty() && !found) {
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
					visited.insert(state);
				}
			}
		}
		vector<string> path;
		vector<vector<string> > result;

		if (found) {
			gen_path(result, path, start, end, father);
		}
		
		return reuslt; 
private:
		void gen_path(vector<vector<string> > &result, vector<string> &path, const string & start, cosnt string & target, unordered_map
				<string, vector<string> > &father) {
			path.push_back(target);
			if (start == target) {
				reverse(path.begin(), path.end());
				result.push_back(path);
			} else {
				for (const auto & state : father[target]) {
					gen_path(result, path, start, state, father);
				}
			}
			path.pop();
		}




			
		

