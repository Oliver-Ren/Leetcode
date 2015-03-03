class Solution {
public:
	int sqrt(int x) {
		int left = 1;
		int right = x >> 1;
		while (left < right) {
			mid = (left + right) >> 1;
			if (x / mid > mid) {
				left = mid + 1;
				if (x / (mid + 1) > (mid + 1) ) {
					return mid;
				}
			} else if (x / mid > mid) {
				right = mid - 1;
			} else {
				return mid;
			}
		}
		return mid;
	}

			
