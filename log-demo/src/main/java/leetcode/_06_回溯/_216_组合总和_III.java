package leetcode._06_回溯;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pppppp
 * @date 2022/2/24 14:04
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * <p>
 * 说明：
 * <p>
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 * <p>
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class _216_组合总和_III {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    @Test
    public void T_() {
        // List<List<Integer>> lists = combinationSum3(3, 9);
        List<List<Integer>> lists = combinationSum3(3, 7);
        System.out.println();
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (n > 45 || k > 9) {
            return ans;
        }
        dfs2(k, n, 9, ans);
        return ans;
    }

    private void dfs2(int k, int n, int curIndex, List<List<Integer>> ans) {

        if (k == 0 && n == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        if (n < sumN(k)) {
            return;
        }
        for (int i = curIndex; i >= 1; i--) {
            temp.add(i);
            dfs2(k - 1, n - i, i - 1, ans);
            temp.remove(temp.size() - 1);
        }
    }

    private int sumN(int k) {
        int sum = 0;
        while (k > 0) {
            sum += k;
            k--;
        }
        return sum;
    }
}
