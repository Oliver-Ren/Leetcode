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

		auto state_is_target = [&] (const string & s) {return s==end;};
		auto state_extend = [&] (const string & s) {
			string str(s);
			unorderd_set<string> result;
			for (int i = 0; i < str.size(); i++) {
				for (char c = 'a'; c <= 'z'; c++) {
					if (str[i] == c) continue;
					swap(str[i], c);
					if (dict.count(str) > 0 && visited.count(str) = 0) {
						result.insert(str);
					}
					swap(str[i], c);
				}
			}
			return result;
		}
		
		current.insert(start);
		while (!current.empty() && !found) {
			for (const auto & word : current) {
				visited.insert(word);
			}
			for (const auto & word : current) {
				const auto & new_words = state_extend(word);
				for (cosnt auto & new_word : new_words) {
					if (new_word == end) {
						found = true;
					}
					next.insert(new_word);
					father.get(word).push(new_word);
				}
			}
			current.clear();
			swap(current, next);
		}

		vector<vector<string> > result;
		if (found) {
			vector<string> path
			gen_path(result, path, start, end, father);
		}
		return path;
	}

private:
	void gen_path(vector<vector<string> & path, const string & start, const string & target, unordered_map<string, vector<string> > & father) {
		path.push_back(target);
		if (start == target) {
			result.push_back(path);
			reverse(result.back().begin(), result.back().end());
		} else {
			for (const auto & word : father[target]) {
				gen_path(result, path, start, word, father);
			}
		}
		path.pop_back();
	}
};



						


			


				
		
