import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author 郭正龙
 * @date 2022-05-23
 */
public class LeetCode {
    @Test
    public void test1() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String str;
        while ((str = bf.readLine()) != null){
            int len = str.length();
            String s = str.substring(2,len);

            int sum = 0;
            for (int i = s.length() -1; i >= 0; i--) {
                char c = s.charAt(i);
                int temp = c;

                if (temp >= 65){
                    temp = temp -65 + 10;
                }else {
                    temp = temp - 48;
                }

                sum += temp * Math.pow(16,s.length() -i);
            }
            System.out.println(sum);
        }
    }


    @Test
    public void test2(){
        String str = new String("1");
        char c = str.charAt(0);
        int ret = (int)c;
        System.out.println(ret);
    }
}
