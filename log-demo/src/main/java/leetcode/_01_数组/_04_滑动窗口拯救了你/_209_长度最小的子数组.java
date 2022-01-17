package leetcode._01_数组._04_滑动窗口拯救了你;

import org.junit.Test;


/**
 * @author pppppp
 * @date 2022/1/17 21:57
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
 * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * <p>
 * 示例 1：
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * <p>
 * 示例 2：
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * <p>
 * 示例 3：
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 */
public class _209_长度最小的子数组 {
    public static void main(String[] args) {
        int[][] nums = {{1, 1, 1, 1, 1, 1, 1, 1}, {1, 5, 5}, {2, 3, 1, 2, 4, 3},
                {1,2,3,4,5}};
        int[] res = {11, 4, 7,11};
        int[] r = {0, 1, 2,3,};
        for (int i = 1; i < nums.length-1; i++) {
            System.out.println(minSubArrayLen2(res[i], nums[i]) == r[i]);
        }
    }

    public static int minSubArrayLen2(int s, int[] nums) {
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= s) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 :result;
    }
}
