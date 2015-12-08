import java.util.ArrayList;
import java.util.List;

/**
 * Status: Accepted, 6ms.
 */
public class SolutionDP {
    public List<List<String>> partition(String s) {
        // precondition: s is not null
        if (s == null) throw new NullPointerException();
        
        int len = s.length();
        char[] str = s.toCharArray();
        boolean[][] isPalindrome = new boolean[len][len];
        List<List<String>>[] result = new List[len + 1];
        result[0] = new ArrayList<List<String>>();
        result[0].add(new ArrayList<String>());
        
        for (int i = 0; i < len; i++) {
            result[i + 1] = new ArrayList<List<String>>();
            for (int j = 0; j <= i; j++) {
                if (str[i] == str[j] && (i - j < 3 || isPalindrome[j + 1][i - 1])) {
                    isPalindrome[j][i] = true;
                    for (List<String> l : result[j]) {
                        List<String> newList = new ArrayList<String>(l);
                        newList.add(new String(str, j, i - j + 1));
                        result[i + 1].add(newList);
                    }
                }
            }
        }
        
        return result[len];
    }
}
