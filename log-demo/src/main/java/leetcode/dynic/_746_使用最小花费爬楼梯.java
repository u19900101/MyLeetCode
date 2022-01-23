package leetcode.dynic;

/**
 * @author pppppp
 * @date 2022/1/23 9:32
 * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 * <p>
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 * <p>
 * 请你计算并返回达到楼梯顶部的最低花费。
 * 示例 1：
 * <p>
 * 输入：cost = [10,15,20]
 * 输出：15
 * 解释：你将从下标为 1 的台阶开始。
 * - 支付 15 ，向上爬两个台阶，到达楼梯顶部。
 * 总花费为 15 。
 * 示例 2：
 * <p>
 * 输入：cost = [1,100,1,1,1,100,1,1,100,1]
 * 输出：6
 * 解释：你将从下标为 0 的台阶开始。
 * - 支付 1 ，向上爬两个台阶，到达下标为 2 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 4 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 6 的台阶。
 * - 支付 1 ，向上爬一个台阶，到达下标为 7 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 9 的台阶。
 * - 支付 1 ，向上爬一个台阶，到达楼梯顶部。
 * 总花费为 6 。
 */
public class _746_使用最小花费爬楼梯 {
    public static void main(String[] args) {
        int[][] nums = {{1,2,2,2},{1,2,1,1},{10, 15, 20}, {1, 100, 1, 1, 1, 100, 1, 1, 100, 1}, {0, 0, 1, 1}, {0, 1, 1, 1},{0,0,0,0}};
        int[] res = {3,2,15, 6, 1, 1,0};
        for (int i = 0; i < nums.length; i++) {
            System.out.println(minCostClimbingStairs3(nums[i]) == res[i]);
        }
    }
    /*还是得使用动态规划，常规方法边界条件太复杂*/
    public static int minCostClimbingStairs2(int[] cost) {
        int[] f = new int[cost.length + 1];
        int i = 2;
        while (i < cost.length+1){
            f[i] = Math.min(f[i-1] + cost[i-1],f[i-2] + cost[i-2]);
            i++;
        }
        return f[cost.length];
    }

    /*滚动数组优化*/
    public static int minCostClimbingStairs3(int[] cost) {
        int n =0,n_1 = 0,n_2 = 0;
        int i = 2;
        while (i < cost.length+1){
            n = Math.min(n_1 + cost[i-1],n_2 + cost[i-2]);
            n_2 = n_1;
            n_1 = n;
            i++;
        }
        return n;
    }
    /*错误解法*/
    public static int minCostClimbingStairs(int[] cost) {
        int r = -1, sum = 0;
        /*r 为已经抵达的坐标*/
        while (r + 3 < cost.length) {
            while (r+1 < cost.length && cost[r+1] == 0){
                r++;
            }
            if(r + 3 < cost.length){
                /*向后走3步*/
                if (cost[r + 1] + cost[r + 3] <= cost[r + 2]) {
                    sum += cost[r + 1] + cost[r + 3];
                    r += 3;
                } else {
                    /*向后走2步*/
                    sum += cost[r + 2];
                    r += 2;
                }
            }
        }
        if (r == cost.length - 3) {
            sum += Math.min(cost[cost.length - 1], cost[cost.length - 2]);
        }
        return sum;
    }
}
