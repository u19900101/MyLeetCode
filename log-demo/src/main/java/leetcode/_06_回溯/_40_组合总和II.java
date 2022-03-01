package leetcode._06_回溯;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author pppppp
 * @date 2022/3/1 15:11
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * 注意：解集不能包含重复的组合。 
 * 示例 1:
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * <p>
 * 示例 2:
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 */
public class _40_组合总和II {

    @Test
    public void T_() {
        // int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        // int target = 8;

        int[] candidates = {2,5,2,1,2};
        int target = 5;
        List<List<Integer>> lists = combinationSum2(candidates, target);
        System.out.println();
    }

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0);
        return res;
    }

    public void dfs(int[] candidates, int target, int index) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
        }

        if (target < 0 || index == candidates.length) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            path.add(candidates[i]);
            dfs(candidates, target - candidates[i], i + 1);
            path.removeLast();
            /*进行去重操作 跳过重复项*/
            while (i <= candidates.length-2 && candidates[i] == candidates[i+1]) {
                i++;
            }
        }
    }
}
