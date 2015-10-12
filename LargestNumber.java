/*Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.*/
// Increasing Order
public  String largestNumber(int[] num) {
    if(num==null || num.length==0)
        return "";
    String[] Snum = new String[num.length];
    for(int i=0;i<num.length;i++)
        Snum[i] = num[i]+"";

    Comparator<String> comp = new Comparator<String>(){
        @Override
        public int compare(String str1, String str2){
            String s1 = str1+str2;
            String s2 = str2+str1;
            return s1.compareTo(s2);
        }
    };

    Arrays.sort(Snum,comp);
    if(Snum[Snum.length-1].charAt(0)=='0')
        return "0";

    StringBuilder sb = new StringBuilder();

    for(String s: Snum)
        sb.insert(0, s);

    return sb.toString();

}


// Decreasing Order


public class Solution {
    class NumbersComparator implements Comparator<String> {
	@Override
	public int compare(String s1, String s2) {
		return (s2 + s1).compareTo(s1 + s2);
	}
}
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(strs, new NumbersComparator());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            sb.append(strs[i]);
        }
        String result = sb.toString();
        int index = 0;
        while (index < result.length() && result.charAt(index) == '0') {
            index++;
        }
        if (index == result.length()) {
            return "0";
        }
        return result.substring(index);
    }
}