/*Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)*/

static List<String> restoreIpAddresses(String s) {
    List<String> ans = new ArrayList<String>();
    int len = s.length();
    for (int i = 1; i <=3; ++i){  // first cut
        if (len-i > 9) continue;            
        for (int j = i+1; j<=i+3; ++j){  //second cut
            if (len-j > 6) continue;                
            for (int k = j+1; k<=j+3 && k<len; ++k){  // third cut
                int a,b,c,d;                // the four int's seperated by "."
                a = Integer.parseInt(s.substring(0,i));  
                b = Integer.parseInt(s.substring(i,j)); // notice that "01" can be parsed into 1. Need to deal with that later.
                c = Integer.parseInt(s.substring(j,k));
                d = Integer.parseInt(s.substring(k));
                if (a>255 || b>255 || c>255 || d>255) continue; 
                String ip = a+"."+b+"."+c+"."+d;
                if (ip.length()<len+3) continue;  // this is to reject those int's parsed from "01" or "00"-like substrings
                ans.add(ip);
            }
        }
    }
    return ans;
}


// DFS
public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<String> list = new ArrayList<String>();
        
        if(s.length() <4 || s.length() > 12)
            return result;
        
        helper(result, list, s , 0);
        return result;
    }
    
    public void helper(ArrayList<String> result, ArrayList<String> list, String s, int start){
        if(list.size() == 4){
            if(start != s.length())
                return;
            
            StringBuffer sb = new StringBuffer();
            for(String tmp: list){
                sb.append(tmp);
                sb.append(".");
            }
            sb.deleteCharAt(sb.length()-1);
            result.add(sb.toString());
            return;
        }
        
        for(int i=start; i<s.length() && i<= start+3; i++){
            String tmp = s.substring(start, i+1);
            if(isvalid(tmp)){
                list.add(tmp);
                helper(result, list, s, i+1);
                list.remove(list.size()-1);
            }
        }
    }
    
    private boolean isvalid(String s){
        if(s.charAt(0) == '0')
            return s.equals("0"); // to eliminate cases like "00", "10"
        int digit = Integer.valueOf(s);
        return digit >= 0 && digit <= 255;
    }
}