package leetcode._01_数组._02_romove_num;

/**
 * @author pppppp
 * @date 2022/1/16 15:34
 * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，请你判断二者是否相等。# 代表退格字符。
 * 如果相等，返回 true ；否则，返回 false 。
 * <p>
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * 示例 1：
 * 输入：s = "ab#c", t = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * <p>
 * 示例 2：
 * 输入：s = "ab##", t = "c#d#"
 * 输出：true
 * 解释：s 和 t 都会变成 “”。
 * <p>
 * 示例 3：
 * 输入：s = "a##c", t = "#a#c"
 * 输出：true
 * 解释：s 和 t 都会变成 “c”。
 * <p>
 * 示例 4：
 * 输入：s = "a#c", t = "b"
 * 输出：false
 * 解释：s 会变成 “c”，但 t 仍然是 “b”。
 */
public class _844_比较含退格的字符串 {
    public static void main(String[] args) {
        String[] s = {"ab#c", "ab##", "a##c", "a#c"};
        String[] t = {"ad#c", "c#d#", "#a#c", "b"};
        boolean[] res = {true, true, true, false};
        for (int i = 0; i < s.length; i++) {
            System.out.println(backspaceCompare(s[i], t[i]) == res[i]);
        }
    }

    public static boolean backspaceCompare(String s, String t) {
        s = getPre(s);
        t = getPre(t);
        return s.equals(t);
    }

    private static String getPre(String s) {
        int l = 0, r = 0;
        char[] chars = s.toCharArray();
        while (l <= r && r<chars.length) {
            if (chars[r] != '#') {
                chars[l] = chars[r];
                l++;
            } else {
                l--;
                if (l < 0) {
                    l = 0;
                }
            }
            r++;
        }
        return String.valueOf(chars).substring(0, l);
    }
}
