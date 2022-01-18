package leetcode._7_栈和队列;

import org.junit.Test;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * @author pppppp
 * @date 2022/1/18 15:27
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。

 * 示例 1：
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 *
 * 示例 2：
 * 输入：nums = [1], k = 1
 * 输出：[1]
 *
 * 示例 3：
 * 输入：nums = [1,-1], k = 1
 * 输出：[1,-1]
 *
 * 示例 4：
 * 输入：nums = [9,11], k = 2
 * 输出：[11]
 *
 * 示例 5：
 * 输入：nums = [4,-2], k = 2
 * 输出：[4]

 */
public class _239_滑动窗口最大值 {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] res = {3,3,5,5,6,7};
        // int[] nums = {1,-1};
        // int[] res = {1,-1};
        int[] maxSlidingWindow = maxSlidingWindow(nums, 3);
        for (int i = 0; i < maxSlidingWindow.length; i++) {
            System.out.println(res[i] == maxSlidingWindow[i]);
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length<2){
            return Arrays.copyOfRange(nums,0,1);
        }
        /*得到最大值和次大值*/
        int[] maxs = get2Max(nums,0, k - 1);
        int max = maxs[0];
        int max2 = maxs[1];
        for (int i = 0; i + k < nums.length; i++) {
            nums[i]  = max;
            if(nums[i+k] > max2){
                if(nums[i+k] > max){
                    max2 = max;
                    max = nums[i+k];
                }else {
                    max2 = nums[i+k];
                }
            }

        }
        return Arrays.copyOfRange(nums,0,nums.length-k+1);
    }

    /*提取最大的前两个数*/
    private static int[] get2Max(int[] nums, int l, int r) {

        int max = Math.max(nums[l],nums[l+1]);
        int max2 = Math.min(nums[l],nums[l+1]);
        for (int i = l+1; i <= r; i++) {
            if(nums[i] > max){
                max2 = max;
                max = nums[i];
            }
        }
        return new int[]{max,max2};
    }
    private static int getMax(int[] nums, int l, int r) {
        int max = nums[l];
        for (int i = l+1; i <= r; i++) {
            max = Math.max(nums[i],max);
        }
        return max;
    }
}
