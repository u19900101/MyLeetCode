package leetcode._03_哈希表;

import java.util.HashSet;

/**
 * @author pppppp
 * @date 2022/1/22 23:30
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * <p>
 * 「快乐数」定义为：
 * <p>
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果 可以变为  1，那么这个数就是快乐数。
 * 如果 n 是快乐数就返回 true ；不是，则返回 false 。
 * <p>
 * 示例 1：
 * 输入：n = 19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * 示例 2：
 * <p>
 * 输入：n = 2 -> 4 -> 16 -> 37 -> 58 -> 89
 * 输出：false
 */
public class _202_快乐数 {
    public static void main(String[] args) {
        int[] nums = {19, 2};
        boolean[] res = {true, false};
        for (int i = 0; i < nums.length; i++) {
            System.out.println(isHappy3(nums[i]) == res[i]);
        }
    }

    /*改进--使用快慢指针 判断是否产生了环*/
    public static boolean isHappy3(int n) {
        int slow = n;
        int fast = getNextNum(slow);
        while (slow != fast && fast != 1) {
            slow = getNextNum(slow);;
            fast = getNextNum(getNextNum(fast));
        }
        return fast == 1;
    }

    private static int getNextNum(int n) {
        int sum = 0;
        while (n > 0) {
            int lastNum = n % 10;
            n = n / 10;
            sum += lastNum * lastNum;
        }
        return sum;
    }

    /*改进数字的取位操作 -- while + 取余*/
    public static boolean isHappy2(int n) {
        /*用于判断是否产生了循环*/
        HashSet<Integer> set = new HashSet<>();
        while (true) {
            int sum = 0;
            while (n > 0) {
                int lastNum = n % 10;
                n = n / 10;
                sum += lastNum * lastNum;
            }

            if (sum == 1) {
                return true;
            }
            boolean add = set.add(sum);
            if (!add) {
                return false;
            }
            n = sum;
        }
    }

    public static boolean isHappy(int n) {
        String s = String.valueOf(n);
        int sum = 0;
        /*用于判断是否产生了循环*/
        HashSet<Integer> set = new HashSet<>();
        while (true) {
            for (int i = 0; i < s.length(); i++) {
                Integer temp = Integer.valueOf(s.substring(i, i + 1));
                sum += temp * temp;
            }
            if (sum == 1) {
                return true;
            }
            boolean add = set.add(sum);
            if (!add) {
                return false;
            }
            s = sum + "";
            sum = 0;
        }
    }
}
