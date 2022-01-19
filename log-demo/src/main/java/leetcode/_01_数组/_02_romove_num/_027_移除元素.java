package leetcode._01_数组._02_romove_num;

/**
 * @author pppppp
 * @date 2022/1/15 21:38
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。

 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。

 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * 示例 1：
 * 输入：nums = [3,2,2,3], val = 3
 * 输出：2, nums = [2,2]
 * 解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。
 * 例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。

 * 示例 2：
 * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
 * 输出：5, nums = [0,1,4,0,3]
 * 解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 * 注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。
 */
public class _027_移除元素 {
    public static void main(String[] args) {
        int[][] nums = {{2, 2, 3, 3}, {0, 1, 2, 2, 3, 0, 4, 2},{1}};
        int[][] res = {{2, 2, 0, 0}, {0, 1, 3, 0, 4, 4, 2},{}};
        int[] vals = {3, 2,1};
        for (int i = 2; i < nums.length; i++) {
            int r = removeElement(nums[i], vals[i]);
            for (int j = 0; j < r; j++) {
                if (res[i][j] != nums[i][j]) {
                    System.out.println("failed...");
                    return;
                }
            }
        }
    }

    public static int removeElement2(int[] nums, int val) {
        /*left始终表示符合条件的元素的个数*/
        int left = 0;
        int right = nums.length-1;
        while (left <= right) {
            /*相等时 交换右边界到左边界 有边界-- 左边界不动 只有当左边界不是目标是才移动*/
            if (nums[left] == val) {
                nums[left] = nums[right];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }


    public static int removeElement(int[] nums, int val) {

        int r = nums.length - 1, i;
        for (i = 0; i <= r; i++) {
            if (nums[i] == val) {
                /*找到右侧第一个不相等的数*/
                while (nums[r] == val && r > 0) {
                    r--;
                }
                /*交换两者，右边界-1*/
                if (r > i) {
                    nums[i] = nums[r--];
                } else {
                    return i;
                }
            }
        }
        return i;
    }
}
