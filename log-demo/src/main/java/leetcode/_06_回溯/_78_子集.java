package leetcode._06_回溯;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author pppppp
 * @date 2022/3/2 10:49
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * <p>
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 */
public class _78_子集 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    @Test
    public void T_() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = subsets2(nums);
        System.out.println();
    }

    /*二进制全排*/
    public List<List<Integer>> subsets2(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < 1 << len; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            int index = 0;
            while ((1 << index) <= i) {
                if (((1 << index) & i) != 0) {
                    list.add(nums[index]);
                }
                index++;
            }
            res.add(new ArrayList<>(list));
        }
        return res;
    }

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int beginIndex) {
        if (beginIndex == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        dfs(nums, beginIndex + 1);
        path.add(nums[beginIndex]);
        dfs(nums, beginIndex + 1);
        path.removeLast();
    }
}
