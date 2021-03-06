/*Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?*/


// Extra O(N) Space

public class Solution {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] res = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            res[nums[i]]++;
        }
        for (int i = 0; i < res.length; i++) {
            if (res[i] == 0) {
                return i;
            }
        }
        return 0;
    }
}



// Extra O(1) Space
public class Solution {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i || nums[i] >= nums.length) {
                continue;
            } else {
                int temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[temp] = temp;
                i--;
            }
        }
        
        if (nums[0] != 0) return 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + 1 != nums[i + 1]) {
                return i + 1;
            }
        }
        return nums.length;
    }
}


// Bit
public class Solution {
    public int missingNumber(int[] nums) {
        int miss = 0;
        for (int i = 0; i <= nums.length; i++) {
            miss ^= i;
        }
        
        for (int i = 0; i < nums.length; i++) {
            miss ^= nums[i];
        }
        return miss;
    }
}



// Discussion
Pretty simple since we are told that we are missing only one number in [1,n], we just need to look at the difference between the sum([1,n]) = n * (n+1) / 2 and the sum of nums in our array.

public class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for(int num: nums)
            sum += num;

        return (nums.length * (nums.length + 1) )/ 2 - sum;
    }
}
With a slight mod to the return statement the situation for large n is taken care of. The needed modification is

return ( (nums.length * (nums.length + 1) ) - 2 * sum ) / 2;





// Bit Discussion
public class Solution {
    public int missingNumber(int[] nums) {
        int check = 0;
        for (int i=0; i<nums.length; i++) {
            check ^= nums[i] ^ i+1;
        }
        return check;
    }
}


