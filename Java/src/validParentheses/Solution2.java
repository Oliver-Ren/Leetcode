public class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
			return true;
		}

		Stack<Character> pStack = new Stack<Character>();
		Map<Character, Character> pairs = new HashMap<Character, Character>();
		pairs.put(')','(');
		pairs.put(']','[');
		pairs.put('}','{');
		for (int i = 0; i < s.length(); i++) {
		    char curr = s.charAt(i);
		    if (!pairs.containsKey(curr)) {
		        pStack.push(curr);
		    } else {
		        if (pStack.isEmpty() || pStack.pop() != pairs.get(curr)) return false;
		    }
		}
		return pStack.isEmpty();
    }
}
