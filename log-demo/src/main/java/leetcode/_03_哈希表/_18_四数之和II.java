package leetcode._03_哈希表;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author pppppp
 * @date 2022/1/25 11:07
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 * <p>
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 * 示例 1：
 * <p>
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 */
public class _18_四数之和II {

    public static void main(String[] args) {
        int[][] nums = {{0, -5, 5, 1, 1, 2, -5, 5, -3}, {1, 0, -1, 0, -2, 2}, {2, 2, 2, 2, 2}};
        int[] target = {-11, 0, 8};
        int[][][] res = {{{-2, -1, 1, 2}, {-2, 0, 0, 2}, {-1, 0, 0, 1}}, {{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}}};
        for (int i = 2; i < nums.length; i++) {
            List<List<Integer>> lists = fourSumFromThree(nums[i], target[i]);
            System.out.println();
        }
    }

    public static List<List<Integer>> fourSumFromThree(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            /*跳过重复项*/
            while (i > 0 && i < nums.length && nums[i - 1] == nums[i]) {
                i++;
            }
            if (i >= nums.length - 3) {
                break;
            }
            res.addAll(threeSum(nums, i, target - nums[i]));
        }
        return res;
    }

    public static List<List<Integer>> threeSum(int[] nums, int startIndex, int target) {
        List<List<Integer>> res = new ArrayList<>();
        for (int l = startIndex + 1; l < nums.length; l++) {
            /*跳过重复项*/
            while (l > startIndex + 1 && l < nums.length && nums[l - 1] == nums[l]) {
                l++;
            }
            if (l >= nums.length - 2) {
                break;
            }
            int m = l + 1;
            int r = nums.length - 1;
            int t = target - nums[l];
            List<List<Integer>> temp = new ArrayList<>();
            while (m < r) {
                if (nums[m] + nums[r] == t) {
                    temp.add(Arrays.asList(nums[startIndex], nums[l], nums[m], nums[r]));
                    m++;
                    r--;
                    /*跳过重复项*/
                    while (m < r && nums[m] == nums[m - 1]) {
                        m++;
                    }
                    while (m < r && nums[r] == nums[r + 1]) {
                        r--;
                    }
                } else if (nums[m] + nums[r] < t) {
                    m++;
                } else {
                    r--;
                }
            }
            res.addAll(temp);
        }
        return res;
    }

    /*朴素解法--穷举  暴力解法--能ac*/
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        HashSet<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    for (int l = k + 1; l < nums.length; l++) {
                        if (l < nums.length && nums[i] + nums[j] + nums[k] + nums[l] == target) {
                            set.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                            /*跳过重复项*/
                            while (l < nums.length && nums[l] == nums[l - 1]) {
                                l++;
                            }
                        }
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }
}
