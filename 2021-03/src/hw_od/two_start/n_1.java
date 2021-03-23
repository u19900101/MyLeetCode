package hw_od.two_start;

import org.junit.Test;

/**
 * @author lppppp
 * @create 2021-03-23 20:40
 */
public class n_1 {
    //【没有回文串】 字典序 不包含回文串  下一个字串
    @Test
    public void T_num_1(){
    //    in  cba
    //    out no
        String in = "acb"; // bac
        // String in2 = "abcdb";
        // in = exchangeStr(in,0,1);
        // System.out.println(in.compareTo(in2));


        int len = in.length();
        String res = "NO";
        for (int i = 1; i < in.length(); i++) {
            String subStr = in.substring(len-1-i);
            String nextDicStr = nextDicStr(subStr);
            if(nextDicStr != null){
                res = in.substring(0,i)+nextDicStr;
                break;
            }
        }
        System.out.println(res);
    }

    private String nextDicStr(String subStr) {

        int len = subStr.length();
        String firstStr = subStr.substring(0,1);
        while (len>=2){
            String temp =  subStr.substring(len-1,len);
            if(temp.compareTo(firstStr)>0){
                // 除去第一个字符后，余下的字串中存在比第一字符大的字母
                // 1.交换 余下字符中最小的字符

                // 2.将交换后的字符进行从小到大排序
                return  exchangeStr(subStr, 0, len-1);
            }
            len--;
        }
        return null;
    }


    private String exchangeStr(String in, int i, int j) {
        char[] chars = in.toCharArray();
        char temp = in.charAt(i);
        chars[i] = chars[j];
        chars[j] = temp;
        return String.valueOf(chars);
    }


}
