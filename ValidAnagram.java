/*Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.*/


public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        for (int i = 0; i < sArray.length; i++) {
            if (sArray[i] != tArray[i]) {
                return false;
            }
        }
        return true;
    }
}


public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char schar : s.toCharArray()) {
            if (!map.containsKey(schar)) {
                map.put(schar, 1);
            } else {
                map.put(schar, map.get(schar) + 1);
            }
        }

        for (char tchar : t.toCharArray()) {
            if (!map.containsKey(tchar)) {
                return false;
            } else {
                map.put(tchar, map.get(tchar) - 1);
                if (map.get(tchar) == 0) {
                    map.remove(tchar);
                }
            }
        }
        return true;
    }
}