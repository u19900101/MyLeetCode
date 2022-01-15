package zuo.leetcode;

/**
 * @author pppppp
 * @date 2022/1/15 16:34
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 
 * 进阶：不要 使用任何内置的库函数，如  sqrt 。
 
 * 示例 1：
 * 输入：num = 16
 * 输出：true
 
 * 示例 2：
 * 输入：num = 14
 * 输出：false
 */
public class _367_有效的完全平方数 {
    public static void main(String[] args) {
        int[] nums = {16, 14,5,1};
        boolean[] res = {true, false,false,true};
        for (int i = 3; i < nums.length; i++) {
            System.out.println(isPerfectSquare(nums[i])== res[i]);
        }
    }

    public static boolean isPerfectSquare(int num) {
        if(num == 0 || num == 1){
            return true;
        }
        int x = num;
        while (true){
            int x1 = (x + num/x)>>1;
            if(x1 == x){
                x1--;
                if(x1 == 0){
                    return false;
                }
            }
            if(num  == (long) x1 * x1){
                return true;
            }else if(num/x1 > x1){
                return false;
            }
            x = x1;
        }
    }
}
