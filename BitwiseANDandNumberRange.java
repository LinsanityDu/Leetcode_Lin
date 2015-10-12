/*Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

For example, given the range [5, 7], you should return 4.

*/

public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if (n == m) {
            return n;
        }
        if (n - m == 1) {
            return n & m;
        }
        return rangeBitwiseAnd(m / 2, n / 2) << 1;
    }
}


// Discussion
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int step = 0;
        while(m!=n){
            m >>= 1;
            n >>= 1;
            step ++;
        }
        return m<<step;
    }
}