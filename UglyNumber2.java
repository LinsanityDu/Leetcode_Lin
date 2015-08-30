/*Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number.*/


// Naive way = TLE
public class Solution {
    public int nthUglyNumber(int n) {
        int i = 1;
        while (n > 0) {
            if (isUgly(i)) {
                n--;
            }
            i++;
        }
        return i - 1;
    }
    
    public boolean isUgly(int num) {
        if (num == 0) return false;
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        if (num == 1) {
            return true;
        }
        return false;
    }
}

// DP

public class Solution {
    public int nthUglyNumber(int n) {
        int[] res = new int[n];
        res[0] = 1;
        int next2 = 0;
        int next3 = 0;
        int next5 = 0;
        int multi2 = res[next2] * 2;
        int multi3 = res[next3] * 3;
        int multi5 = res[next5] * 5;
        for (int i = 1; i < n; i++) {
            multi2 = res[next2] * 2;
            multi3 = res[next3] * 3;
            multi5 = res[next5] * 5;
            int ugly = Math.min(multi2, Math.min(multi3, multi5));
            if (ugly == multi2) {
                next2++;
            }
            if (ugly == multi3) {
                next3++;
            }
            if (ugly == multi5) {
                next5++;
            }
            res[i] = ugly;
        }
        return res[n - 1];
    }
}

