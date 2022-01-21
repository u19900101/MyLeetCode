package leetcode.od;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author pppppp
 * @date 2022/1/21 8:58
 * 密码要求:
 * <p>
 * 1.长度超过8位
 * 2.包括大小写字母.数字.其它符号,以上四种至少三种
 * 3.不能有长度大于2的不含公共元素的子串重复 （注：其他符号不含空格或换行）
 * 021Abc9000
 * 021Abc9Abc1
 * 021ABC9000
 * 021$bc9000
 * <p>
 * OK
 * NG
 * NG
 * OK
 */
public class _HJ20_密码验证合格程序 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.nextLine();
            int length = s.length();
            if (length <= 8) {
                System.out.println("NG");
                continue;
            }
            String[] regs = {"[A-Z]+", "[a-z]+", "[0-9]+", "\\W+"};
            int count = 0;
            for (int i = 0; i < regs.length; i++) {
                if (Pattern.compile(regs[i]).matcher(s).find()) {
                    count++;
                }
            }
            if (count < 3) {
                System.out.println("NG");
                continue;
            }
            /*长度大于2的不含公共元素的子串*/
            /*只用判断长度等于3的字串即可 因为若存在长度大于4的重复字串，那一定存在长度等于3的字串*/
            /*优化 左右分治*/
            if (getString(s, 0, 3)) {
                System.out.println("NG");
                continue;
            }
            System.out.println("OK");
        }
    }
    public static void main2(String[] args) {
        // Scanner scanner = new Scanner(System.in);
        // ArrayList<String> list = new ArrayList<>();
      /*  while (scanner.hasNext()){
            String s = scanner.nextLine();
            list.add(s);
        }*/
        //  while (true){
        //     String s = scanner.nextLine();
        //     if(s.equals("")){
        //         break;
        //     }
        //     list.add(s);
        // }
        ArrayList<String> list = new ArrayList<>();
        list.add("021Abc9000");
        list.add("021Abc9Abc1");
        list.add("021ABC9000");
        list.add("021$bc9000");

        for (String s : list) {
            int length = s.length();
            if (length <= 8) {
                System.out.println("NG");
                continue;
            }
            String[] regs = {"[A-Z]+", "[a-z]+", "[0-9]+", "\\W+"};
            int count = 0;
            for (int i = 0; i < regs.length; i++) {
                if (Pattern.compile(regs[i]).matcher(s).find()) {
                    count++;
                }
            }
            if (count < 3) {
                System.out.println("NG");
                continue;
            }
            /*长度大于2的不含公共元素的子串*/
            boolean flag = true;

            /*只用判断长度等于3的字串即可 因为若存在长度大于4的重复字串，那一定存在长度等于3的字串*/
            /*优化 左右分治*/
            if (getString(s, 0, 3)) {
                System.out.println("NG");
                continue;
            }
           /*
                int sIndex = 0, l = 3;
                while (sIndex <= s.length() - l * 2) {
                String subS = s.substring(sIndex, sIndex + l);
                if (s.lastIndexOf(subS) != sIndex) {
                    System.out.println("NG");
                    flag = false;
                    break;
                }
                sIndex++;
                 if (flag) {
            }
            }*/
            System.out.println("Ok");
        }
    }

    private static boolean getString(String str, int l, int r) {
        if (r == str.length()) {
            return false;
        }
        if (str.substring(r).contains(str.substring(l, r))) {
            return true;
        } else {
            return getString(str, l + 1, r + 1);
        }
    }
}
