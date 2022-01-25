package leetcode._03_哈希表;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author pppppp
 * @date 2022/1/23 19:43
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 * <p>
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 * <p>
 * 示例 1：
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 */
public class _18_四数之和 {
    public static void main(String[] args) {
        int[][][] nums = {{{1,2}, {-2,-1},{-1,2},{0,2}}};
        int[] tag = {2, 8};
        for (int i = 0; i < nums.length; i++) {
            System.out.println( fourSumCount(nums[i][0], nums[i][1],nums[i][2],nums[i][3])== tag[i]);
        }
    }
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> target =  getTarget(nums1,nums2);
        HashMap<Integer, Integer> target2 =  getTarget(nums3,nums4);
        int count = 0;
        for (Integer t : target.keySet()) {
            if(target2.containsKey(-t)){
                count += target2.get(-t)*target.get(t);
            }
        }
        return count;
    }

    private static HashMap<Integer, Integer> getTarget(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> target = new HashMap<>();
        for (int n1 : nums1) {
            for (int n2 : nums2) {
                target.put(n1+n2,target.getOrDefault(n1+n2,0)+1);
            }
        }
        return target;
    }
}
