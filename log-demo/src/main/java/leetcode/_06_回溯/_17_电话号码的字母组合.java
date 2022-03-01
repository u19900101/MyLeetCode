package leetcode._06_回溯;

import org.junit.Test;
import sun.plugin.javascript.navig.LinkArray;

import java.util.*;

/**
 * @author pppppp
 * @date 2022/3/1 11:04
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 示例 1：
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 *
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 *
 * 输入：digits = "2"
 * 输出：["a","b","c"]

 */
public class _17_电话号码的字母组合 {

    @Test
    public void T_(){
        List<String> strings = letterCombinations("23");

    }
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    String [] base = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        solution(digits,0);
        return res;
    }

    public void solution(String digits,int curIndex){
        if(digits.length() == 0){
            return;
        }
        if(sb.length() == digits.length()){
            res.add(sb.toString());
            return;
        }

        for (char c : base[digits.charAt(curIndex)-'2'].toCharArray()) {
            sb.append(c);
            solution(digits,curIndex+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
