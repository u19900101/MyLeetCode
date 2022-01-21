package leetcode._03_哈希表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author pppppp
 * @date 2022/1/21 16:47
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 *示例 1:
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * 示例 2:
 * 输入: strs = [""]
 * 输出: [[""]]
 *
 * 示例 3:
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 *

 */
public class _49_字母异位词分组 {
    public static void main(String[] args) {
        String[][] nums = {{"eat", "tea", "tan", "ate", "nat", "bat"},{""},{"a"},{"","b"}};
        String[][][] res = {{{"bat"},{"nat","tan"},{"ate","eat","tea"}},{{""}},{{"a"}},{{"b"},{""}}};
        for (int i = 0; i < nums.length; i++) {
            List<List<String>> lists = groupAnagrams2(nums[i]);
            System.out.println();
        }
    }

    /*精简的做法--将分组的排序作为key，分组内容为value*/
    public static List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.copyValueOf(chars);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key,list);
        }
        for (String s : map.keySet()) {
            lists.add(map.get(s));
        }
        return lists;
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            boolean flag = false;
            for (List<String> group : lists) {
                if(isAnagram(group.get(0),strs[i])){
                    group.add(strs[i]);
                    flag = true;
                    break;
                }
            }
            if(!flag){
                ArrayList<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                lists.add(temp);
            }
        }
        return lists;
    }

    private static boolean isAnagram(String s, String str) {
        if(s.length() != str.length()){
            return false;
        }
        char[] charArray1 = s.toCharArray();
        char[] charArray2 = str.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        return Arrays.equals(charArray1,charArray2);
    }


}
