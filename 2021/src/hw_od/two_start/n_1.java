package hw_od.two_start;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author lppppp
 * @create 2021-03-23 20:40
 */
public class n_1 {
    //【没有回文串】 字典序 不包含回文串  下一个字串   3h
    /**
     *
     *
     * */
    @Test
    public void T_num_1(){
    //    in  cba
    //    out no
    //     String in = "dabca"; // bac
        String in = "cba"; // bac
        int len = in.length();
        String res = "NO";
        for (int i = 1; i < in.length(); i++) {
            String subStr = in.substring(len-1-i);
            String nextDicStr = nextDicStr(subStr);
            if(nextDicStr != null){
                res = in.substring(0,len-1-i)+nextDicStr;
                if(!containHuiWen(res)){
                    break;
                }
            }
        }
        System.out.println(res);
    }

    @Test
    public void T_nextStr(){
        String s = "bca";
        String nextDicStr = nextDicStr(s);
        System.out.println(nextDicStr);
    }
    @Test
    public void T_huiwen(){
        String s = "dacab";
        boolean b = containHuiWen(s);
        System.out.println(b);
    }
    private boolean containHuiWen(String res) {
        int subStrlen = 2;
        for (int j = 0; subStrlen <= res.length(); j++) {
            for (int i = 0; i <= res.length()-subStrlen; i++) {
                String substring = res.substring(i, i + subStrlen);
                boolean isHuiWen = isHuiWen(substring);
                if(isHuiWen){
                    return true;
                }
            }
            subStrlen++;
        }

        return false;
    }


    private boolean isHuiWen(String substring) {

        char[] chars = substring.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if(chars[i] != chars[chars.length-1-i]){
                return false;
            }
        }
        return true;
    }

    private String nextDicStr(String subStr) {

        int len = subStr.length();
        String firstStr = subStr.substring(0,1);
        while (len>=2){
            String temp =  subStr.substring(len-1,len);
            // 判断 是否存在 大于第一个字符的字母
            if(temp.compareTo(firstStr)>0){
                // 除去第一个字符后，余下的字串中存在比第一字符大的最小字母
                String sub2 = subStr;
                // 1.将 余下字符中最小的字符 作为最高位
                String minS = getMinS(sub2,firstStr);
                if(minS != null){
                    // 2.将交换后的字符进行从小到大排序
                    char[] arr = subStr.replace(minS, "").toCharArray();
                    Arrays.sort(arr);
                    sub2 = new String(arr);
                    return  minS+sub2;
                }
            }
            len--;
        }
        return null;
    }

    private String getMinS(String subStr, String s) {
        char[] chars = subStr.toCharArray();
        Arrays.sort(chars);

        String sub2 = new String(chars);
        int index = sub2.indexOf(s);
        while (index<sub2.length()-1){
            if(chars[index+1]>chars[index]){
                return String.valueOf(chars[index+1]);
            }
            index++;
        }
        return null;
    }

}
