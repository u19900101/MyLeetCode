package leetcode.dynic;

/**
 * @author pppppp
 * @date 2022/1/24 20:45
 */
public class _62_不同路径 {
    public static void main(String[] args) {
        int[][] nums = {{4, 4}, {3, 7}, {3, 2}, {7, 3}, {3, 3}};
        int[] res = {28, 3, 28, 6};
        for (int i = 0; i < nums.length; i++) {
            System.out.println(uniquePaths2(nums[i][0], nums[i][1]) == res[i]);
        }

    }

    public static int uniquePaths(int m, int n) {
        int[] cost = new int[n];
        cost[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cost[j] = cost[j - 1] + cost[j];
            }
        }
        return cost[n - 1];
    }

    /*直接使用排列组合*/
    /*Cm+n-2,m-1 = (m+n-2)...*n/(m*...1)  */
    public static int uniquePaths2(int m, int n) {
        long r = 1;
        for (int i = n, j = 1; j < m; j++, i++) {
            r = r * i / j; //先乘可以保证整除
        }
        return (int) r;
    }
}
