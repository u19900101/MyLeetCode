package leetcode._03_哈希表;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author pppppp
 * @date 2022/1/22 21:37
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * <p>
 * 示例 2：
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 */
public class _349_两个数组的交集 {
    public static void main(String[] args) {
        int[][][] nums = {{{1, 2, 2, 1}, {2, 2}}, {{4, 9, 5}, {9, 4, 9, 8, 4}}};
        int[][] nums2 = {{2}, {9, 4}};
        for (int i = 0; i < nums.length; i++) {
            int[] intersection = intersection5(nums[i][0], nums[i][1]);
            Arrays.sort(intersection);
            Arrays.sort(nums2[i]);
            System.out.println(Arrays.equals(intersection, nums2[i]));
        }

    }

    /*优化--双指针法*/
    public static int[] intersection3(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int l1 = 0, l2 = 0;
        HashSet<Integer> hashSet = new HashSet<>();
        while (l1 < nums1.length && l2 < nums2.length) {
            if(nums1[l1] > nums2[l2]){
                l2++;
            }else if(nums1[l1] < nums2[l2]){
                l1++;
            }else {
                hashSet.add(nums1[l1]);
                l1++;
                l2++;
            }
        }
        return hashSet.stream().mapToInt(i -> i).toArray();
    }

    /*优化一下--普通解法*/
    public static int[] intersection2(int[] nums1, int[] nums2) {
        HashSet<Integer> map1 = new HashSet<>();
        HashSet<Integer> map2 = new HashSet<>();
        for (int i : nums1) {
            map1.add(i);
        }
        for (int i : nums2) {
            map2.add(i);
        }
        return getIntersection(map1, map2);
    }

    private static int[] getIntersection(HashSet<Integer> map1, HashSet<Integer> map2) {
        //选取较小的尽心比较
        if (map1.size() > map2.size()) {
            return getIntersection(map2, map1);
        }
        ArrayList<Integer> l = new ArrayList<>();
        for (Integer key : map2) {
            if (map1.contains(key)) {
                l.add(key);
            }
        }
        return l.stream().mapToInt(Integer::intValue).toArray();
    }

    /*普通解法*/
    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> map1 = new HashSet<>();
        HashSet<Integer> map2 = new HashSet<>();

        for (int i : nums1) {
            map1.add(i);
        }
        for (int i : nums2) {
            map2.add(i);
        }
        ArrayList<Integer> l = new ArrayList<>();
        if (map1.size() < map2.size()) {
            for (Integer key : map1) {
                if (map2.contains(key)) {
                    l.add(key);
                }
            }
        } else {
            for (Integer key : map2) {
                if (map1.contains(key)) {
                    l.add(key);
                }
            }
        }

        return l.stream().mapToInt(Integer::intValue).toArray();
    }

    /*api 调用*/
    public static int[] intersection4(int[] nums1, int[] nums2) {
        HashSet<Integer> map1 = new HashSet<>();
        HashSet<Integer> map2 = new HashSet<>();
        for (int i : nums1) {
            map1.add(i);
        }
        for (int i : nums2) {
            map2.add(i);
        }
        map1.retainAll(map2);
        return map1.stream().mapToInt(i->i).toArray();
    }
    /* 加强版-- api 调用*/
    public static int[] intersection5(int[] nums1, int[] nums2) {
        Set<Integer> list = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> list2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        list.retainAll(list2);
        return list.stream().mapToInt(i ->i).toArray();
    }

}
