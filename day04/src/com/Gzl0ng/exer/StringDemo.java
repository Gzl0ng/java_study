package com.Gzl0ng.exer;

import org.junit.Test;

public class StringDemo {
//    1.模拟一个trim方法，去除字符串两端的空格。
    public String mytrim(String str){
        if(str != null){
            int start = 0;//记录首部不为空的字符是第几个
            int end = str.length() - 1;//记录尾部不为空的字符是第几个
            while (true){
                if (start < end && str.charAt(start) == ' '){
                    start++;
                }else {
                    break;
                }
            }

            while (true){
                if (start < end && str.charAt(end) == ' '){
                    end--;
                }else {
                    break;
                }
            }

            if (str.charAt(start) == ' '){
                return "";
            }

            return str.substring(start,end + 1);

        }else {
            return null;
        }
    }

//    将一个字符串进行反转。将字符串中指定部分进行反转。比如将“abcdefg”反转为”abfedcg”
    /*
    方式一：转换为char[]
     */

    public String myReverse(String str,int start,int end){
        if (str != null){
            char[] arr = str.toCharArray();
            for (int x = start,y = end;x < y;x++,y--) {
                char temp = arr[x];
                arr[x] = arr[y];
                arr[y] = temp;
            }
            return new String(arr);
        }
        return null;
    }
    /*
    方式二：使用String的拼接
     */
    public String myReverse1(String str,int start,int end){
        if(str != null){
            //第1部分
            String reverseStr = str.substring(0,start);
            //第2部分
            for (int i = end;i >= start;i--){
                reverseStr += str.charAt(i);
            }
            //第3部分
            reverseStr += str.substring(end +1);
            return reverseStr;
        }
        return null;
    }
    //方式三：使用StringBuffer/StringBuilder，替换String
    public String myReverse2(String str,int start,int end){
       if (str != null){
           StringBuilder builder = new StringBuilder(str.length());

           //第1部分
           builder.append(str.substring(0,start));
           //第2部分
           for (int i = end;i >= start;i--){
               builder.append(str.charAt(i));
           }
           //第3部分
           builder.append(str.substring(end + 1));

           return builder.toString();
       }
       return null;
    }

    @Test
    public void testReverse(){
        String str = "abcdefg";
        String reverse = myReverse2(str,2,5);
        System.out.println(reverse);
    }


}
