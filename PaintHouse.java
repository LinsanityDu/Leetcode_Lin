/*There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.

Note:
All costs are positive integers*/

// My Code
public class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length;
        if(n == 0)
            return 0;
    	int[] prev = new int[3];
    	int[] curr = new int[3];
	    for(int i = 1; i <= n; i++) {
		    curr[0] = Math.min(prev[1], prev[2]) + costs[i-1][0];
		    curr[1] = Math.min(prev[0], prev[2]) + costs[i-1][1];
		    curr[2] = Math.min(prev[0], prev[1]) + costs[i-1][2];
		    prev[0] = curr[0];
		    prev[1] = curr[1];
		    prev[2] = curr[2];
        }
        int result = Math.min(curr[0], curr[1]);
        result = Math.min(result, curr[2]);
        return result;
    }
}