/*The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.*/

// Use Linked List to record usage
public String getPermutation(int n, int k) {
        List<Integer> num = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++) num.add(i);
        int[] fact = new int[n];  // factorial
        fact[0] = 1;
        for (int i = 1; i < n; i++) fact[i] = i*fact[i-1];
        k = k-1;
        StringBuilder sb = new StringBuilder();
        for (int i = n; i > 0; i--){
            int ind = k/fact[i-1];
            k = k%fact[i-1];Lion
            sb.append(num.get(ind));
            num.remove(ind);
        }
        return sb.toString();
    }

// Nine Chapter
public class Solution {

    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        boolean[] used = new boolean[n];

        k = k - 1;
        int factor = 1;
        for (int i = 1; i < n; i++) {
            factor *= i;
        }

        for (int i = 0; i < n; i++) {
            int index = k / factor;
            k = k % factor;
            for (int j = 0; j < n; j++) {
                if (used[j] == false) {
                    if (index == 0) {
                        used[j] = true;
                        sb.append((char) ('0' + j + 1));
                        break;
                    } else {
                        index--;
                    }
                }
            }
            if (i < n - 1) {
                factor = factor / (n - 1 - i);
            }
        }

        return sb.toString();
    }
}

// Another LinkedList

public String getPermutation(int n, int k) {
          // 1:17 -> 1:43
          LinkedList<Character> digits = new LinkedList<Character>();
          
          // bug 2: should only add n elements.
          for (char i = '1'; i <= '0' + n; i++) {
              digits.add(i);
          }
          
         // The index start from 0;
         k--;
         StringBuilder sb = new StringBuilder();
         
         int sum = 1;
         // n!
         for (int i = 1; i <= n; i++) {
             sum *= i;
         }
         
         for (int i = n; i >= 1; i--) {
             sum /= i;
             int digitIndex = k / sum;
             k = k % sum;
             
             //Line 25: error: cannot find symbol: method digits(int)
             sb.append(digits.get(digitIndex));
             
             // remove the used digit.
             digits.remove(digitIndex);
         }
         
         return sb.toString();
     }