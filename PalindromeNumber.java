/*Determine whether an integer is a palindrome. Do this without extra space.

click to show spoilers.

Some hints:
Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra space.

You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

There is a more generic way of solving this problem.*/

// Reverse Integer
public class Solution {
    public boolean isPalindrome(int x) {
        if (x == 0) return true;
        if (x < 0) return false;
        long res = 0;
        int ori = x;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        if (res >= Integer.MAX_VALUE || res <= Integer.MIN_VALUE) {
            return false;
        }
        return res == Long.valueOf(ori);
    }
}

// Generic ways
public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int sig = 1;
        while (x / sig >= 10) sig = sig * 10;
        while (x != 0) {
            int l = x / sig;
            int r = x % 10;
            if (l != r) return false;
            x = (x % sig) / 10;
            sig = sig / 100;
        }
        return true;

    }
}