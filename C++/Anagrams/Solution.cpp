/** My solution using stack. */
class Solution {
public:
    string addBinary(string a, string b) {
        const int lenA = a.size();
        const int lenB = b.size();
        
        int aPointer = lenA - 1;
        int bPointer = lenB - 1;
        
        stack<int> result;
        int carry = 0;
        
        while (aPointer >= 0 || bPointer >= 0) {
            int aValue = aPointer >= 0 ? a[aPointer] - '0' : 0;
            int bValue = bPointer >= 0 ? b[bPointer] - '0' : 0;
            result.push(aValue ^ bValue ^ carry);
            carry = (aValue + bValue + carry) >> 1;
            aPointer--;
            bPointer--;
        }
        
        if (carry == 1) result.push(carry);
        
        string sum;
        const int digits = result.size();

		for (int i = 0; i < digits; i++) {
            char digit = '0' + result.top();
            sum.push_back(digit);
            result.pop();
        }
        
        return sum;
        
        
    }
};



/** My solution which does not use stack */)
class Solution2 {
public:
    string addBinary(string a, string b) {
        const int lenA = a.size();
        const int lenB = b.size();
        
        int aPointer = lenA - 1;
        int bPointer = lenB - 1;
        
        string result;
        int carry = 0;
        
        while (aPointer >= 0 || bPointer >= 0) {
            int aValue = aPointer >= 0 ? a[aPointer] - '0' : 0;
            int bValue = bPointer >= 0 ? b[bPointer] - '0' : 0;
            result.push_back(aValue ^ bValue ^ carry + '0');
            carry = (aValue + bValue + carry) >> 1;
            aPointer--;
            bPointer--;
        }
        
        if (carry == 1) result.push_back('1');
        reverse(result.begin(),result.end());
        return result;
        
        
    }
};