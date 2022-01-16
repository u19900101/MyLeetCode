package leetcode._01_binary_search;

/**
 * @author pppppp
 * @date 2022/1/15 12:56
 * 69. Sqrt(x)
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * <p>
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * <p>
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 * 示例 1：
 * 输入：x = 4
 * 输出：2
 * <p>
 * 示例 2：
 * 输入：x = 8
 * 输出：2
 * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 */
public class _069_Sqrt_x {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("i is  " + i + " Sqrt(x) is " + mySqrt2(i));
        }
        /*46339*/
        // System.out.println("i is  " + 2147395599 + " Sqrt(x) is " + mySqrt(2147395599));
    }

    public static int mySqrt(int x) {
        int L = 0;
        int R = x;
        int mid = 0;
        while (L <= R) {
            mid = L + ((R - L) >> 1);
            if (x >= (long) mid * mid && x <= (long) (mid + 1) * (mid + 1)) {
                return x == (long) (mid + 1) * (mid + 1) ? mid + 1 : mid;
            } else if (x < (long) mid * mid) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return mid;
    }

    public static int mySqrt2(int x) {
        int L = 0;
        int R = x;
        int mid = 0, ans = -1;
        while (L <= R) {
            mid = L + ((R - L) >> 1);
            if (x >= (long) mid * mid) {
                ans = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return ans;
    }

    /*牛顿迭代*/
    public int mySqrt3(int x) {
        if (x == 0) {
            return 0;
        }

        double C = x, x0 = x;
        while (true) {
            double xi = (x0 + C / x0) / 2;
            if (Math.abs(x0 - xi) < 1e-7) {
                break;
            }
            x0 = xi;
        }
        return (int) x0;
    }

    int s;

    public int mySqrt4(int x) {
        s = x;
        if (x == 0){
            return 0;
        }
        return ((int) (sqrts4(x)));
    }

    public double sqrts4(double x) {
        double res = (x + s / x) / 2;
        if (res == x) {
            return x;
        } else {
            return sqrts4(res);
        }
    }
}
