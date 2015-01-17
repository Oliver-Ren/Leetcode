package romanToInteger;

public class Solution{
	public static int romanToInt(String s) {
		if (s == null || s.length() == 0) return 0;
		int previousNumber = 1000;
		int number = 0;
		int sum = 0;
		for ( int i = 0; i < s.length(); i++) {
			switch ( s.charAt(i)) {
				case 'I': number = 1; break;
				case 'V': number = 5; break;
				case 'X': number = 10; break;
				case 'L': number = 50; break;
				case 'C': number = 100; break;
				case 'D': number = 500; break;
				case 'M': number = 1000; break;
				default: return 0;
			}

			if (previousNumber < number) {
				sum = sum + number - (2*previousNumber);
			}
			else sum += number;
			previousNumber = number;
		}
		return sum;
	}

	public static void main(String args[]){
		String str = "IV";
		int i = romanToInt(str);
		System.out.print(romanToInt(str));
	}
}


				



