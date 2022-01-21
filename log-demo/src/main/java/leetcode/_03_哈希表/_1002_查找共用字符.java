package leetcode._03_哈希表;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pppppp
 * @date 2022/1/21 21:56
 * 给你一个字符串数组 words ，请你找出所有在 words 的每个字符串中都出现的共用字符（ 包括重复字符），
 * 并以数组形式返回。你可以按 任意顺序 返回答案。
 * <p>
 * 示例 1：
 * 输入：words = ["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 * <p>
 * 输入：words = ["cool","lock","cook"]
 * 输出：["c","o"]
 */
public class _1002_查找共用字符 {
    public static void main(String[] args) {
        String[][] nums = {{"bella", "label", "roller"}, {"cool", "lock", "cook"}};
        String[][] res = {{"e", "l", "l"}, {"c", "o"}};
        for (int i = 0; i < nums.length; i++) {
            List<String> strings = commonChars(nums[i]);
            for (int j = 0; j < strings.size(); j++) {
                System.out.println(strings.get(i).equals(res[i][j]));
            }
        }
    }

    public static List<String> commonChars(String[] words) {
        ArrayList<String> list = new ArrayList<>();
        int[][] count = new int[words.length][26];
        for (int i = 0; i < words.length; i++) {
            count[i] = getCharCount(words[i]);
        }

        for (int i = 0; i < 26; i++) {
            int min = count[0][i];
            for (int j = 0; j < words.length; j++) {
                if (min == 0) {
                    break;
                } else if (count[j][i] < min) {
                    min = count[j][i];
                }
            }
            while (min-- > 0){
                list.add(String.valueOf((char) (i+'a')));
            }
        }
        return list;
    }


    public static int[] getCharCount(String word) {
        int[] count = new int[26];
        for (char c : word.toCharArray()) {
            count[c - 'a']++;
        }
        return count;
    }
}
