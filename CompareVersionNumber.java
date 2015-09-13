/*Compare two version numbers version1 and version2.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 13.37*/


public class Solution {
    public int compareVersion(String version1, String version2) {
        //小数点在字符串分割中是特殊符号，需要在前面加"\\"
        String[] ver1=version1.split("\\.");
        String[] ver2=version2.split("\\.");
        int i=0;
        int j=0;
        //从主版本号到次版本号依次进行比较
        while(i<ver1.length && j<ver2.length)
        {
            if(Integer.parseInt(ver1[i])<Integer.parseInt(ver2[j]))
                return -1;
            else if(Integer.parseInt(ver1[i])>Integer.parseInt(ver2[j]))
                return 1;
            else
            {
                i++;
                j++;
            }
        }
        //version1比较长
        if(i<ver1.length)
        {
            //特殊处理‘1.0’和‘1’这种情况
            if(Integer.parseInt(ver1[i])==0)
                return 0;
            else
                return 1;
        }
        //version2比较长
        if(j<ver2.length)
        {
            //特殊处理‘1.0’和‘1’这种情况
            if(Integer.parseInt(ver2[j])==0)
                return 0;
            else
                return -1;
        }
        return 0;        
    }
}