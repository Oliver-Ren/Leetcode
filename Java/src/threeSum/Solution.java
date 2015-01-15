package threeSum;

import java.util.*;
import java.lang.Math;

public class Solution {
	public static List<List<Integer>> threeSum(int[] num) {
		HashSet<Integer> set = new HashSet<Integer>();
		List<List<Integer>> l = new ArrayList<List<Integer>>();
		if (num == null || num.length < 3) return l;
		Arrays.sort(num);
		int len = num.length;
		int min = num[0];
		int max = num[len-1];
		int nonNegative = -1;
		if (num[0] >= 0 || num[len-1] <= 0) return l;
		
		for (int i = 0; i < len; i++){
			set.add(num[i]);
			if (nonNegative == -1 && num[i] >= 0) nonNegative = i; 
		}
		
		max = (max + min > 0) ? max : -min;
			
		int i = nonNegative;
		while (i < len - 1){
			int j = i + 1;
			while (j < len && num[j] <= (max-num[i])){
				int minusTriplet = 0 - (num[i] + num[j]);
				if (set.contains(minusTriplet)){
					List<Integer> triplets = new ArrayList<Integer>(Arrays.asList(minusTriplet,num[i],num[j]));
					l.add(triplets);
				}
				j++;
			}
			i++;
		}
		
		i = nonNegative - 1;
		while (i > 0){
			int j = i - 1;
			while (j >= 0 && num[j] >= (-max - num[i])){
				int maxTriplet = 0 - (num[i] + num[j]);
				if (set.contains(maxTriplet)){
					List<Integer> triplets = new ArrayList<Integer>(Arrays.asList(num[j],num[i],maxTriplet));
					l.add(triplets);
				}
				j--;
			}
			i--;
		}
		
		return l;
			
		
		
	}

	public static void main(String[] args) {
		int [] num = {-8,-2,-1,0,1};
		List<List<Integer>> testList = threeSum(num);
		System.out.print(testList);
		// TODO Auto-generated method stub

	}

}
