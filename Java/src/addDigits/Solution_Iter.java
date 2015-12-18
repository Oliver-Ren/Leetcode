public class Solution {
    public int addDigits(int num) {
        int sum = 0;
        boolean notfinished = true;
        while (notfinished) {
            while (num != 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
            notfinished = sum >= 10 ? true : false;
            sum = 0;
        }
        return num;
    }
}
