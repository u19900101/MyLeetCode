package leetcode.od;

import org.junit.Test;

import java.util.*;

/**
 * @author pppppp
 * @date 2022/1/21 8:17
 */
public class _HJ14字符串排序 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int len = Integer.valueOf(scanner.nextLine());
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            String s = scanner.nextLine();
            list.add(s);
        }

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        for (String s : list) {
            System.out.println(s);
        }
    }

   public static void main2(String[] args){
       Scanner scanner = new Scanner(System.in);
       int len = Integer.valueOf(scanner.nextLine());
       PriorityQueue<String> queue = new PriorityQueue<>();
       for (int i = 0; i < len; i++) {
           String s = scanner.nextLine();
           queue.add(s);
       }
       while (!queue.isEmpty()){
           System.out.println(queue.poll());
       }
   }
}
