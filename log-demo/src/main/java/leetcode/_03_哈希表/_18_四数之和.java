package leetcode._03_哈希表;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author pppppp
 * @date 2022/1/23 19:43
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 * <p>
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 * <p>
 * 示例 1：
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 */
public class _18_四数之和 {
    public static void main(String[] args) {
        int[][] nums = {{1, 0, -1, 0, -2, 2}, {2, 2, 2, 2, 2}};
        int[] tag = {0, 8};
        int[][][] res = {{{-2, -1, 1, 2}, {-2, 0, 0, 2}, {-1, 0, 0, 1}}, {{2, 2, 2, 2}}};
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> ints = fourSum(nums[i], tag[i]);
            System.out.println();
        }
    }



    public static List<List<Integer>> fourSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                List<Integer> temp = Arrays.stream(nums).boxed().collect(Collectors.toList());
                temp.remove(i);
                List<List<Integer>> temp3 = threeSum(target-nums[i], temp.stream().mapToInt(j->j).toArray());
                for (List<Integer> t3 : temp3) {
                    t3.add(nums[i]);
                }
                res.addAll(temp3);
            }else {
                map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
            }
        }
        return res;
    }

    private static List<List<Integer>> threeSum(int target, int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                List<Integer> temp = Arrays.stream(nums).boxed().collect(Collectors.toList());
                temp.remove(i);
                List<List<Integer>> temp3 = twoSum(target-nums[i], temp.stream().mapToInt(j->j).toArray());
                for (List<Integer> t3 : temp3) {
                    t3.add(nums[i]);
                }
                res.addAll(temp3);
            }else {
                map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
            }
        }
        return res;
    }


    private static List<List<Integer>> twoSum(int target, int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                List<List<Integer>> temp3 = new ArrayList<>();
                for (List<Integer> t3 : temp3) {
                    t3.add(nums[i]);
                }
                res.addAll(temp3);
            }else {
                map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
            }
        }
        return res;
    }


    //优化之后的hash，放入数据时就直接进行判断
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.get(target - nums[i]) != null) {
                res[0] = i;
                res[1] = map.get(target - nums[i]);
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return res;
    }
}
