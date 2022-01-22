package leetcode.od;

import org.junit.Test;

/**
 * @author pppppp
 * @date 2022/1/22 8:53
 * 3,cba,NO
 * 3,abc,acb
 * 3,cab,cba
 */
public class _s2_1_没有回文串 {
    public static void main(String[] args) {
        String[][] nums = {
                {"3", "cba", "NO"},
                {"3", "abc", "acb"},
                {"3", "cab", "cba"}};
        for (int i = 1; i < nums.length; i++) {
            System.out.println(nextNoPalindrome(Integer.valueOf(nums[i][0]), nums[i][1]).equals(nums[i][2]));
        }
    }

    public static String nextNoPalindrome(int n, String s) {
        String ns = getNextStr(n, s);
        while (containsPalindrome(ns)) {
            ns = getNextStr(n, ns);
        }
        return ns;
    }

    public static boolean containsPalindrome(String s) {
        if(s.length() == 1){
            return true;
        }
        /*检测是否包含 aa axa bb  bxb cc... 的 字串*/
        int l = 0;
        while (l<= s.length()-3){
            if(s.charAt(l) == s.charAt(l + 1) || s.charAt(l) == s.charAt(l + 2)){
                return true;
            }
            l++;
        }
        /*检测最后两个字符*/
        return s.charAt(l) == s.charAt(l + 1);
    }



    private static String getNextStr(int n, String s) {
        char max = (char) ('a' + n - 1);
        StringBuilder sb = new StringBuilder(s);
        int index = s.length() - 1;
        while (index >= 0) {
            char curC = s.charAt(index);
            if (curC != max) {
                sb.setCharAt(index, (char) (curC + 1));
                return sb.toString();
            }else {
                /*后续的所有位都置 'a' */
                for (int i = index; i < s.length(); i++) {
                    sb.setCharAt(i, 'a');
                }
            }
            index--;
        }
        return "NO";
    }
}
