package stringToInteger;



public class Solution {
	private static final int MAX_INT = 2147483647;
	private static final int MIN_INT = -2147483648;
	public static int atoi(String str){
		if (str == null || str.length() == 0) return 0;
		int i = 0;
		int len = str.length();
		boolean isPositive = true;
		int number = 0;
		while(str.charAt(i) == ' ' && i < len) i++;
		if (i == len) return 0;
		switch (str.charAt(i)){
			case '-': isPositive = false;
			case '+': i++;
		}
	
		while(i < len){
			if (str.charAt(i) >= '0' && str.charAt(i) <= '9'){
				int remainder = str.charAt(i) - '0';
				if(isOverflow(number, remainder)) return isPositive ? MAX_INT : MIN_INT;
				number = number * 10 + remainder;
			}
			else break;
			i++;
		}
		return isPositive ? number : -number;
	}
	
	private static boolean isOverflow(int base, int remainder){
		if (base > 214748364) return true;
		else if (base == 214748364){
			if (remainder > 7){
				return true;
			}
		}
		return false; 
 		
	}

	public static void main(String[] args) {
		String str = "   -d1234d";
		int i = atoi(str);
		System.out.print(i);
	
		
		// TODO Auto-generated method stub

	}

}
