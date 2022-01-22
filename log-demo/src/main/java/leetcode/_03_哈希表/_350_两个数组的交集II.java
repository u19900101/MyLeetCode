package leetcode._03_哈希表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author pppppp
 * @date 2022/1/22 22:54
 * 包含重复的
 */
public class _350_两个数组的交集II {
    public static void main(String[] args) {
        int[][][] nums = {{{1, 2, 3, 1}, {2, 2}}, {{4, 9, 5}, {9, 4, 9, 8, 4}},{{1,2,2,1},{2}}};
        int[][] nums2 = {{2}, {9, 4},{2}};
        for (int i = 0; i < nums.length; i++) {
            int[] intersection = intersect(nums[i][0], nums[i][1]);
            Arrays.sort(intersection);
            Arrays.sort(nums2[i]);
            System.out.println(Arrays.equals(intersection, nums2[i]));
        }

    }


    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int l1 = 0, l2 = 0;
        ArrayList<Integer> res = new ArrayList<>();
        while (l1 < nums1.length && l2 < nums2.length) {
            if (nums1[l1] > nums2[l2]) {
                l2++;
            } else if (nums1[l1] < nums2[l2]) {
                l1++;
            } else {
                res.add(nums1[l1]);
                l1++;
                l2++;
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}
