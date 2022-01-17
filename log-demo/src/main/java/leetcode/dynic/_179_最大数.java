package leetcode.dynic;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author pppppp
 * @date 2022/1/17 8:42
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * <p>
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * 示例 1：
 * 输入：nums = [10,2]
 * 输出："210"
 * <p>
 * <p>
 * 示例 2：
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 * <p>
 * <p>
 * 示例 3：
 * 输入：nums = [1]
 * 输出："1"
 * <p>
 * 示例 4：
 * 输入：nums = [10]
 * 输出："10"
 */
public class _179_最大数 {
    public static void main(String[] args) {
        int[][] nums = {{10, 2}, {3, 30, 34, 5, 9}, {1}, {10}, {111311, 1113}
                , {999999991, 9}, {0, 0}, {0, 0, 1}, {33, 32, 3}};
        String[] res = {"210", "9534330", "1", "10", "1113111311", "9999999991", "0", "100", "33332"};
        for (int i = 0; i < nums.length; i++) {
            String s = largestNumber4(nums[i]);
            System.out.println(s.equals(res[i]));
        }
    }

    /*官方题解*/
    public static String largestNumber3(int[] nums) {
        int n = nums.length;
        // 转换成包装类型，以便传入 Comparator 对象（此处为 lambda 表达式）
        Integer[] numsArr = new Integer[n];
        for (int i = 0; i < n; i++) {
            numsArr[i] = nums[i];
        }

        /*定义比较规则 将两个数 xy 和 yx 进行比较*/
        Arrays.sort(numsArr, (x, y) -> {
            long sx = 10, sy = 10;
            while (sx <= x) {
                sx *= 10;
            }
            while (sy <= y) {
                sy *= 10;
            }
            return (int) (-sy * x - y + sx * y + x);
        });

        if (numsArr[0] == 0) {
            return "0";
        }
        StringBuilder ret = new StringBuilder();
        for (int num : numsArr) {
            ret.append(num);
        }
        return ret.toString();
    }


    public static String largestNumber4(int[] nums) {

        Integer[] numsArr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsArr[i] = nums[i];
        }
        Arrays.sort(numsArr, (x, y) -> {
            if (x.equals(y)) {
                return 0;
            }
            /*逐位比较两个数字*/
            String comb1 = String.valueOf(x) + String.valueOf(y);
            String comb2 = String.valueOf(y) + String.valueOf(x);
            /*max 有可能 =0 33 和 3*/
            if (comb1.equals(comb2)) {
                return x > y ? -1 : 1;
            }
            /*执行到此处是肯定是两者不等*/
            for (int i = 0; i < comb1.length(); i++) {
                if (comb1.charAt(i) == comb2.charAt(i)) {
                    continue;
                }
                if (comb1.charAt(i) > comb2.charAt(i)) {
                    return -1;
                } else {
                    return 1;
                }
            }
            //程序不会抵达此处
            return 0;
        });
        StringBuilder s = new StringBuilder();
        for (Integer integer : numsArr) {
            s.append(integer);
        }
        if (s.substring(0, 1).equals("0")) {
            return "0";
        }
        return String.valueOf(s);
    }

    /*使用带优先级的队列实现*/
    public static String largestNumber2(int[] nums) {
        PriorityQueue<String> heap = new PriorityQueue<>((x, y) -> (y + x).compareTo(x + y));
        for (int x : nums) {
            heap.offer(String.valueOf(x));
        }
        String res = "";
        while (heap.size() > 0) {
            res += heap.poll();
        }
        if (res.charAt(0) == '0') {
            return "0";
        }
        return res;
    }

    public static String largestNumber(int[] nums) {

        StringBuilder s = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            //    依次找到数组中最大的数
            int max = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                //    定义新的排序规则
                max = getMax2(max, nums, j);
            }
            s.append(max);
        }
        if (s.substring(0, 1).equals("0")) {
            return "0";
        }
        return String.valueOf(s);
    }

    @Test
    public void T_() {
        String s = "1bs2";
        int i = s.compareTo("1b");
        System.out.println(i);
    }

    private static int getMax2(int num1, int[] nums, int j) {
        if (num1 == nums[j]) {
            return num1;
        }
        /*逐位比较两个数字*/
        String comb1 = String.valueOf(num1) + String.valueOf(nums[j]);
        String comb2 = String.valueOf(nums[j]) + String.valueOf(num1);
        int max = 0;
        for (int i = 0; i < comb1.length() && i < comb2.length(); i++) {
            if (comb1.charAt(i) == comb2.charAt(i)) {
                continue;
            }
            if (comb1.charAt(i) > comb2.charAt(i)) {
                max = num1;
            } else {
                max = nums[j];
                nums[j] = num1;
            }
            break;
        }
        /*max 有可能 =0 33 和 3*/
        if (max == 0) {
            if (num1 < nums[j]) {
                max = nums[j];
                nums[j] = num1;
            } else {
                max = num1;
            }
        }

        return max;
    }

    private static int getMax(int num1, int[] nums, int j) {
        /*逐位比较两个数字*/
        String n1 = String.valueOf(num1);
        String n2 = String.valueOf(nums[j]);
        if (n1.length() == n2.length()) {
            int max = num1 > nums[j] ? num1 : nums[j];
            nums[j] = num1 < nums[j] ? num1 : nums[j];
            return max;
        }
        if (n1.length() > n2.length()) {
            n1 = String.valueOf(nums[j]);
            n2 = String.valueOf(num1);
        }

        for (int i = 0; i < n1.length(); i++) {
            if (n1.charAt(i) == n2.charAt(i)) {
                continue;
            }
            if (n1.charAt(i) > n2.charAt(i)) {
                nums[j] = Integer.valueOf(n2);
                return Integer.valueOf(n1);
            } else {
                nums[j] = Integer.valueOf(n1);
                return Integer.valueOf(n2);
            }
        }
        int max;
        if (n2.charAt(n1.length()) == '0') {
            max = Integer.valueOf(n1);
            nums[j] = Integer.valueOf(n2);
        } else {
            max = Integer.valueOf(n2);
            nums[j] = Integer.valueOf(n1);
        }
        return max;
    }
}
