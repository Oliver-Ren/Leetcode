package ClimbingStairs;

public class Solution {
	
	//+++++++++++++++++++++++++++++++++++++
	//	recursive is too slow
	
	//+++++++++++++++++++++++++++++++++++++
//	public static int climbStairs(int n) {
//        //if (n < 0) return -1; // only two line
//        if (n == 2) return 2;
//        if (n == 1) return 1;
//        //if (n == 0) return 0;
//        return climbStairs(n-1) + climbStairs(n-2);
//    }
	
	public static int climbStairs(int n){
		if (n <= 0) return 0;
		int currnum = 1;
		int prevnum = 0;
		int nextnum = 0;
		for (int i = 0; i < n; i++){
			nextnum = currnum + prevnum;
			prevnum = currnum;
			currnum = nextnum;
		}
		return nextnum;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(climbStairs(4));

	}

}
