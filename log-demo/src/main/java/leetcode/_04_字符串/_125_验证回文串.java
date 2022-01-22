package leetcode._04_字符串;

import static leetcode.od._s2_1_没有回文串.containsPalindrome;

/**
 * @author pppppp
 * @date 2022/1/22 9:48
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 解释："amanaplanacanalpanama" 是回文串
 *
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 * 解释："raceacar" 不是回文串

 */
public class _125_验证回文串 {

   public static void main(String[] args) {
       Object[][] nums = {
               {"A man, a plan, a canal: Panama",true},
               {"race a car",false},
               {"ab_a",true},
       };
       for (int i = 2; i < nums.length; i++) {
           System.out.println(isPalindrome((String) nums[i][0]) == (boolean)nums[i][1]);
       }
   }
    public static boolean isPalindrome(String s) {
        String s1 = s.replaceAll("\\W|_", "").toLowerCase();
        int l =0,r = s1.length()-1;
        while (r>=l){
            if(s1.charAt(l++) != s1.charAt(r--)){
                return false;
            }
        }
        return true;
    }
}
