import java.util.*;
/**
 * My first attempt for the problem.
 * The idea is firstly sort the array in ascending
 * order, then scan from left until the remaining 
 * length is less than the current citation.
 * Time complexiity: O(nlogn)
 * Space complexitys: O(logn) for sort.
 * Status: accepted, 3ms
 */
public class Solution {
    public int hIndex(int[] citations) {
        // precondition: citations is not null
        if (citations == null) {
            return 0;
        }

        Arrays.sort(citations);
        int len = citations.length;
        int hIndex = 0;
        for (int i = 0; i < len; i++) {
            int temp = Math.min(citations[i], len - i);
            hIndex = Math.max(hIndex, temp);
        }
        return hIndex;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        int[] cit = {3, 0, 6, 1, 5};
        System.out.println(test.hIndex(cit));
    }
}
