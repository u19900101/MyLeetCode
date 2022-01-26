package leetcode._04_字符串;

import org.junit.Test;

/**
 * @author pppppp
 * @date 2022/1/26 9:05
 * 实现 strStr() 函数。
 * <p>
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。
 * 如果不存在，则返回  -1
 * 示例 1：
 * <p>
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：haystack = "aaaaa", needle = "bba"
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：haystack = "", needle = ""
 * 输出：0
 */
public class _128_实现strStr {
    @Test
    public void T_() {
        String[] s = {"hello", "aaaaa", ""};
        String[] r = {"ll", "bba", ""};
        int[] nums = {2, -1, 0};
        for (int i = 0; i < s.length; i++) {
            System.out.println(strStr(s[i], r[i]) == nums[i]);
        }
    }

    public static int strStr(String haystack, String needle) {

        return haystack.indexOf(needle);
    }

    @Test
    public void T_2() {
        int i = strStr4("aabaabaaf", "aabaaf");
        System.out.println(i);
    }

    public int strStr4(String haystack, String needle) {
        // KMP算法：如果已经匹配的字符串包含相同的前缀和后缀，
        // 遇到下一个不匹配的位置时，指向needle的指针跳转到前缀的后一个位置，
        // 还是不匹配的话，再往前跳转后继续比较；先构造一个next数组来记录needle指针跳转的位置
        int n = haystack.length(), m = needle.length();
        if (m == 0) {
            return 0;
        }
        // 先构造next数组，next数组中的元素表示当前两个元素不匹配时，needle指针要跳转的位置
        // haystack: [a, b, e, a, b, a, b, e, a, b, f]
        // needle:   [a, b, e, a, b, f]
        // next:     [0, 0, 0, 1, 2, 0]
        int[] next = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = next[j - 1]; // 一直和前一位置的值比较，直到遇到相等的字符或者j=0；j通过next[j-1]来回退
            }

            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        // 利用next数组进行跳转匹配，不再需要回退haystack的指针i
        for (int i = 0, j = 0; i < n; i++) {
            // 匹配不成功，needle指针j回退并继续比较
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }

            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }
}
