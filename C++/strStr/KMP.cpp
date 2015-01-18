#include <iostream>

using namespace std;

int KmpSearch(char * s, char * p, int next[]){
	int slen = strlen(s);
	int plen = strlen(p);
	int i = 0, j = 0;
	while (i < slen && j < plen){
		if (j == -1 || s[i] == p[j]){ // if j == -1 you shouold consider this
			i++;
			j++;
		}
		else{
			j = next[j];
		}
	}
	if (j == plen)
		return i - j;
	else return -1;
}

void GetNext( char * p, int next[]) {
	int pLen = strlen(p);
	next[0] = -1;
	int k = -1;
	int j = 0;
	while ( j < pLen - 1) {
		if ( k == -1 || p[j] == p[k] ) {
			j++;
			k++;
			if (p[j] != p[k])
				next[j] = k;
			else
				next[j] = next[k];
		}
		else{
			k = next[k];
		}	
	}
}

int main(int argc, char * argv[]) {
	char str[] = "abcdabd";
	int len = strlen(str);
	int next[7] = {0};	
	GetNext(str,next);
	for (int i = 0; i < len; i++)
		cout << next[i] << ' ';
	char ss[] = "aaaaaaaaabcbabd";
	cout << endl;
	cout << KmpSearch(ss, str, next);
	return 0;
}

