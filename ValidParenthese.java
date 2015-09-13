/*Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.*/


public class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() % 2 == 1 || s.length() == 0) return false;
        Stack<Character> stack =  new Stack<Character>();
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) return false;
                char c = stack.pop();
                if (Math.abs(s.charAt(i) - c) > 2) return false;
            }
        }
        return stack.isEmpty();
    }
    
}