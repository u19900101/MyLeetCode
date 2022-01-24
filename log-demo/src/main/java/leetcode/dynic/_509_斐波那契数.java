package leetcode.dynic;

/**
 * @author pppppp
 * @date 2022/1/24 16:18
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 */
public class _509_斐波那契数 {
    public static void main(String[] args) {
        System.out.println(fib(3) == 2);
    }

    public static int fib(int n) {
        if (n < 2) {
            return n;
        }
        int f0 = 0, f1 = 1, f = 0;
        for (int i = 0; i < n - 1; i++) {
            f = f0 + f1;
            f0 = f1;
            f1 = f;
        }
        return f;
    }
}
