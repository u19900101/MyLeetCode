package leetcode.od;

import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @author pppppp
 * @date 2022/1/21 8:06
 */
public class _HJ13_句子逆序 {
    public static void main(String[] args) {
        // String s = "I am a boy";
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(" ");
        StringJoiner stringJoiner = new StringJoiner(" ");
        for (int i = split.length-1; i >=0; i--) {
            stringJoiner.add(split[i]);
        }
        System.out.println(stringJoiner.toString());
    }
}
