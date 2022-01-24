package leetcode.dynic;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author pppppp
 * @date 2022/1/24 15:28
 * //1 2 3 4 5 6 7 8 9 10
 * // 6 7 8 9 10
 */
public class _10个数分两组 {
    public static void main(String[] args) {
        //2.调用处理数组的函数
       /* Scanner sc = new Scanner(System.in);
        int[] arr = new int[11];
        for (int i = 0; i < 11; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(result(arr));*/
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(result(arr));
    }

    public static int result(int[] arr) {
        int a[] = new int[arr.length / 2], b[] = new int[arr.length / 2];
        for (int i = 0; i < arr.length / 2; i++) {
            a[i] = arr[i];
            b[i] = arr[i + arr.length / 2];
        }
        System.out.println("交换处理后的数组a：" + Arrays.toString(a));
        System.out.println("交换处理后的数组b：" + Arrays.toString(b));
        getMinusArray(a, b);
        System.out.println("交换处理后的数组a：" + Arrays.toString(a));
        System.out.println("交换处理后的数组b：" + Arrays.toString(b));
        return Math.abs(getSum(a) - getSum(b));
    }


    //两数组进行元素交换实现最小差值
    public static void getMinusArray(int[] a, int[] b) {
        // 数组a和b的和
        int suma = getSum(a);
        int sumb = getSum(b);

        int startMinus = Math.abs(suma - sumb);
//      System.out.println("startMinus="+startMinus);
        int minus = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                //先交换
                int temp = a[i];
                a[i] = b[j];
                b[j] = temp;
                //交换后的差值
                minus = Math.abs(getSum(a) - getSum(b));
                if (minus < startMinus) {
                    startMinus = minus;
                } else {
                    //若交换后，差值比原来大或相等，则不交换--即重新换回来
                    int temp2 = a[i];
                    a[i] = b[j];
                    b[j] = temp2;
                }
            }
        }
        // minus = Math.abs(getSum(a) - getSum(b));
        System.out.println(startMinus);
    }

    // 求数组和
    public static int getSum(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }


    @Test
    public void T_(){
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int sum = 0;
        for (int i = 0; i < arr.length; i ++) {
            sum += arr[i];
        }
        // dp[j]表示在容量为j的情况下可存放的重量
        // 如果不放arr[i]重量为dp[j],如果放arr[i]重量为dp[j-arr[i]]+arr[i];
        int[] dp = new int[sum / 2 + 1];
        for (int i = 0; i < arr.length; i ++) {
            for (int j = sum / 2; j >= arr[i]; j --) {
                dp[j] = Math.max(dp[j], dp[j - arr[i]] + arr[i]);
            }
        }
        System.out.println(Math.max(dp[sum / 2], sum - dp[sum / 2]) << 10);
    }

}





