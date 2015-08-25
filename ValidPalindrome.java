/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
*/

public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) return false;
        if (s.length() == 0) return true;
        int left = 0;
        int right = s.length() - 1;
        int check = 'A' - 'a';
        while (left < right) {
        	if (!isValid(s.charAt(left))) {
        		left++;
        		continue;
        	}
        	if (!isValid(s.charAt(right))) {
        		right--;
        		continue;
        	}
        	if (s.charAt(left) == s.charAt(right) || s.charAt(left) - s.charAt(right) == check || s.charAt(left) - s.charAt(right) == (-1) * check) {
        		left++;
        		right--;
        	} else {
        		return false;
        	}
        }
        return true;
    }

    public boolean isValid(char a) {
    	if ((a - 'A' >= 0 && a - 'Z' <= 0) || (a - 'a' >= 0 && a - 'z' <= 0) || (a - '0' >= 0 && a - '9' <= 0)) {
    		return true;
    	} else {
    		return false;
    	}
    }
}