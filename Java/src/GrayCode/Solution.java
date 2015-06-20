package GreyCode;

import java.util.*;
import java.lang.Math;

public class Solution {

	    public static List<Integer> grayCode(int n) {
	        List<Integer> grayCode = new ArrayList<Integer>();
	        int number = (int) Math.pow(2,n);
	        for (int i = 0; i < number; i++){
	            grayCode.add((i>>1) ^ i);
	        }
	        return grayCode;
	    }


	public static void main(String[] args) {
		System.out.print(grayCode(2));
		// TODO Auto-generated method stub

	}

}
