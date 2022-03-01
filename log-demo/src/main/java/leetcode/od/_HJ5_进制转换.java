package leetcode.od;

import java.util.Scanner;

/**
 * @author pppppp
 * @date 2022/3/1 9:23
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
 *
 * 数据范围：保证结果在 1 <= n <= 2^(31) -1

 * 注意本题有多组输入
 * 输入描述：
 * 输入一个十六进制的数值字符串。注意：一个用例会同时有多组输入数据
 *
 * 输出描述：
 * 输出该数值的十进制字符串。不同组的测试用例用\n隔开。
 *
 * 示例1
 * 输入：
 * 0xA
 * 0xAA
 * 复制
 * 输出：
 * 10
 * 170
 */
public class _HJ5_进制转换 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String next = scanner.next();
            int sum = 0;
           /* for (int i = next.length()-1; i >=2 ; i--) {
                char c = next.charAt(i);
                if (c >= 'A' && c <= 'F') {
                    sum += (c - 65 + 10) << (4*(next.length()-1-i));
                } else if (c >= '0' && c <= '9') {
                    Integer integer = Integer.valueOf(c) -48;
                    sum += integer << (4*(next.length()-1-i));
                } else {
                    System.out.println("inputError");
                    return;
                }
            }*/
            for (int i = 2; i < next.length(); i++) {
                char c = next.charAt(i);
                if (c >= 'A' && c <= 'F') {
                    sum = 16 *sum + (c - 65 + 10);
                } else if (c >= '0' && c <= '9') {
                    sum = 16 *sum + (c - 48);
                } else {
                    System.out.println("inputError");
                    return;
                }

            }
            System.out.println(sum);
        }
    }
}
