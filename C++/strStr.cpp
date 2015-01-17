#include <iosteram>

using namespace std;

class Solution{
	public:
		int strStr(char * haystack, char *needle) {
			if (haystack == NULL || needle == NULL) return -1;
			int i = 0;
			int j = 0;
			int start = -1;
			for ( i = 0; i < haystack.length(); i++ ) {
				if ( haystack[i] == needle[j]){
					if (j == 0) {
				        	start = i;
					}
					j++;
				}
				else{
				       	j = 0;
					start = -1;
				}

				if (j == needle.length()) return start;
			}
			return start;
		      	


int main(int argc, char * argv[]) {

