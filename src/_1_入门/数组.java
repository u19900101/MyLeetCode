package _1_入门;

import java.util.Arrays;

/**
 * @author pppppp
 * @date 2022/1/8 16:00
 */
public class 数组 {
    public static void main(String[] args){
        int[][] ns = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 }
        };
        System.out.println(Arrays.deepToString(ns));//[[1, zuo.2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12]]
        System.out.println(Arrays.toString(ns)); //[[I@1d81eb93, [I@7291c18f, [I@34a245ab]
    }

}
