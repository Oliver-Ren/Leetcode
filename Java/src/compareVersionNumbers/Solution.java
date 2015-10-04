/**
 * My first attemp of the problem
 *
 * Time complexity: 
 * Space complexity:
 * Status: DNF.
 */

public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1Array = version1.split("\\.");
        String[] v2Array = version2.split("\\.");


        int len1 = v1Array.length;
        int len2 = v2Array.length;
        int minLen = Math.min(len1, len2);
        
        for (int i = 0; i < minLen; i++) {
            if (Integer.parseInt(v1Array[i]) > Integer.parseInt(v2Array[i])) {
                return 1;
            } else if (Integer.parseInt(v1Array[i]) < Integer.parseInt(v2Array[i])) {
                return -1;
            } else if (i == len1 - 1 && i == len2 - 1) {
                return 0;
            }
        }

        return len1 > len2 ? 1 : -1;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        System.out.println(test.compareVersion("1", "0"));
    }
}
            

