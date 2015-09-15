/*Given an array of integers, every element appears three times except for one. Find that single one.*/

// My Suck Code
public class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                sum += (nums[j] >> i) & 1;
                sum %= 3;
            }
            res |= sum << i;
        }
        return res;
    }
}


// Best one in Discuss
public class Solution {
    public int singleNumber(int[] A) {
        int ones = 0, twos = 0;
        for(int i = 0; i < A.length; i++){
            ones = (ones ^ A[i]) & ~twos;
            twos = (twos ^ A[i]) & ~ones;
        }
        return ones;
    }
}