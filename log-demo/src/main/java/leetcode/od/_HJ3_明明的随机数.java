package leetcode.od;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * @author pppppp
 * @date 2022/2/18 11:21
 */
public class _HJ3_明明的随机数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int next = Integer.valueOf(scanner.next());
            int[] res = new int[next];
            for (int i = 0; i < next; i++) {
                res[i] = Integer.valueOf(scanner.next());
            }
            // int[] res = getRandomNums(Integer.valueOf(next));
            Arrays.sort(res);
            HashSet<Integer> map1 = new HashSet<>();
            for (int i : res) {
                map1.add(i);
            }
            int[] ints = map1.stream().mapToInt(Integer::intValue).toArray();
            Arrays.sort(ints);
            for (int anInt : ints) {
                System.out.println(anInt);
            }
        }

    }


    private static int[] getRandomNums(int len) {
        int[] res = new int[len];
        for (int j = 0; j < len; j++) {
            int v = (int) (Math.random() * 1000) + 1;
            res[j] = v;
        }
        return res;
    }
}
