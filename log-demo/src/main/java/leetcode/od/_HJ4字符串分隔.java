package leetcode.od;

import org.junit.Test;

import java.util.Scanner;

/**
 * @author pppppp
 * @date 2022/3/1 9:07
 * <p>
 * •连续输入字符串，请按长度为8拆分每个输入字符串并进行输出；
 * <p>
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * （注：本题有多组输入）
 * 输入描述：
 * 连续输入字符串(输入多次,每个字符串长度小于等于100)
 * <p>
 * 输出描述：
 * 依次输出所有分割后的长度为8的新字符串
 * <p>
 * 示例1
 * 输入：
 * abc
 * 123456789
 * 复制
 * 输出：
 * abc00000
 * 12345678
 * 90000000
 */
public class _HJ4字符串分隔 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String next = scanner.next();
            for (int i = 0; i < next.length(); i += 8) {
                if (i + 8 > next.length()) {
                    int i1 = i + 8 - next.length();
                    StringBuilder stringBuilder = new StringBuilder(next.substring(i));
                    while (i1-- > 0) {
                        stringBuilder.append("0");
                    }
                    System.out.println(stringBuilder);
                } else {
                    System.out.println(next.substring(i, i + 8));
                }

            }
        }
    }
}
