package leetcode._01_数组._01_binary_search;

/**
 * @author pppppp
 * @date 2022/1/15 10:58
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 进阶：
 * <p>
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *  
 * <p>
 * 示例 1：
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * <p>
 * 示例 2：
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * <p>
 * 示例 3：
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 */
public class _34_在排序数组中查找元素的第一个和最后一个位置 {
    public static void main(String[] args) {
        int[][] nums = {{5, 7, 7, 8, 8, 10}, {5, 7, 7, 8, 8, 10}, {}};
        int[][] res = {{3, 4}, {-1, -1}, {-1, -1}};
        int[] target = {8, 6, 0};
        for (int i = 0; i < nums.length; i++) {
            System.out.println(
                    res[i][0] == searchRange(nums[i], target[i])[0]
                            && res[i][1] == searchRange(nums[i], target[i])[1]);
        }

    }

    public static int[] searchRange(int[] nums, int target) {
        /*越界直接返回*/
        if (nums.length == 0 || target < nums[0] || target > nums[nums.length - 1]) {
            return new int[]{-1, -1};
        }
        /*等于左边界 向右查找*/
        if (target == nums[0]) {
            int i = 1;
            while (i <= nums.length - 1 && target == nums[i]) {
                i++;
            }
            return new int[]{0, --i};
        }
        /*等于右边界 向左查找*/
        if (target == nums[nums.length - 1]) {
            int i = nums.length - 2;
            while (i > 0 && target == nums[i]) {
                i--;
            }
            return new int[]{++i, nums.length - 1};
        }

        /*二分查找*/
        int L = 0;
        int R = nums.length - 1;
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (nums[mid] > target) {
                R = mid - 1;
            } else if (nums[mid] < target) {
                L = mid + 1;
            } else {
                //    向左向右同时搜索
                int l = mid;
                int r = mid;
                // 向左搜索
                while (l > 0 && target == nums[l]) {
                    l--;
                }
                // 向右搜索
                while (r <= nums.length - 1 && target == nums[r]) {
                    r++;
                }
                return new int[]{++l, --r};
            }
        }
        return new int[]{-1, -1};
    }
}
