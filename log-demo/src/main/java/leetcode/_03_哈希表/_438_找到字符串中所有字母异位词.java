package leetcode._03_哈希表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author pppppp
 * @date 2022/1/21 20:05
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。
 * 不考虑答案输出的顺序。
 * <p>
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * <p>
 * 示例 1:
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 * <p>
 * 示例 2:
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 */
public class _438_找到字符串中所有字母异位词 {
    public static void main(String[] args) {
        String[] nums = {"cbaebabacd", "abab","a"};
        String[] nums2 = {"abc", "ab","aa"};
        int[][] res = {{0, 6}, {0, 1, 2}};
        for (int i = 2; i < nums.length; i++) {
            List<Integer> anagrams = findAnagrams(nums[i], nums2[i]);
            for (int j = 0; j < anagrams.size(); j++) {
                System.out.println(anagrams.get(j).equals(res[i][j]));
            }
        }
    }

    public static List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> res = new ArrayList<>();
        if (p.length() > s.length()) {
            return res;
        }
        char[] charArray = p.toCharArray();
        Arrays.sort(charArray);
        p = String.valueOf(charArray);
        for (int i = 0; i <= s.length() - p.length(); i++) {
            char[] temp = s.substring(i, i + p.length()).toCharArray();
            Arrays.sort(temp);
            if (p.equals(String.valueOf(temp))) {
                res.add(i);
                while (i + p.length() < s.length() && s.charAt(i) == s.charAt(i + p.length())) {
                    res.add(++i);
                }
            }
        }
        return res;
    }

    public List<Integer> findAnagrams3(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; ++i) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }

        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; ++i) {
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + pLen) - 'a'];

            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }

        return ans;
    }

    private static boolean isAnagram(String s, String str) {
        if (s.length() != str.length()) {
            return false;
        }
        char[] charArray1 = s.toCharArray();
        char[] charArray2 = str.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        return Arrays.equals(charArray1, charArray2);
    }
}
