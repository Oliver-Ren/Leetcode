import java.util.*;

/** This is the one dimensional 
 *  dynamic programming solution.
 *  Time complexity: O(n^2)
 *  Space complexity: O(n)
 *  Status: Accepted, 324ms.
 * **************************/

public class SolutionDP2_2nd {
    public List<List<String>> partition(String s) {
        char[] str = s.toCharArray();
        boolean isPalindrome[] = new boolean[str.length + 1];
        List<List<String>>[] result = new List[str.length + 1];
		
		// initialize
		result[0] = new ArrayList<List<String>>();
		result[0].add(new ArrayList<String>());

        for (int i = 1; i <= str.length; i++) {
            result[i] = new ArrayList<List<String>>();
            for (int j = 0; j < i; j++) {
                 if (str[j] == str[i - 1]
                         && (i - j < 3 || isPalindrome[j + 1])) {

                     isPalindrome[j] = true;
                     String palindrome = new String(str, j, i - j);

                     for (List<String> partition : result[j]) {
                         List<String> newPartition = new ArrayList<String>(partition);
                         newPartition.add(palindrome);
                         result[i].add(newPartition);
                     }
                 } else {
					 isPalindrome[j] = false;
				 }
            }
        }

        return result[str.length];
    }


    public static void main(String[] args) {
        SolutionDP2_2nd test = new SolutionDP2_2nd();
        List<List<String>> result = test.partition("aaba");
        for (List<String> l : result) {
            for (String s : l) {
                System.out.print(s + ", ");
            }
            System.out.println();
        }
    }

}


                     



