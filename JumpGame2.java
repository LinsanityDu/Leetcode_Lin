/*Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)*/

// DP
public class Solution {
    public int jump(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int[] state = new int[A.length];
        state[0] = 0;
        
        for (int i = 1; i < A.length; i++) {
            state[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (state[j] != Integer.MAX_VALUE && A[j] >= i - j) {
                    state[i] = state[j] + 1;
                    break;
                }
            }
        }
        
        return state[A.length - 1];        
    }
}


// Greedy
public class Solution {
    public int jump(int[] A) {
       if (A == null || A.length <= 1)  return 0;
       int[] dp = new int[A.length];
       int cur = 1;
       for (int i = 0; i < A.length - 1; i++) {
            while (cur <= i + A[i] && cur < dp.length) {
                dp[cur] = dp[i] + 1;
                cur++;
            }
            if (cur == dp.length) {
                break;
            }
        }
        return dp[A.length - 1];
    }
}