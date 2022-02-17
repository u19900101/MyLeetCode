package leetcode.dynic;

import org.junit.Test;

import java.util.Arrays;


/**
 * @author pppppp
 * @date 2022/2/17 10:29
 * 讲解
 * https://www.zhihu.com/question/21923021
 */
public class KMP {

    public static void main(String[] args) {

        System.out.println(search("hellollokkllo", "llo"));
    }

    @Test
    public void T_() {
        // int[] s = getNext("abcabcd");
        // int[] s = getNext("abcabd");
        int[] s = getNext("abcabdddabcabc");
        System.out.println();
    }

    public static int[] getNext(String p) {
        int i = 1, now = 0;
        int[] next = new int[p.length()];
        while (i < p.length()) {
            if (p.charAt(i) == p.charAt(now)) {
                now++;
                next[i] = now;
                i++;
            } else if (now == 0) {
                i++;
            } else {
                /*缩短匹配串的长度*/
                now = next[now - 1];
            }
        }
        return next;
    }

    public static int search(String s, String p) {
        int M = p.length();
        int N = s.length();
        // pat 的初始态为 0
        int j = 0, i = 0;
        int[] next = getNext(p);
        while (i < N && j < M) {
            if (p.charAt(j) == s.charAt(i)) {
                i++;
                j++;
            } else if (j == 0) {
                i++;
            } else {
                j = next[j - 1];
            }

            if (j == M) {
                return i - M;
               /* System.out.println(i-M);
                j = 0;*/
            }
        }
        // 没到达终止态，匹配失败
        return -1;
    }
}
