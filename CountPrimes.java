
/*Description:

Count the number of prime numbers less than a non-negative number, n.*/



public int countPrimes(int n) {
   int count = 0;
   for (int i = 1; i < n; i++) {
      if (isPrime(i)) count++;
   }
   return count;
}

private boolean isPrime(int num) {
   if (num <= 1) return false;
   // Loop's ending condition is i * i <= num instead of i <= sqrt(num)
   // to avoid repeatedly calling an expensive function sqrt().
   for (int i = 2; i * i <= num; i++) {
      if (num % i == 0) return false;
   }
   return true;
}



public class Solution {
    public int countPrimes(int n) {
        int count=0;
        boolean[] nums = new boolean[n];
        for(int i=2; i<nums.length; i++){
            if(!nums[i]){
                count++;
                for(int j=2*i; j<nums.length; j=j+i){
                        nums[j] = true;
                }
            }
        }
        return count;
        
    }
}