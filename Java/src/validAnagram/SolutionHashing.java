import java.util.*;
/**
 * The solution using hashing for better 
 * performance in the Unicode condition.
 * Status: Accepted, 43ms.
 */
public class SolutionHashing {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> charCount = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            Character curr = s.charAt(i);
            if (charCount.containsKey(curr)) {
                charCount.put(curr, charCount.get(curr) + 1);
            } else {
                charCount.put(curr, 1);  // Be very careful, this should be 1.
            }
        }


        for (int i = 0; i < t.length(); i++) {
            Character curr = t.charAt(i);
            if (charCount.get(curr) == null) {
                return false;
            } else {
                int currCount = charCount.get(curr) - 1;
                if (currCount == 0) {
                    charCount.remove(curr);
                } else {
                    charCount.put(curr, currCount);
                }
            }
        }


        return charCount.size() == 0;
    }

   public static void main(String[] args) {
       SolutionHashing test = new SolutionHashing();
       System.out.println(test.isAnagram("ahah", "hhaa"));
   }
}
