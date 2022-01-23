package leetcode._03_哈希表;

import org.junit.Test;

import java.util.*;

/**
 * @author pppppp
 * @date 2022/1/23 20:43
 * 给你一个包含 n 个整数的数组 nums，
 * 判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * 示例 1：
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 * <p>
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * 输出：[]
 */
public class _15_三数之和 {

    public static void main(String[] args) {
        int[][] nums = {{},{-1, 0, 1, 2, -1, -4}};
        int[][][] res = {{{-1, -1, 2}, {-1, 0, 1}},};
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> ints = threeSum2(nums[i]);
            System.out.println();
        }
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        /*1.排序 判断特殊情况*/
        /*2.固定最左侧的数*/
        /*3.找到所有合适的数*/
        /*4.右移*/
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length <3 || nums[0] > 0 || nums[nums.length - 1] < 0) {
            return res;
        } else if (nums[0] == 0 && nums[nums.length - 1] == 0) {
            res.add(Arrays.asList(0, 0, 0));
            return res;
        }
        /*值 和 是否有两个及以上相同的数*/
        HashMap<Integer, Boolean> map = new HashMap<>();
        HashSet<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.containsKey(nums[i]) ? true : false);
        }

        int l = 0, r = nums.length - 1;
        while (l <= nums.length - 3) {
            /*固定l,在右侧进行查找*/
            int m = l + 1;
            while (m < r) {
                boolean out = false;
                while (m < r-1 && nums[m] == nums[m+1]){
                    if (map.containsKey(-nums[m] - nums[l])){
                        Integer []temp = {nums[l], nums[m], -nums[m] - nums[l]};
                        Arrays.sort(temp);
                        set.add(Arrays.asList(temp));
                        out = true;
                        break;
                    }
                    m++;
                }
                /* -1 -1 2 这种情况*/
                if(out){
                    break;
                }
                int t = -nums[m] - nums[l];
                if (map.containsKey(t)){
                    Integer []temp = {nums[l], nums[m], -nums[m] - nums[l]};
                    Arrays.sort(temp);
                    if((t == nums[m] || t == nums[l]) ){
                        if(map.get(t) == true){
                            set.add(Arrays.asList(temp));
                        }
                    }else {
                        set.add(Arrays.asList(temp));
                    }
                    break;
                }
                m++;
            }
            l++;
        }
        return new ArrayList<>(set);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int[] tem = new int[nums.length - 1];
            /*删除第i个元素*/
            for (int j = 0; j <= i - 1; j++) {
                tem[j] = nums[j];
            }
            for (int j = i + 1; j < nums.length; j++) {
                tem[j - 1] = nums[j];
            }
            List<List<Integer>> t3 = twoSum(tem, -nums[i]);
            res.addAll(t3);
        }
        /*去重*/
        HashSet<List<Integer>> set = new HashSet<>();
        for (List<Integer> list : res) {
            list.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            set.add(list);
        }
        return new ArrayList<>(set);
    }

    public static List<List<Integer>> twoSum(int[] nums, int target) {
        HashSet map = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.contains(target - nums[i])) {
                List<Integer> temp = new ArrayList<>();
                temp.add(target - nums[i]);
                temp.add(nums[i]);
                temp.add(-target);
                res.add(temp);
            } else {
                map.add(nums[i]);
            }
        }
        return res;
    }
}
