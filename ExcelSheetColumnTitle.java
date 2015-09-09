/*Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB */


public class Solution {
    public String convertToTitle(int n) {
        if (n <= 0) return "";
        StringBuilder res = new StringBuilder();
        while ((n - 1) / 26 > 0) {
            int temp = (n - 1) % 26;
            res.insert(0, (char)('A' + temp));
            n = (n - 1) / 26;
        }
        res.insert(0, (char)('A' + (n - 1)));
        return res.toString();
    }
}