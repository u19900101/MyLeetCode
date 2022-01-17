package leetcode._01_数组._03_sortedSquares;

import java.util.Arrays;

/**
 * @author pppppp
 * @date 2022/1/16 16:48
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * 示例 1：
 *
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 *
 * 示例 2：
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]

 */
public class _977_有序数组的平方 {
    public static void main(String[] args){
      int [][]nums = {{-4,-1,0,3,10},{-7,-3,2,3,11}};
      int [][]res = {{0,1,9,16,100},{4,9,9,49,121}};
        for (int i = 0; i < nums.length; i++) {
            int[] squares = sortedSquares2(nums[i]);
            for (int j = 0; j < squares.length; j++) {
                if(squares[j] != res[i][j]){
                    System.out.println("failed...");
                    break;
                }
            }
        }
    }
    public static int[] sortedSquares(int[] nums) {
        int[] list = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            list[i] = nums[i]*nums[i];
        }
        Arrays.sort(list);
        return list;
    }

    /*双指针*/
    public static int[] sortedSquares2(int[] nums) {
        int[] list = new int[nums.length];
        int l=0,r = nums.length-1,index = nums.length -1;
        while (l<=r){
            if(Math.abs(nums[l]) > Math.abs(nums[r])){
                list[index--] = nums[l]*nums[l];
                l++;
            }else {
                list[index--] = nums[r]*nums[r];
                r--;
            }
        }
        return list;
    }
}
