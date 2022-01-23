package leetcode._03_哈希表;

import java.util.HashMap;

/**
 * @author pppppp
 * @date 2022/1/23 16:07
 * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
 * <p>
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 * <p>
 * 示例 1：
 * 输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
 * 输出：2
 * 解释：
 * 两个元组如下：
 * 1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
 * <p>
 * 示例 2：
 * 输入：nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
 * 输出：1
 */
public class _454_四数相加II {
    public static void main(String[] args) {
        int[][][] nums = {
                {{-1,1,1,1,-1},{0,-1,-1,0,1},{-1,-1,1,-1,-1},{0,1,0,-1,-1}},
                {{1, 2}, {-2, -1}, {-1, 2}, {0, 2}},
                {{0},{0},{0},{0}}};
        int[] res = {132,2,1};
        for (int j = 0; j < nums.length; j++) {
            System.out.println(fourSumCount(nums[j][0], nums[j][1], nums[j][2], nums[j][3]) == res[j]);
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

    private static int getSum(HashMap<Integer, Integer> target, int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int n1 : nums1) {
            map.put(n1,map.getOrDefault(n1,0)+1);
        }
        for (Integer t : target.keySet()) {
            for (int n2 : nums2) {
                if(map.containsKey(t-n2)){
                    count += map.get(t-n2)*target.get(t);
                }
            }
        }
        return count;
    }
}
