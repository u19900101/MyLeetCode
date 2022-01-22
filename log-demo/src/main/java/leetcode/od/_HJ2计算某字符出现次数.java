package leetcode.od;

import org.junit.Test;

import java.util.Scanner;

/**
 * @author pppppp
 * @date 2022/1/22 8:31
 * ABCabc
 * A
 * 2
 */
public class _HJ2计算某字符出现次数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine().toLowerCase();
            char t = scanner.nextLine().toLowerCase().charAt(0);
            int res = 0;
            for (char c : s.toCharArray()) {
                if(c == t){
                    res++;
                }
            }
            System.out.println(res);
        }
    }

    @Test
    public void T_m(){
        System.out.println(T_2());
    }

    public int T_2() {
        String s = "absccbd";
        String t = "c";
        // return s.length() - s.replace(t,"").length();
        return s.length() - s.toLowerCase().replaceAll(t.toLowerCase(),"").length();
    }
    public int T_() {
        String s = "absccbd";
        String t = "c";
        int res = 0;
        for (char c : s.toLowerCase().toCharArray()) {
            if(c == t.toLowerCase().charAt(0)){
                res++;
            }
        }
        return res;
    }
}
