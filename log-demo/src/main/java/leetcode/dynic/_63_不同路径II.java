package leetcode.dynic;

/**
 * @author pppppp
 * @date 2022/1/22 16:04
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * ：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：2
 * <p>
 * obstacleGrid = [[0,1],[0,0]]
 * 输出：1
 */
public class _63_不同路径II {
    public static void main(String[] args) {
        int[][][] nums = {{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}, {{0, 1}, {0, 0}}};
        int[] res = {2, 1};

        for (int i = 0; i < nums.length; i++) {
            System.out.println(uniquePathsWithObstacles(nums[i]));
        }
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] != 0) {
            return 0;
        }
        int rCount = obstacleGrid.length;
        int cCount = obstacleGrid[0].length;
        int[][] res = new int[rCount][cCount];

        for (int i = 0; i < rCount; i++) {
            for (int j = 0; j < cCount; j++) {
                if(i == 0 && j ==0){
                    res[0][0] = 1;
                    continue;
                }
                if (obstacleGrid[i][j] == 1) {
                    res[i][j] = 0;
                    continue;
                }
                int uV = i > 0 ? res[i - 1][j] : 0;
                int lV = j > 0 ? res[i][j - 1] : 0;
                res[i][j] = uV + lV;
            }
        }
        return res[rCount - 1][cCount - 1];
    }

    /*官方题解 滚动数组*/
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[] f = new int[m];

        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    f[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                    f[j] += f[j - 1];
                }
            }
        }

        return f[m - 1];
    }
}
