import java.util.Map;
import java.util.HashMap;

/**
 * Status: Accepted.
 * Suppoes n is number of words in the dictionary,
 *         k is the average length of word.
 * Time complexity: init: O(n * k) 
 *                  check: O(k)
 * 
 */
public class ValidWordAbbr {
    private Map<String, String> abbrDic = new HashMap<String, String>();
    public ValidWordAbbr(String[] dictionary) {
        // precondition: dictionary is not null
        if (dictionary == null) {
            throw new NullPointerException();
        }

        for (String s : dictionary) {
            String abbr = getAbbr(s);
            if (!abbrDic.containsKey(abbr)) {
                abbrDic.put(abbr, s);        
            } else {
                if (!s.equals(abbrDic.get(abbr))) {
                    abbrDic.put(abbr, "");
                }
            }
        }
    }

    private String getAbbr(String s) {
        if (s.length() > 2) {
            return s.substring(0, 1) + Integer.toString(s.length() - 2) + s.substring(s.length() - 1, s.length());
        }
        return s;
    }

    public boolean isUnique(String word) {
        String abbr = getAbbr(word);
        return !abbrDic.containsKey(abbr) || abbrDic.get(abbr).equals(word); 
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");
