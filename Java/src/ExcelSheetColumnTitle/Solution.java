package ExcelSheetColumnTitle;

public class Solution {
	private StringBuffer colTitle = new StringBuffer();
    public String convertToTitle(int n) {
    	colTitle.delete(0, colTitle.length());
        assert n > 0;
        helper(n);
        return colTitle.toString();
        
    }
    
    private void helper(int n) {
        int remainder = (n-1) % 26;
        n = (n-1) / 26;
        if (n > 0) {
            helper(n);
        }
        colTitle.append((char)('A' + remainder));
        return;
    }
}