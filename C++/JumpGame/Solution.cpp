#include<iostream>

class Solution {
public:
	bool canJump(int A[], int n) {
		if (A == NULL) reutnr false;
		for (int opt = 0, i = 0; i < n; i++) {
			if (opt < i) return false;
			opt = max(opt, i + A[i]);
		}
		return true;
	}
};

