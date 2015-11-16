/**
 * The dynamic programming approach.
 * Time complexity: O(n^2)
 * Space complexity: O(n).
 * Status: TLE.
 */
public class Solution {
    public int candy(int[] ratings) {
        // precondition: ratings is not null
        if (ratings == null) {
            throw new NullPointerException();
        }

        int len = ratings.length;
        int[] candies = new int[len];
        
        if (len > 0) {
            candies[0] = 1;
        }
        
        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            } else if (ratings[i] == ratings[i - 1]) {
                candies[i] = 1;
            } else {
                candies[i] = 1;
                while (i > 0 && ratings[i - 1] > ratings[i]
                        && candies[i - 1] == candies[i]) {
                    candies[i - 1]++;
                    i--;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += candies[i];
        }

        return sum;
    }
}


