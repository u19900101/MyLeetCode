package leetcode.od;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author pppppp
 * @date 2022/3/1 15:55
 * 描述
 * 数据表记录包含表索引和数值（int范围的正整数），请对表索引相同的记录进行合并，
 * 即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
 *
 * 提示:
 * 0 <= index <= 11111111
 * 1 <= value <= 100000
 *
 * 输入描述：
 * 先输入键值对的个数n（1 <= n <= 500）
 * 然后输入成对的index和value值，以空格隔开
 *
 * 输出描述：
 * 输出合并后的键值对（多行）
 *
 * 示例1
 * 输入：
 * 4
 * 0 1
 * 0 2
 * 1 2
 * 3 4

 * 输出：
 * 0 3
 * 1 2
 * 3 4

 * 示例2
 * 输入：
 * 3
 * 0 1
 * 0 2
 * 8 9

 * 输出：
 * 0 3
 * 8 9
 */
public class _HJ8_合并表记录 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int len = Integer.valueOf(scanner.nextLine());
            while (len > 0){
                String[] split = scanner.nextLine().split(" ");
                Integer k = Integer.valueOf(split[0]);
                Integer v = Integer.valueOf(split[1]);
                map.put(k,map.getOrDefault(k,0) + v);
                len--;
            }
            for (Integer k : map.keySet()) {
                System.out.println(k + " " + map.get(k));
            }
        }
    }
}
