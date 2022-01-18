package leetcode._7_栈和队列;

import org.junit.Test;

import java.io.Serializable;
import java.util.*;

/**
 * @author pppppp
 * @date 2022/1/18 15:27
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值。
 * <p>
 * 示例 1：
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * <p>
 * <p>
 * 示例 2：
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * <p>
 * 示例 3：
 * 输入：nums = [1,-1], k = 1
 * 输出：[1,-1]
 * <p>
 * 示例 4：
 * 输入：nums = [9,11], k = 2
 * 输出：[11]
 * <p>
 * 示例 5：
 * 输入：nums = [4,-2], k = 2
 * 输出：[4]
 */
public class _239_滑动窗口最大值 {
    public static void main(String[] args) {
        // int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        // int[] res = {3, 3, 5, 5, 6, 7};
        // int[] nums = {1,-1};
        // int[] res = {1,-1};
        int[] nums = {1, 3, 1, 2, 0, 5};
        int[] res = {3, 3, 2, 5};
        int[] maxSlidingWindow = maxSlidingWindow4(nums, 3);
        for (int i = 0; i < maxSlidingWindow.length; i++) {
            System.out.println(res[i] == maxSlidingWindow[i]);
        }
    }

    /*官方题解 使用优先队列*/
    public int[] maxSlidingWindow3(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] pair1, int[] pair2) {
                /*逆序 数字相同时 index大的排在前面*/
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; ++i) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }

    //改进 -- 使用双向队列进行求解
    public static int[] maxSlidingWindow4(int[] nums, int k) {
        int l = 0;
        Deque<Integer> deque = new LinkedList<>();
        for (int r = 0; r < nums.length; r++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[r]) {
                deque.pollLast();
            }
            /*只记录下标*/
            deque.addLast(r);
            if (r >= k - 1) {
                nums[l] = nums[deque.peekFirst()];
                if (l == deque.peekFirst()) {
                    deque.pollFirst();
                }
                l++;
            }
        }
        return Arrays.copyOfRange(nums, 0, nums.length - k + 1);
    }

    //使用双向队列进行求解
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int l = 0;
        Deque<MyNumber> deque = new LinkedList<>();
        for (int r = 0; r < nums.length; r++) {
            while (!deque.isEmpty() && deque.peekLast().value <= nums[r]) {
                deque.pollLast();
            }
            deque.addLast(new MyNumber(r, nums[r]));
            if (r >= k - 1) {
                MyNumber myNumber = deque.peekFirst();
                nums[l] = myNumber.value;
                if (l == myNumber.key) {
                    deque.pollFirst();
                }
                l++;
            }
        }
        return Arrays.copyOfRange(nums, 0, nums.length - k + 1);
    }

    /*超时间限制的暴力破解*/
    public int[] maxSlidingWindow2(int[] nums, int k) {
        for (int i = 0; i <= nums.length - k; i++) {
            int max = getMax(nums, i, i + k - 1);
            nums[i] = max;
        }
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i <= nums.length - k; i++) {
            res[i] = nums[i];
        }
        return res;
    }


    private static int getMax(int[] nums, int l, int r) {
        int max = nums[l];
        for (int i = l + 1; i <= r; i++) {
            max = Math.max(nums[i], max);
        }
        return max;
    }
}

class MyNumber {
    Integer key;
    Integer value;

    public MyNumber(Integer key, Integer value) {
        this.key = key;
        this.value = value;
    }
}

