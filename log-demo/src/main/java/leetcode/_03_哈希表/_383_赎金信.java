package leetcode._03_哈希表;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

import static leetcode._03_哈希表._242_有效的字母异位词.getCharCountMap;

/**
 * @author pppppp
 * @date 2022/1/21 15:30
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 *
 * 如果可以，返回 true ；否则返回 false 。
 *
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 *
 * 示例 1：
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 *
 * 示例 2：
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 *
 * 示例 3：
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true

 */
public class _383_赎金信 {
    public static void main(String[] args) {
        String[] nums = {"a", "aa","aa","bg"};
        String[] nums2 = {"b", "ab","aab","efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj"};
        boolean[] res = {false,false,true,true};
        for (int i = 0; i < nums.length; i++) {
            boolean b = canConstruct4(nums[i], nums2[i]);
            System.out.println( b == res[i]);
        }
    }
    public static boolean canConstruct2(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()){
            return false;
        }
        HashMap<Character, Integer> rMap = getCharCountMap(ransomNote);
        HashMap<Character, Integer> mMap = getCharCountMap(magazine);
        for (Character character : rMap.keySet()) {
            if(mMap.get(character) == null  || rMap.get(character) > mMap.get(character)){
                return false;
            }
        }
        return true;
    }

    /*还是可以使用数组简单的实现*/
    public static boolean canConstruct4(String ransomNote, String magazine) {
        for (char c : ransomNote.toCharArray()) {
            if(magazine.indexOf(c) == -1){
                return false;
            }else {
                magazine = magazine.replaceFirst(String.valueOf(c),"");
            }
        }
        return true;
    }
    /*还是可以使用数组简单的实现*/
    public static boolean canConstruct3(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()){
            return false;
        }
        int[] counts = new int[52];
        for (char c : magazine.toCharArray()) {
            counts[c >= 'a' ? c-'a' + 26 : c - 'A']++;
        }

        for (char c : ransomNote.toCharArray()) {
            int index = c >= 'a' ? c - 'a' + 26 : c - 'A';
            if(--counts[index] < 0){
                return false;
            }
        }
        return true;
    }
    public static boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()){
            return false;
        }
        int[] counts = new int[52];
        for (char c : ransomNote.toCharArray()) {
            counts[c >= 'a' ? c-'a' + 26 : c - 'A']++;
        }

        for (char c : magazine.toCharArray()) {
            int index = c >= 'a' ? c - 'a' + 26 : c - 'A';
            if(counts[index] > 0){
                counts[index]--;
            }
        }
        for (int count : counts) {
            if(count > 0){
                return false;
            }
        }
        return true;
    }
}
