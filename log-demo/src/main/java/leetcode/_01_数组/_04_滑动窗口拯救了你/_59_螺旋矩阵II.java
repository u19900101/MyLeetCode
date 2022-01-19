package leetcode._01_数组._04_滑动窗口拯救了你;

/**
 * @author pppppp
 * @date 2022/1/19 20:24
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * <p>
 * 输入：n = 1
 * 输出：[[1]]
 * <p>
 * 输入：n = 2
 * 输出：[[1,2],[4,3]
 */
public class _59_螺旋矩阵II {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int[][][] res = {{{1}}, {{1, 2}, {4, 3}}, {{1, 2, 3}, {8, 9, 4}, {7, 6, 5}}};
        for (int i = 1; i < nums.length; i++) {
            int[][] ints = generateMatrix2(nums[i]);
            for (int j = 0; j < ints.length; j++) {
                for (int k = 0; k < ints[0].length; k++) {
                    System.out.println(ints[j][k] == res[i][j][k]);
                }
            }
            System.out.println();
        }
    }

    /*优化-- 逐渐缩减边界值*/
    public static int[][] generateMatrix2(int n) {
        int val = 1, l = 0, r = n - 1, t = 0, b = n-1;
        int[][] res = new int[n][n];
        while (val <= n * n) {
            /*→*/
            for (int i = l; i <= r; i++) {
                res[t][i] = val++;
            }
            t++;/*上边界 下移*/

            /*↓*/
            for (int i = t; i <= b; i++) {
                res[i][r] = val++;
            }
            r--; /*右边界 左移*/

            /*←*/
            for (int i = r; i >= l; i--) {
                res[b][i] = val++;
            }
            b--; /*下边界上移*/

            /*↑*/
            for (int i = b; i >= t; i--) {
                res[i][l] = val++;
            }
            l++;  /*左边界右移*/
        }
        return res;
    }

    public static int[][] generateMatrix(int n) {
        int val = 1, row = 0, col = 0;
        int[][] res = new int[n][n];
        while (val <= n * n) {
            /*→*/
            while (col < n && res[row][col] == 0) {
                res[row][col++] = val++;
            }
            row++;
            col--;
            /*↓*/
            while (row < n && res[row][col] == 0) {
                res[row++][col] = val++;
            }
            row--;
            col--;
            /*←*/
            while (col >= 0 && res[row][col] == 0) {
                res[row][col--] = val++;
            }
            row--;
            col++;
            /*↑*/
            while (row >= 0 && res[row][col] == 0) {
                res[row--][col] = val++;
            }
            row++;
            col++;
        }

        return res;
    }
}
