import java.util.*;

public class SolutionDP2_2nd {
    public List<List<String>> partition(String s) {
        char[] str = s.toCharArray();
        boolean isPalindrome[] = new boolean[str.length + 1];
        List<List<String>>[] result = new List[str.length + 1];

        for (int i = 0; i <= str.length; i++) {
            result[i] = new ArrayList<List<String>>();
            for (int j = 0; j < i; j++) {
                 if (str[j] == str[i - 1]
                         && (i - j < 3 || isPalindrome[j + 1])) {

                     isPalindrome[j] = true;
                     String palindrome = new String(str, j, i - j);
                     //System.out.println(palindrome);

                     for (List<String> partition : result[j]) {
                         List<String> newPartition = new ArrayList<String>(partition);
                         newPartition.add(palindrome);
                         for (String s : newPartition) {
                             System.out.println(s);
                         }
                         result[i].add(newPartition);
                     }
                 }
            }
        }

        return result[str.length];
    }


    public static void main(String[] args) {
        SolutionDP2_2nd test = new SolutionDP2_2nd();
        List<List<String>> result = test.partition("aa");
        for (List<String> l : result) {
            for (String s : l) {
                System.out.print(s + ", ");
            }
            System.out.println();
        }
    }

}


                     



