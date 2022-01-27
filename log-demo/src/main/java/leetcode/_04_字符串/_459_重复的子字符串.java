package leetcode._04_字符串;

/**
 * @author pppppp
 * @date 2022/1/26 16:30
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。
 * 给定的字符串只含有小写英文字母，并且长度不超过10000。
 * <p>
 * 示例 1:
 * 输入: "abab"
 * 输出: True
 * <p>
 * 解释: 可由子字符串 "ab" 重复两次构成。
 * 示例 2:
 * 输入: "aba"
 * 输出: False
 * <p>
 * 示例 3:
 * 输入: "abcabcabcabc"
 * 输出: True
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 */
public class _459_重复的子字符串 {

    public static void main(String[] args) {
        String[] s = {"ab", "bb", "abab", "aba", "abcabcabcabc"};
        boolean[] r = {false, true, true, false, true};
        for (int i = 0; i < s.length; i++) {
            System.out.println(repeatedSubstringPattern2(s[i]) == r[i]);
        }
    }

    public static boolean repeatedSubstringPattern2(String s) {
        if (s.length() < 2) {
            return false;
        }
        if (s.length() == 2) {
            return s.charAt(0) == s.charAt(1);
        }
        char lastC = s.charAt(s.length() - 1);
        if (s.replaceAll(String.valueOf(lastC), "").length() == 0) {
            return true;
        }
        for (int j = 1; j < s.length() / 2; j++) {
            if (s.charAt(j) == lastC && s.length() % (j + 1) == 0) {
                String tmp = s.substring(0, j + 1);
                if (s.replaceAll(tmp, "").length() == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /*高端解法 s+s 去掉头尾字符串 判断是否包含s*/
    public boolean repeatedSubstringPattern(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }


    public boolean repeatedSubstringPattern3(String s) {
        int n = s.length();
        for (int i = 1; i * 2 <= n; ++i) {
            if (n % i == 0) {
                boolean match = true;
                for (int j = i; j < n; ++j) {
                    if (s.charAt(j) != s.charAt(j - i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
            }
        }
        return false;
    }

}
