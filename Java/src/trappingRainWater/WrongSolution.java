import java.util.List;
import java.util.ArrayList;
/**
  * Time Complexity:
  * Space Complexity:
  * Status: Not finished.
  */

public class Solution {
    public int traps(int[] height) {
        if (height == null || height.length == 0) return 0;
        int leftBound = 0;
        int leftHeight = height[0];
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] >= leftHeight) {
                for (int j = leftBound + 1; j < i; j++) {
                    sum += (leftHeight - height[j]);
                }
                leftBound = i;
                leftHeight = height[i];
            }
        }

        if (leftBound != height.length - 1) {
            for (int i = leftBound + 1; i < height.length; i++) {
                int next = i < height.length - 1 ? height[i + 1] : -1; 
                if (height[i] > height[i - 1] 
                        && height[i] >= next) {
                    int minHeight = Math.min(leftHeight, height[i]);
                    for (int j = leftBound + 1; j < i; j++) {
                        if (height[j] < minHeight) {
                            sum += (minHeight - height[j]);
                        }
                    }
                    leftBound = i;
                    leftHeight = height[i];
                }
            }
        }

        return sum;
    }

/*
        List<Integer> peaks = findPeaks(height);
        int sum = 0;
        for (int i = 0; i < peaks.size() - 1; i++) {
            int left = peaks.get(i);
            int right = peaks.get(i + 1);
            int minPeak = Math.min(height[left], height[right]);
            for (int j = left; j < right; j++) {
                if (height[j] < minPeak) {
                    sum += (minPeak - height[j]);
                }
            }
        }
        return Math.max(sum, sum1);
                
    }

    private List<Integer> findPeaks(int [] height, int start) {
        int prev = -1;
        List<Integer> result = new ArrayList<Integer>();
        for (int i = start; i < height.length; i++) {
            int next = i < height.length - 1 ? height[i + 1] : -1;
            if (height[i] > prev && height[i] >= next) {
               result.add(i);
            }
            prev = height[i];
        }

        return result;
    } */


    public static void main(String [] args) {
        Solution test = new Solution();
        int [] input = {5, 4, 1, 2};
        System.out.println(test.traps(input));
    }
}

        





            
            
