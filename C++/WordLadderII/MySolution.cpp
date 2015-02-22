#include <iostream>
#include <string>
#include <vector>

using std::string;
using std::vector;
using std::cout;

class MySolution {
public:
	vector<vector<string> > findLadders(string start, string end, const unordered_set<string> &dict) {
		unordered_set<string> current, next;
		unordered_set<stirng> visited;
		unordered_map<string, vector<string> > father;
		bool found;

		auto state_is_target = [&] (string & s) {return s == end;};
		auto state_extend = [&] (string & s) {
			string currentWord = s;
			vector<string> result;
			for (int i = 0; i < s.size(); i++) {
				for (char c = 'a'; c <= 'z'; c++) {
					if (currentWord[i] == c) continue;
					swap(currentWord[i], c);
					if (dict.count(currentWord) == 1 && visited.count(currentWord) == 0) {
						result.push_back(currentWord);
						visited.insert(currentWord);
					}
					swap(currentWord[i], c);
				}
			}
			return result;
		};

		current.insert(start);
		while(!current.empty() && !found) {
			for (const auto & word : current) {
				visited.insert(word);
			}
			for (const auot& word : current) {
				const auto eState = state_extend(word);
				for (const auto& newWord : eState) {
					if (state_is_target(newWord)) found = true;
					next.insert(newWord);
					father[newWord].push_back(word);
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
		return result;

private:
		void gen_path(unordered_map<string, vector<string> & father, vector<string> & path, string & start, string & target, vector<vector<string> > &result) {
			path.push_back(word);
			if (start == target) {
				result.push_back(path);
				reverse(result.back().begin(),result.back().end());
			} else {
				for (const auto & word : father[target]) {
					gen_path(father, path, start, word, result);
				}
			}
			path.pop_back();
		}
	}	

			

