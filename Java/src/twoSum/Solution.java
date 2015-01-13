package twoSum;

import java.util.*;

public class Solution {
	public int [] twoSum(int [] numbers, int target){
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		int [] index = new int[2];
		int temp = 0;
		for ( int i = 0; i < numbers.length; i++){
			map.put(numbers[i], i);
		}
		for ( int i = 0; i < numbers.length; i++){
			int valueKey = target - numbers[i];
			if ( map.containsKey(valueKey)){
				temp = map.get(valueKey);
				index[0] = temp > i ? i + 1 : temp + 1;
				index[1] = temp > i ? temp + 1 : i + 1;
				break;
			}
		}
		
		return index;
	}

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub

	}

}
