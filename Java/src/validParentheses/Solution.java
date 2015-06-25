public class Solution {
	public boolean isValid(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}

		Stack<Character> pStack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
				case '(':
				case '{':
				case '[': pStack.push(s.charAt(i)); break;
				case ')': if (pStack.isEmpty() || pStack.pop() != '(') return false; break;
				case '}': if (pStack.isEmpty() || pStack.pop() != '{') return false; break;
				case ']': if (pStack.isEmpty() || pStack.pop() != '[') return false; break; 
			}
		}

		return pStack.isEmpty() ? true : false;
	}

	public static void main(String [] args) {
		Solution test = new Solution();
		System.out.println(test.isValid("())"));
	}

}


