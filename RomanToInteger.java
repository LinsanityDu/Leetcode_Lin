/*Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.*/


public class Solution {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
	    map.put('M', 1000);
	    map.put('D', 500);
	    map.put('C', 100);
	    map.put('L', 50);
	    map.put('X', 10);
	    map.put('V', 5);
	    map.put('I', 1);
	    int index = 0;
	    int res = 0;
	    while (index < s.length() - 1) {
	        if (map.get(s.charAt(index)) >= map.get(s.charAt(index + 1))) {
	            res += map.get(s.charAt(index));
	            index++;
	        } else if (map.get(s.charAt(index)) < map.get(s.charAt(index + 1))) {
	            res += map.get(s.charAt(index + 1)) - map.get(s.charAt(index));
	            index += 2;
	        }
	    }
	    
	    if (index == s.length() - 1) {
	        res += map.get(s.charAt(index));
	    }
	    return res;
    }
}