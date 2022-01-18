package leetcode._7_栈和队列;

import org.junit.Test;

import java.util.*;

/**
 * @author pppppp
 * @date 2022/1/18 21:39
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。

 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]

 */


public class _347_前K个高频元素 {
    public static void main(String[] args) {

    }

    @Test
    public void T_(){
        int[][] nums = {{1,1,1,2,2,3}, {1}};
        int[] nums2 = {2, 1};
        int[][] res = {{1,2}, {1}};
        for (int i = 0; i < nums.length; i++) {
            int[] ints = topKFrequent3(nums[i], nums2[i]);
            for (int j = 0; j < ints.length; j++) {
                System.out.println(ints[j] == res[i][j]);
            }
        }
    }

    /*使用小根堆 优化 只排前k个*/
    public static int[] topKFrequent3(int[] nums, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1 );
        }
        for (Integer key : map.keySet()) {
            /*只保留前k个*/
            if(queue.size() == k){
                /*比较最小值和当前值*/
                if(queue.peek()[1] < map.get(key)){
                    queue.poll();
                    queue.offer(new int[]{key, map.get(key)});
                }
            }else {
                queue.offer(new int[]{key, map.get(key)});
            }
        }

        int []res = new int[k];
        for (int i = k-1; i >= 0; i--) {
            res[i] = queue.poll()[0];
        }
        return res;
    }

    /*使用大根堆 全排*/
    public static int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1 );
        }
        for (Integer key : map.keySet()) {
            queue.offer(new int[]{key, map.get(key)});
        }

        int []res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll()[0];
        }
        return res;
    }
}
