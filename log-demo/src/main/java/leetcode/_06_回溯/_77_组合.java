package leetcode._06_回溯;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author pppppp
 * @date 2022/2/21 12:18
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * <p>
 * 你可以按 任何顺序 返回答案。
 * 示例 1：
 * <p>
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * 示例 2：
 * <p>
 * 输入：n = 1, k = 1
 * 输出：[[1]] +++++++++++++++++
 */
public class _77_组合 {

    public static void main(String[] args) {
        int[][] nums = {{4, 2}, {1, 1}};
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> combine = combine(nums[i][0], nums[i][1]);
            System.out.println(combine);
        }
    }

    static List<Integer> temp = new ArrayList<Integer>();
    static List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public static List<List<Integer>> combine(int n, int k) {
        dfss(n, k, 1, ans);
        return ans;
    }

    private static void dfss(int n, int k, int curIndex, List<List<Integer>> ans) {

        /*也即下方的for中控制剪枝操作*/
       /* if (n - curIndex + 1 < k - temp.size()) {
            return;
        }*/
        if (temp.size() == k) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = curIndex; i <= n -(k - temp.size()) + 1; i++) {
        // for (int i = curIndex; i <= n; i++) {
            temp.add(i);
            dfss(n, k, i + 1, ans);
            temp.remove(temp.size() - 1);
        }
    }

    /*public static List<List<Integer>> combine(int n, int k) {
        dfs(1, n, k);
        return ans;
    }*/

    public static void dfs(int cur, int n, int k) {
        // 剪枝：temp 长度加上区间 [cur, n] 的长度小于 k，不可能构造出长度为 k 的 temp
        if (temp.size() + (n - cur + 1) < k) {
            return;
        }
        // 记录合法的答案
        if (temp.size() == k) {
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        // 考虑选择当前位置
        temp.add(cur);
        dfs(cur + 1, n, k);
        temp.remove(temp.size() - 1);
        // 考虑不选择当前位置
        dfs(cur + 1, n, k);
    }

}
