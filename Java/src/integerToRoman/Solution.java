package integerToRoman;

import java.util.*;


public class Solution {
	public static String intToRoman(int num){
		int i = 0;
		int [] numDigit = new int[4];
		char [] dict = {'M','D','C','L','X','V','I'};
		List<Character> s = new ArrayList<Character>();
		int offset = 0;
		if ( num < 1 || num > 3999) return null;
		
		while( num != 0 && i < 4 ){
			int remainder = num % 10;
			num /= 10;
			numDigit[i] = remainder;
			i++;
		}
		
		i--;
		for (; i >= 0; i--){
			offset = 6-2*i;
			switch (numDigit[i]){
				case 4: s.add(dict[offset]); s.add(dict[offset-1]); break;
				case 9: s.add(dict[offset]); s.add(dict[offset-2]); break;
				default:
					if ( numDigit[i] >= 5 ) {
						s.add(dict[offset-1]);
						numDigit[i] -= 5;
					}
					for (int j = 0; j < numDigit[i]; j++)
						s.add(dict[offset]);
			}
		}
		
		StringBuilder result = new StringBuilder(s.size());
		for (Character c : s) {
		  result.append(c);
		}
		String output = result.toString();
		return output;
		
	}

	public static void main(String[] args) {
		int i = 1994;
		System.out.print(intToRoman(i));
		// TODO Auto-generated method stub

	}

}
