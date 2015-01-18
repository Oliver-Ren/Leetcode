#include <iostream>

using namespace std;

int ViolentMatch(char * s, char * p) {
	int lenthS = strlen(s);
	int lenthP = strlen(P);
	int i = 0, j = 0;
	while (i < lenghtS && j < lengthP)
	{
		if (s[i] == s[j]) {
			i++;
			j++;
		}
		else{
			i = i - j + 1; //next 
			j = 0;
		}
		
	}
	if ( j == lenthP ){
		return i - j;
	}
	return -1;
}

int main(int argc, char * argv[]) {
	return 0;
}

