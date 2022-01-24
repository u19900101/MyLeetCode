package leetcode.dynic;

/**
 * @author pppppp
 * @date 2022/1/24 22:07
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * 示例 1:
 * <p>
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 * <p>
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 */

public class _343_整数拆分 {
    public static void main(String[] args) {
        int[] nums = {2, 10, 5, 6};
        int[] res = {1, 36, 6, 9};
        for (int i = 0; i < nums.length; i++) {
            System.out.println(integerBreak(nums[i]) == res[i]);
        }

    }

    /*数学推导 分解为2和3*/
    public static int integerBreak(int n) {
        if (n < 4) {
            return n - 1;
        }
        if (n % 3 == 0) {
            return (int) Math.pow(3, n / 3);
        } else if (n % 3 == 1) {
            return (int) Math.pow(3, n / 3 - 1) * 4;
        } else {
            return (int) Math.pow(3, n / 3) * 2;
        }
    }
}
