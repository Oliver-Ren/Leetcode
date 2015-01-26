package isValidNumber;

public class Solution {
	public static boolean isNumber(String s){
		if (s == null || s.isEmpty()) return false;
		int i = 0;
		int len = s.length();
		boolean isDotAppeared = false;
		boolean isEAppeared = false;
		boolean isNumberAppeared = false;
		for (i = 0; i < len && s.charAt(i) == ' '; i++);
		if (i == len) return false;
		if (s.charAt(i) == '.') isDotAppeared = true;
		else if(s.charAt(i) >= '0' && s.charAt(i) <= '9') isNumberAppeared = true;
		else if ((s.charAt(i) < '0' || s.charAt(i) > '9') && s.charAt(i) != '+' && s.charAt(i) != '-')
			return false;
		if (i+1 == len){
	    	if (s.charAt(i) >= '0' && s.charAt(i) <= '9') return true;
		    else return false;
		}
		i++;
		
		for (; i < len && s.charAt(i) != ' '; i++){
			if (s.charAt(i) == '.'){
				if (isDotAppeared) return false;
				else{
						isDotAppeared = true;
						if( i+1 < len && !isDigit(s.charAt(i+1)) && s.charAt(i+1) != ' ')
						    return false;
						continue;
						
				}
			}
			
			else if (s.charAt(i) == 'e'){
				if (isEAppeared) return false;
				else{
					  if (i+1 == len) return false;
					  	if (!isDigit(s.charAt(i+1)) && s.charAt(i+1) != '+' && s.charAt(i+1) != '-') return false;
					  	i++;
						isEAppeared = true;
						continue;
				}
			}
			else if (isDigit(s.charAt(i))) isNumberAppeared = true;
			else return false;
			
			
		}
		
		if (!isNumberAppeared) return false;
		for (; i<len; i++)
			if (s.charAt(i) != ' ') return false;
		
		return true;
	}
	
	public static boolean isDigit(char c){
		if (c >= '0' && c <= '9') return true;
		return false;
	}

	public static void main(String[] args) {
		
		String str = "53k";
		System.out.println(isNumber(str));
		// TODO Auto-generated method stub
		

	}

}
