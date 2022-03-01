package leetcode._06_回溯;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author pppppp
 * @date 2022/3/1 17:40
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * <p>
 * 回文串 是正着读和反着读都一样的字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 示例 2：
 * <p>
 * 输入：s = "a"
 * 输出：[["a"]]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 16
 * s 仅由小写英文字母组成
 */
public class _131_分割回文串 {

    List<List<String>> res = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();

    @Test
    public void T_(){
        List<List<String>> aabaa = partition("a");
        System.out.println();
    }
    public List<List<String>> partition(String s) {
        if (s.length() == 0) {
            return res;
        }
        dfs(s);
        return res;
    }

    public void dfs(String s) {

        if (s.length() == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            String temp = s.substring(0, i + 1);
            if (isHuiWen(temp)) {
                path.add(temp);
                dfs(s.substring(i+1));
                path.removeLast();
            }
        }
    }

    private boolean isHuiWen(String sub) {
        if(sub.length() <= 1){
            return true;
        }
        int l = 0, r = sub.length() - 1;
        while (l < r) {
            if (sub.charAt(l) != sub.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
