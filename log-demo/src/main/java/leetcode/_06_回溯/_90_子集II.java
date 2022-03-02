package leetcode._06_回溯;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author pppppp
 * @date 2022/3/2 15:10
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：[[],[0]]
 */
public class _90_子集II {


    @Test
    public void T_(){
        int []nums = {1,2,2};
        List<List<Integer>> lists = subsetsWithDup(nums);
        System.out.println();
    }
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int index) {
        res.add(new ArrayList<>(path));
        if(index == nums.length){
            return;
        }

        for (int i = index; i < nums.length; i++) {
            /*去重的重要步骤 保留第一次的相同值 跳过同一层的相同值*/
            if (i > index && nums[i - 1] == nums[i]) {
                continue;
            }
            path.add(nums[i]);
            dfs(nums,i+1);
            path.removeLast();
        }
    }
}
