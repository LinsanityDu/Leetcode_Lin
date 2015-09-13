/*Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

Update (2015-02-10):
The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.*/

public class Solution {
    public int myAtoi(String str) {
        char[] c=str.toCharArray();
        int len=c.length;
        if(len==0) return 0;
        int i=0;
        int sign=1;
        int num=0;
        while(c[i]==' '&&i<len) //从第一个非空格字符开始
            i++;
        if(i>=len) return 0;
        if(c[i]=='+')   //判断整数的符号，如果没有正负号，则默认为正
        {
            sign=1;
            i++;
        }else if(c[i]=='-')
            {
                sign=-1;
                i++;
            }
        for(;i<len;i++)
        {
            if(c[i]<'0'||c[i]>'9') //如果出现异常字符则退出
                break;
            if((num>Integer.MAX_VALUE/10)||((num==Integer.MAX_VALUE/10)&&((c[i]-'0')>Integer.MAX_VALUE%10))) //如果出现数值越界，则返回最接近的整数
            {
                if(sign==1)
                    return Integer.MAX_VALUE;
                else
                    return Integer.MIN_VALUE;
            }
            num=num*10+(c[i]-'0');
        }
        return sign*num;
    }
}