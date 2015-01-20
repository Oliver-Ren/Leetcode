#include <iostream>
#include <assert.h>
using namespace std;

double helper(double, int);

//This is the naitve verison of the Pow 
double powNaive(double x, int n) {
        double result = x;
        int absOrder = abs(n);
        if ( n == 0 || x == 1.0) return 1;
        else if ( x == -1.0 ) return n % 2 ? -1 : 1;
        else{
            for ( int i = 1; i < absOrder; i++){
                result *= x;
                if ( result > -0.00000001 && result < 0.00000001) break;
            }
            
        }
        
        if ( n < 0 && result == 0.0) return std::numeric_limits<double>::infinity();
        else if ( n < 0 && result != 0.0 ) result = 1/result;
        return result;
    }

double pow(double x, int n) {
	bool isPos = ( n > 0 ) ? true : false;
	bool isOdd = ( n % 2 ) ? true : false;
	double result = 0.00;
	if ( x == 1.00 || n == 0 ) return 1.00;
	else if (x == -1.00) return isOdd ? -1.00 : 1.00;
	result = helper(x,abs(n));
	
	if ( !isPos ){
		assert(result != 0.000);       
		result = 1/result;
	}
	return result;
}

double helper(double x, int n) {
	if ( n == 1 ) return x;
	else if (x == 0.00) return 0.00;
	else{
		double v = helper(x , n / 2);
	       	if (n % 2 == 0)
			return v*v;
		else return v*v*x;
	}
}

int main( int argc, char * argv[]){
	double x = 8.88023;
	int n = 3;
	double result = pow(x,n);
	cout << result;
}

