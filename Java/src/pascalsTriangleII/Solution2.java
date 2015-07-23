public class Solution {
    public List<Integer> getRow(int rowIndex) {
        Integer [] result = new Integer[rowIndex + 1];
        for (int i = 0; i <= rowIndex; i++) {
            for (int j = i; j >= 0; j--) {
                if (j == 0 || j == i) {
                    result[j] = 1;
                } else {
                    result[j] = result[j] + result[j - 1];
                }
            }
        }

        return Arrays.asList(result);

    }
}

