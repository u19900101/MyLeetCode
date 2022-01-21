package leetcode._03_哈希表;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author pppppp
 * @date 2022/1/21 11:17
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 *

 */
public class _242_有效的字母异位词 {
    public static void main(String[] args) {
        String[] nums = {"anagram", "rat"};
        String[] res = {"nagaram", "car"};

        for (int i = 0; i < nums.length; i++) {
            System.out.println(isAnagram(nums[i],res[i]));
        }
    }
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character,Integer> ms = getCharCountMap(s);
        HashMap<Character,Integer> mt = getCharCountMap(t);
        if(ms.size() != mt.size()){
            return false;
        }
        for (Character character : mt.keySet()) {
            if(mt.get(character) == null || !mt.get(character).equals(ms.get(character))){
                return false;
            }
        }
        return true;
    }

    public static HashMap<Character, Integer> getCharCountMap(String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c,map.getOrDefault(c,0) + 1);
        }
        return map;
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    /*改进版的hash*/
    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (char c : s.toCharArray()) {
            table[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            table[c - 'a']--;
            if(table[c - 'a'] < 0){
                return false;
            }
        }
        return true;
    }


}
