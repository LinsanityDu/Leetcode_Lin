/*The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".*/

// StringBuilder
public class Solution {
    public String convert(String s, int nRows) {
        if (s == null || nRows <= 0) return null;
        if (nRows == 1 || s.length() == 0) return s;
        StringBuilder[] sb = new StringBuilder[nRows];
        for (int i = 0; i < nRows; i ++) {
            sb[i] = new StringBuilder();
        }
        int row = 0;
        boolean zig = true;
        for (int i = 0; i < s.length(); i ++) {
            sb[row].append(s.charAt(i));
            if (row == 0) {
                zig = true;
            } else if (row == nRows - 1) {
                zig = false;
            }
            if (zig == true) {
                row ++;
            } else {
                row --;
            }
        }
        String res = new String("");
        for (int i = 0; i < nRows; i ++) {
            res += sb[i].toString();
        }
        return res;
    }
}


// Another way
public class Solution {
    public String convert(String s, int nRows) {
        //每个zigzag是2*m-2个字符就可以，这里m是结果的行的数量
        char[] c=s.toCharArray();
        int len=c.length;
        if(len==0)
            return "";
        if(nRows==1)
            return s;
        String result="";
        int zigsize=2*nRows-2;
        for(int i=0;i<nRows;i++)
        {
          for(int j=i;j<len;j+=zigsize)
          {
              result+=c[j];
              //需要判断j后面紧跟的元素，它的坐标为j+zigsize-2*i,因为i表示行，正好为倒数第2*i个元素
              if(i!=0&&i!=nRows-1&&(j+zigsize-2*i)<len)
                    result+=c[j+zigsize-2*i];
          }
          
        }
        return result;      
    }
}