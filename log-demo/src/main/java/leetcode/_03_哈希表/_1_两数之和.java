package leetcode._03_哈希表;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author pppppp
 * @date 2022/1/23 15:25.
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，
 * 并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 * 示例 2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 *
 * 示例 3：
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 */
public class _1_两数之和 {
    public static void main(String[] args){
        int [][] nums = {{2,7,11,15},{3,2,4},{3,3}};
        int [] tag = {9,6,6};
        int [][] res = {{0,1},{1,2},{0,1}};
        for (int i = 0; i < nums.length; i++) {
            int[] ints = twoSum(nums[i], tag[i]);
            Arrays.sort(ints);
            Arrays.sort(res[i]);
            System.out.println(Arrays.equals(ints,res[i]));
        }
    }

    //优化之后的hash，放入数据时就直接进行判断
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int []res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if(map.get(target -nums[i]) != null){
                res[0] = i;
                res[1] = map.get(target - nums[i]);
                break;
            }else {
                map.put(nums[i],i);
            }
        }
        return res;
    }
}
