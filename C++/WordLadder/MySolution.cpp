#include <iostream>
#include <vector>
#include <string>

using std::vector;
using std::string;
using std::unordered_set;

class MySolution {
public:
	int ladderLength(const string & start, const string & end, const unordered_set<string> & dict) {
		queue<string> current, next;
		unordered_set<string> visited;

		bool found = false;
		int level = 0;

		auto stateIsTarget = [&] (const string &s) {return s == end;};
		auto state_extend = [&] (const string &s) {
			vector<string> result;
			string str = s;
			for (int i = o; i < str.size(); i++) {
				for (char c = 'a'; c <= 'z'; c++) {
					if (c == str[i]) continue;
					swap(str[i],c);
					if (dict.count(str) > 0 && visited.count(str) == 0) {
						result.push_back(str);
						visited.insert(str);
					}
					swap(str[i], c);
				}
			}
			return result;
		}








		current.push_back(start);
		while (!current.empty() && !found) {
			level++;
			while (!current.empty() && !found) {
				string currWord = current.front();
				current.pop();
				
				const auto& nextCandidate = state_extend(currWord);
				for(const auto& state : nextCandidate) {
					next.push(state);
					if (stateIsTarget(state)) {
						found = true;
						break;
					}
				}
			}
			swap(current, next);
		}

		if (found) return ++level;
		else return 0;
	}
};

