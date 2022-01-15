package zuo.leetcode;

/**
 * @author pppppp
 * @date 2022/1/15 9:41
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * 示例 1:
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * <p>
 * 示例 3:
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 * <p>
 * 示例 4:
 * 输入: nums = [1,3,5,6], target = 0
 * 输出: 0
 * <p>
 * 示例 5:
 * 输入: nums = [1], target = 0
 * 输出: 0
 */
public class _035_搜索插入位置 {
    public static void main(String[] args) {
        // int[] nums = {1, 3, 5, 6};
        // int[] target = {5, 2, 7, 0, 0};
        // int[] expected = {2, 1, 4, 0, 0};

        int[] nums = {1, 2};
        int[] target = {0,3};
        int[] expected = {0,2};

        for (int i = 0; i < target.length; i++) {
            int res = searchInsert(nums, target[i]);
            System.out.println(res == expected[i]);
        }
    }

    public static int searchInsert(int[] nums, int target) {

        /*判断目标值在开头还是结尾*/
        if (target == nums[0] || target == nums[nums.length - 1]) {
            return target == nums[0] ? 0 : nums.length - 1;
        }

        if (target < nums[0] || target > nums[nums.length - 1]) {
            return target < nums[0] ? 0 : nums.length;
        }

        int L = 0;
        int R = nums.length - 1;
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (nums[mid] < target) {
                L = mid + 1;
            } else if (nums[mid] > target) {
                R = mid - 1; //当R = L + 1时，此时的操作将使R = L-1
            } else {
                return mid;
            }
        }
        /*在数组中不存在该数，返回应该插入的位置*/
        // return target > nums[L] ? L + 1 : L;
        return R + 1;
    }
}
