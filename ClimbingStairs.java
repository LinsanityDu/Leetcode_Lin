/*You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?*/

public class Solution {
    public int climbStairs(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] state = new int[n + 1];
        state[0] = 1;
        state[1] = 1;
        for (int i = 2; i <= n; i++) {
            state[i] = state[i - 1] + state[i - 2];
        }
        return state[n];
    }
}


public class Solution {
    public int climbStairs(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int prev = 1;
        int cur = 1;
        int next = 2;
        for (int i = 2; i <= n; i++) {
            next = prev + cur;
            prev = cur;
            cur = next;
        }
        return next;
    }
}