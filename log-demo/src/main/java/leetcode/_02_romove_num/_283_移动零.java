package leetcode._02_romove_num;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author pppppp
 * @date 2022/1/16 9:20
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class _283_移动零 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        // int[] nums = {0, 1};
        // int[] res = {1, 0};
        int[] res = {1, 3, 12, 0, 0};
        moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            if (res[i] != nums[i]) {
                System.out.println("failed...");
                return;
            }
        }
    }

    public static void moveZeroes(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int l = 0,r = 0;
        while (r<= nums.length-1){
            /*找到第一个不为零的数*/
            if (nums[r] != 0){
                if(r != l){
                    nums[l] = nums[l] ^  nums[r];
                    nums[r] = nums[l] ^  nums[r];
                    nums[l] = nums[l] ^  nums[r];
                }
                l++;
            }
            r++;
        }
    }
    /*此效率更高*/
    public static void moveZeroes2(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int l = 0,r = 0;
        while (r<= nums.length-1){
            /*找到第一个不为零的数*/
            if (nums[r] != 0){
                nums[l] = nums[r];
                l++;
            }
            r++;
        }
        /*将超过长度的数字置0*/
        if(l<=nums.length-1){
            for (int i = l; i < nums.length; i++) {
                nums[i] = 0;
            }
        }
        // System.out.println(Arrays.toString(nums));
    }
}
