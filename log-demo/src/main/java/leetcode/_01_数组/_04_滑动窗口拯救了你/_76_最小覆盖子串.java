package leetcode._01_数组._04_滑动窗口拯救了你;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author pppppp
 * @date 2022/1/19 8:14
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
 * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * <p>
 * 注意：
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
 * <p>
 * 示例 1：
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * <p>
 * 示例 2：
 * 输入：s = "a", t = "a"
 * 输出："a"
 * <p>
 * 示例 3:
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 */
public class _76_最小覆盖子串 {
    public static void main(String[] args) {

    }

    @Test
    public void T_() {

        String[] nums = {"ADOBECODEBANC", "a", "aa", "ab", "acbbaca", "aacbaccccaabcabbcab", "aAaabAbBaa"};
        String[] nums2 = {"ABC", "a", "aa", "b", "aba", "bcbbacaaab", "aaAB"};
        String[] res = {"BANC", "a", "aa", "b", "baca", "aabcabbcab", "AbBaa"};
        for (int i = 0; i < nums.length; i++) {
            System.out.println(minWindow3(nums[i], nums2[i]).equals(res[i]));
        }
    }

    public String minWindow3(String s, String t) {
        HashMap<Character, Integer> hs = new HashMap<>();
        HashMap<Character, Integer> ht = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            ht.put(t.charAt(i), ht.getOrDefault(t.charAt(i), 0) + 1);
        }
        String ans = "";
        int len = 0x3f3f3f3f, cnt = 0;  //有多少个元素符合
        for (int i = 0, j = 0; i < s.length(); i++) {
            if(ht.containsKey(s.charAt(i))){
                hs.put(s.charAt(i), hs.getOrDefault(s.charAt(i), 0) + 1);
                if(hs.get(s.charAt(i)) <= ht.get(s.charAt(i))){
                    cnt++;
                }
            }
            /*保证区间总是符合条件*/
            while (j < i && (!ht.containsKey(s.charAt(j)) || hs.get(s.charAt(j)) > ht.get(s.charAt(j)))) {
                if(hs.containsKey(s.charAt(j))){
                    hs.put(s.charAt(j), hs.get(s.charAt(j)) - 1);
                }
                j++;
            }
            if (cnt == t.length() && i - j + 1 < len) {
                len = i - j + 1;
                ans = s.substring(j, i + 1);
            }
        }
        return ans;
    }

    /*通过的案例 但是复杂*/
    public static String minWindow2(String s, String t) {
        int l = 0, count = 0;
        if (t.length() > s.length()) {
            return "";
        }

        HashMap<Character, Integer> tmap = new HashMap<>();
        HashMap<Character, Integer> map = new HashMap<>();
        String ans = "";
        for (int i = 0; i < t.length(); i++) {
            tmap.put(t.charAt(i), tmap.getOrDefault(t.charAt(i), 0) + 1);
        }
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            if (tmap.containsKey(c)) {
                if (!map.containsKey(c) || map.get(c) < tmap.get(c)) {
                    count++;
                }
                /*单个饱和时 暂不处理 直接在count到达目标值后 移除可能的多余元素*/
                map.put(c, map.getOrDefault(c, 0) + 1);
            } else if (count == 0) {
                l++;
            }

            if (count == t.length()) {
                while (l < r && (!tmap.containsKey(s.charAt(l)) || map.get(s.charAt(l)) > tmap.get(s.charAt(l)))) {
                    if (tmap.containsKey(s.charAt(l)) && map.get(s.charAt(l)) > tmap.get(s.charAt(l))) {
                        map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                    }
                    l++;
                }
                if (r - l + 1 < ans.length() || ans.length() == 0) {
                    ans = s.substring(l, r + 1);
                }
                count--;
                /*打破平衡使当前l-- r+1 不再符合条件*/
                boolean finish = false;
                while (l < r && (!tmap.containsKey(s.charAt(l)) || map.get(s.charAt(l)) >= tmap.get(s.charAt(l)))) {
                    if (tmap.containsKey(s.charAt(l)) && map.get(s.charAt(l)) >= tmap.get(s.charAt(l))) {
                        /*只比较一次*/
                        if (map.get(s.charAt(l)).equals(tmap.get(s.charAt(l)))) {
                            finish = true;
                        }
                        /*左边界向右移动到第一个目标字符*/
                        if (map.get(s.charAt(l)) == 1) {
                            map.remove(s.charAt(l));
                        } else {
                            map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                        }
                    }
                    l++;
                    if (finish) {
                        break;
                    }
                }
            }
        }
        return ans;
    }

    /*超时*/
    public static String minWindow(String s, String t) {
        int l = 0, r = 0, sl = 0, sr = s.length();
        if (t.length() > s.length()) {
            return "";
        }
        Queue<Integer> queue = new LinkedList<>();
        HashMap<Character, Integer> tmap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tmap.put(t.charAt(i), tmap.getOrDefault(t.charAt(i), 0) + 1);
        }

        HashMap<Character, int[]> map = new HashMap<>();
        for (; r < s.length(); r++) {
            char c = s.charAt(r);
            /*存在当前字符*/
            if (t.indexOf(c) != -1) {
                /*队列中目标字符数量小于t中时才入队*/
                if (map.get(c) == null || map.get(c)[1] < tmap.get(c)) {
                    queue.offer(r);
                    map.put(c, new int[]{r, map.getOrDefault(c, new int[]{r, 0})[1] + 1}); // index , count
                } else { /*队列中目标元素已饱和 最左侧目标元素出列 当前元素入列 */
                    if (s.charAt(queue.peek()) == c) {
                        queue.poll();
                        queue.offer(r);
                    } else {
                        Queue<Integer> queueTemp = new LinkedList<>();
                        boolean finish = false;
                        /*只出一个元素*/
                        while (!queue.isEmpty()) {
                            Integer poll = queue.poll();
                            if (s.charAt(poll) == c && !finish) {
                                finish = true;
                                continue;
                            }
                            queueTemp.offer(poll);
                        }
                        queueTemp.offer(r);
                        queue = queueTemp;
                    }
                    l = queue.peek();
                }
            } else if (queue.isEmpty()) {
                l++;
            }

            /*记录符合条件的位置*/
            if (queue.size() == t.length()) {
                if (r - l < sr - sl) {
                    sl = l;
                    sr = r;
                }
                int[] temp = map.get(s.charAt(queue.peek()));
                if (temp[1] == 1) {
                    map.remove(s.charAt(queue.peek()));
                } else {
                    map.put(s.charAt(queue.peek()), new int[]{temp[0], temp[1] - 1});
                }
                queue.poll();
                if (!queue.isEmpty()) {
                    l = queue.peek();
                } else {
                    l = r;
                }
            }
        }
        if (sr == s.length()) {
            return "";
        }
        return s.substring(sl, sr + 1);
    }
}
