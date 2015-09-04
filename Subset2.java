/*Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]*/


public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
        	return res;
        }
        Arrays.sort(nums);
        dfs(res, new ArrayList<Integer>(), nums, new boolean[nums.length], 0);
        return res;
    }
    
    
    public void dfs(List<List<Integer>> res, List<Integer> list, int nums[], boolean visit[], int pos) {
    	res.add(new ArrayList<Integer>(list));
    	for (int i = pos; i < nums.length; i++) {
    		if (i != 0 && nums[i] == nums[i - 1] && !visit[i - 1]) {
    			continue;
    		} 
    		
    		if(!visit[i]) {
    			visit[i] = true;
    			list.add(nums[i]);
    			dfs(res, list, nums, visit, i);
    			list.remove(list.size() - 1);
    			visit[i] = false;
    		}
    	}
    }
}