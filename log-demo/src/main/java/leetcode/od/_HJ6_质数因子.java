package leetcode.od;

import org.junit.Test;

import java.util.Scanner;

/**
 * @author pppppp
 * @date 2022/3/1 10:01
 * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
 * <p>
 * 输入描述：
 * 输入一个整数
 * <p>
 * 输出描述：
 * 按照从小到大的顺序输出它的所有质数的因子，以空格隔开。最后一个数后面也要有空格。
 * <p>
 * 示例1
 * 输入：
 * 180
 * 复制
 * 输出：
 * 2 2 3 3 5
 */
public class _HJ6_质数因子 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int next = scanner.nextInt();
            System.out.println(isZhishu(next));
        }
    }

    @Test
    public void T_(){

    }
    public  static String isZhishu(int num) {
        StringBuilder sb = new StringBuilder();
        int t = 2;
        while (t <= Math.sqrt(num)) {
            if (num % t == 0) {
                num = num / t;
                sb.append(t + " ");
                continue;
            }
            t++;
        }
        if(num != 1){
            sb.append(num);
        }
        return  sb.toString();
    }
}
