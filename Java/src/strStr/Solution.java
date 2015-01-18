package strStr;

public class Solution {
	private String pattern;
	private int [] next;
	
	public void KMPplus(String pattern){
		int len = pattern.length();
		this.next[0] = -1;
		int j = 0;
		int k = -1;
		while ( j < len-1 ) {
			if ( k == -1 || pattern.charAt(j) == pattern.charAt(k)){
				j++;
				k++;
				if (pattern.charAt(j) != pattern.charAt(k)){
					this.next[j] = k;
				}
				else{
					this.next[j] = this.next[k];
				}
			}
			else{
				k = this.next[k];
			}
		}
	}
	
	public int strStr(String haystack, String needle){
		if (haystack == null && needle == null) return -1;
		int hLen = haystack.length();
		int nLen = needle.length();
		if (nLen == 0) return 0;
		this.next = new int[nLen];
		KMPplus(needle);
		int i = 0, j = 0;
		while (i < hLen && j < nLen){
			if ( j == -1 || haystack.charAt(i) == needle.charAt(j)){
				i++;
				j++;
			}
			else{
				j = this.next[j];
			}
		}
		if ( j == nLen)
			return i - j;
		else
			return -1;
	}
	
	public static void main(String args[]){
		String h = "abcd";
		String n = "c";
		Solution aa = new Solution();
		int pos = aa.strStr(h,n);
		System.out.print(pos);
	}
}
