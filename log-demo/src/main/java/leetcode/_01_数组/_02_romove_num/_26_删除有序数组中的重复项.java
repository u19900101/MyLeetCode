package leetcode._01_数组._02_romove_num;

/**
 * @author pppppp
 * @date 2022/1/16 8:43
 * 给你一个有序数组 nums (已按升序排列)，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：2, nums = [1,2]
 * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
 * 示例 2：
 * <p>
 * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
 * 输出：5, nums = [0,1,2,3,4]
 * 解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
 */
public class _26_删除有序数组中的重复项 {
    public static void main(String[] args) {
        int[][] nums = {{1, 1, 2}, {0, 0, 1, 1, 1, 2, 2, 3, 3, 4}};
        int[][] res = {{1, 2}, {0, 1, 2, 3, 4}};
        int[] vals = {2, 5};
        for (int i = 0; i < nums.length; i++) {
            int r = removeDuplicates(nums[i]);
            if (r != vals[i]) {
                System.out.println("failed...");
            }
            for (int j = 0; j < r; j++) {
                if (res[i][j] != nums[i][j]) {
                    System.out.println("failed...");
                    return;
                }
            }
        }
    }

    public static int removeDuplicates(int[] nums) {

        int l = 0, r = 1;
        while (r <= nums.length -1) {
            if (nums[l] != nums[r]) {
                l++;
                /*覆盖操作*/
                if( nums[l] != nums[r]) {
                    nums[l] = nums[r];
                }
            }
            r++;
        }
        return ++l;
    }
}
