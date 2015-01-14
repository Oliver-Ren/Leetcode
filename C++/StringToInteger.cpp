#include <stdint.h>
#include <iostream>
using namespace std;

#define INT_MAX  2147483647;
#define INT_MIN  -2147483648;

class Solution {
public:
     int atoi(const char *str) {
        int number = 0;
        int i = 0;
        long numberLong = 0;
        int isPositive = -1;
        while(str[i] != '\0'){
            if (isPositive == -1 &&  str[i] != ' '){
                if ( str[i] == '+' || (str[i] >= '0' && str[i] <= '9')){
                    isPositive = 1;
                }
                else if ( str[i] == '-') isPositive = 0;
		else break;
            }
	    else if ((str[i] < '0' || str[i] > '9') && isPositive >= 0){
                break;
	    }
            if ( str[i] >= '0' && str[i] <= '9' && isPositive >= 0){
                numberLong = numberLong * 10 + (str[i] - '0');
                if ( numberLong > 2147483647) return isPositive ? 2147483647 : -2147483648;
            }
            
	    i++;
        }
	number = (int)numberLong;
	return isPositive ? number : -number;
    }
    
};

int main(int argc, char * argv){
	Solution solu;
	char * test = "   010";
	int a = solu.atoi(test);
	long aa = 100;
	aa = aa * INT_MAX;
	cout << a << "\n";
	cout << sizeof(long)/sizeof(int);
	cout << "\n" << aa; 
	return 0;
}

