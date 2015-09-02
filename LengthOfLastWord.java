/*Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.*/

public class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                res++;
            } else {
                return res;
            }
        }
        return res;
    }
}



public class Solution {
    public int lengthOfLastWord(String s) {
        char[] schr=s.toCharArray();
        if(s==null || schr.length==0)
            return 0;
        int res=0;
        for(int i=schr.length-1;i>=0;i--)
        {
            if(schr[i]!=' ')
                res++;
            else{
                if(res==0)
                    continue;
                else
                    break;
            }
        }
        return res;
    }
}