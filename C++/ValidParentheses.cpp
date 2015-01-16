#include <iostream>
#include <stack>

using namespace std;

class Solution{
	public:
		bool isValid(string s){
			char last = '0';
			if ( s.length() == 0 ) return true;
			stack<char> bracketType;
			for ( int i = 0; i < s.length(); i++ ){
				switch ( s[i] ){
					case '(':
					case '[':
					case '{': bracketType.push(s[i]);
						  break;
					default:{ if ( bracketType.empty() )
							return false;
						  else{
							  last = bracketType.top();
							  bracketType.pop();
							  if ( abs(s[i] - last) > 2)
								  return false;
						  }
						}
				}
			}
			if ( !bracketType.empty() ) return false;
			return true;
		}


		Solution(){}
};

			
int main(int argc, char * argv[]){
	Solution ss;
	string s = "([{}])";
	bool v = ss.isValid(s);
	cout << v;
	return 0;
}
