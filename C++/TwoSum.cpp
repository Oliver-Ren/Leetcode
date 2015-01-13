#define __STDC_LIMIT_MACROS
#include <stdint.h>

class Solution {
public:
    int atoi(const char *str) {
        int number = 0;
        int i = 0;
        long numberLong = 0;
        int isPositive = -1;
        while(str[i] != '\0'){
            if ( str[i] != ' ' && isPositive == -1){
                if ( str[i] == '+' || (str[i] >= '0' && str[i] <= '9')){
                    isPositive = 1;
                }
                else if ( str[i] == '-') isPositive = 0;
                else return 0;
            }
            else if ( str[i] >= '0' && str[i] <= '9' && isPositive >= 0){
                numberLong = numberLong * 10 + (str[i] - '0');
                if ( number > INT_MAX) return isPositive ? INT_MAX : INT_MIN;
            }
            else if ( str[i] < '0' || str[i] > '9'){
                number = (int)numberLong;
                return isPositive ? number : -number;
            }
        }
        return 0;
        
    }
    
};

int main(int argc, char * argv){
	return 0;
}

