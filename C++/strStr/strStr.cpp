#include <iosteram>

using namespace std;

class Solution{
	public:
		// This is the first passed solution, with brute-force
		int strStr(char * haystack, char *needle) {
			if (haystack == NULL || needle == NULL) return -1;
			int lenHaystack = strlen(haystack);
			int lenNeedle = strlen(needle);
			if ( lenNeedle > lenHaystack) return -1;
			if (lenNeedle == 0) return 0;
			int i = 0;
			int j = 0;
			for ( i = 0; i < lenHaystack; i++ ) {
				if ( !strncmp(haystack + i, needle, lenNeedle) ) {
					return i;
				}	
			}
			return -1;
		}
}
		      	


int main(int argc, char * argv[]) {}

