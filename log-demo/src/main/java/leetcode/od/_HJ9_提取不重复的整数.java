package leetcode.od;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author pppppp
 * @date 2022/3/1 16:16
 * 描述
 * 输入一个 int 型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * 保证输入的整数最后一位不是 0 。

 * 输入描述：
 * 输入一个int型整数
 *
 * 输出描述：
 * 按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
 *
 * 示例1
 * 输入：
 * 9876673

 * 输出：
 * 37689
 */
public class _HJ9_提取不重复的整数 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s= scanner.next();
            StringBuilder sb = new StringBuilder();
            HashSet<Character> set = new HashSet<>();
            for (int i = s.length()-1; i >=0 ; i--) {
                char c = s.charAt(i);
                if(!set.contains(c)){
                    sb.append(c);
                    set.add(c);
                }
            }
            System.out.println(sb);
        }
    }
}
