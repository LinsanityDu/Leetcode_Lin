/*Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.*/

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res=0;
        for(int i=0;i<=31;i++)
        {
            if((n & 1)==1)
                res++;
            n=n>>1;
        }
        return res;
    }
}

// Another

public int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                result++;
            }
            n >>>= 1;
        }
        return result;
}

// Unsigned Right Shift >>> 空位都以0补齐
// Signed Right Shift >> 符号位不变 最左边 正数补0 负数补1
