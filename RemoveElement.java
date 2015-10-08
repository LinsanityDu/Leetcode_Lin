/*Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.*/

	public class Solution {
	    public int removeElement(int[] nums, int val) {
	        int res = 0;
	        for (int i = 0; i < nums.length; i++) {
	            if (nums[i] != val) {
	                res++;
	            } else {
	                int start = i;
	                while (start < nums.length && nums[start] == val) {
	                    start++;
	                }
	                if (start == nums.length) {
	                    return res;
	                } else {
	                    int temp = nums[i];
	                    nums[i] = nums[start];
	                    nums[start] = temp;
	                    res++;
	                }
	            }
	        }
	        return res;
	    }
	}

// Easy Way:
	public class Solution {
	    public int removeElement(int[] A, int elem) {
	        int i = 0;
	        int pointer = A.length - 1;
	        while(i <= pointer){
	            if(A[i] == elem){
	                A[i] = A[pointer];
	                pointer--;
	            } else {
	                i++;
	            }
	        }
	        return pointer + 1;
	    }
	}

// Another way
int removeElement(int A[], int n, int elem) {
    int begin=0;
    for(int i=0;i<n;i++) if(A[i]!=elem) A[begin++]=A[i];
    return begin;
}