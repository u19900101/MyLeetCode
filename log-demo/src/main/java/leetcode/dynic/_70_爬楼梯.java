package leetcode.dynic;

/**
 * @author pppppp
 * @date 2022/1/24 16:48
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * 示例 2：
 * <p>
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 */
public class _70_爬楼梯 {
    public static void main(String[] args) {
        int[] nums = {2, 3,4};
        int[] res = {2, 3,5};
        for (int i = 2; i < nums.length; i++) {
            System.out.println(climbStairs(nums[i]) == res[i]);
        }
    }


    public static int climbStairs(int n) {
        if (n < 4) {
            return n;
        }
        int r = 0,f1 = 1,f2=2;
        while (n-- > 2){
            r = f1 + f2;
            f1 = f2;
            f2 = r;
        }
        return r;
    }
}
