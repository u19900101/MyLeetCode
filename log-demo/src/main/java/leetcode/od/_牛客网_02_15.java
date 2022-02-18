package leetcode.od;

import org.junit.Test;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author pppppp
 * @date 2022/2/18 13:43
 * <p>
 * 第一道题
 * 第一道是快乐消消乐，就是给定一个字符串将相邻的两个字符进行消除，最后返回消除后字符串的总长数
 * 例子： ggA, 结果 1
 * 消除 gg 后剩下 A ，因此最后结果 1
 * 例子2：abccbe，结果 2
 * 消除 cc 后字符串变成 abbe 在消除 bb，变 ae，因此结果 2
 * <p>
 * <p>
 * 第二道题是给两个字符串，targe，和 source，查找 targe 是否由 source 删除某些字符得到的，
 * 是返回开始的最大下标，否返回 -1
 * 例子：
 * 输入：
 * abc
 * abcaybec
 * 结果为 3
 * 解释：abc 可以由下面 abcaybec 删除 aybec 和 abcye 而来，删除 abcye 是最后的这个组成的 a 在下标位置 3 下，因此返回 3
 * <p>
 * <p>
 * 第三题是今典题目，就在二维数组中取连线最大的，（好像是 leetcode 的青蛙跳？），可以前后左右对角线的连接取最大值
 * 输入
 * 4 4
 * 1 0 0 0 1
 * 1 0 0 1 1
 * 1 1 1 0 1
 * 1 1 1 1 0
 * 结果 4
 * 解释对角线 4 个 0
 */
public class _牛客网_02_15 {
    @Test
    public void T_xxl() {
        String[] s = {"ggA", "abccbe", "abccba"};
        int[] res = {1, 2, 0};
        for (int i = 0; i < s.length; i++) {
            System.out.println(xxl(s[i]) == res[i]);
        }
    }

    public int xxl(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty() || stack.peek() != s.charAt(i)) {
                stack.push(s.charAt(i));
            } else {
                stack.pop();
            }
        }
        return stack.size();
    }

    @Test
    public void T_maxIndexSonStr() {
        System.out.println(maxIndexSonStr("abc", "abcayabec") == 5);

    }

    public int maxIndexSonStr(String targe, String resource) {
        int l = targe.length() - 1, r = resource.length() - 1;
        while (r >= l) {
            if (targe.charAt(l) == resource.charAt(r)) {
                if (l == 0) {
                    return r;
                }
                r--;
                l--;
            } else {
                r--;
            }
        }
        return -1;
    }


    /*2-16*/
    /*  第二道：给出一个数组n[ ]，其中n[0]=0，从n[0]开始向后走，
        第一步可走的距离len满足1<=len<=n.length/2，之后的每一步距离等于该位置的值n[index]，
        问能否走到数组的最后一个位置，如果能，返回最小的步数
        */

    /*
    * 第三道
        是给定长度为n的两个二进制码
        1001
        1100
        问第一个二进制码如果有两个数字交换位置
        有多少种情况会对第一个二进制码和第二个二进制码的或结果造成影响

    * */

    /*
        让你找出最长的一个连续的数字（要求非严格递增，即 12234 这种，递增但不要求严格递增，但不能递减），
        比如  abasdf12234sdaf112 ， 最长连续数字是 12234，长度是5，让你返回这个长度。
        */
    @Test
    public void T_maxLengthNums() {
        int len = maxLengthNums("abasdf12234sdaf11233321");
        System.out.println(len);
    }

    public int maxLengthNums(String s) {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(s);
        int max = -1;
        while (m.find()) {
            String sub = s.substring(m.start(), m.end());
            int len = 1;
            for (int i = 0; i < sub.length() - 1; i++) {
                if (sub.charAt(i) <= sub.charAt(i + 1)) {
                    len = i + 2;
                } else {
                    break;
                }
            }
            max = Math.max(max, len);
        }
        return max;
    }

    /*
    第二题，题目很复杂，先给出一个 众数 的概念，就是数组中出现次数最多的数字。
    又给出一个 中位数的概念，就是从小到大排序后，中间那个数。如果数组大小是偶数，则取中间两个相加再除以2.
    让求  给定的数组中的众数， 如果有多个，就把众数组成一个新的数组，求新数组的中位数。
    */

    @Test
    public void T_getZhongShu() {
        int[][] nums = {{1, 2, 1, 1, 1}, {4, 4, 1, 1, 2, 2}, {1, 2, 3}};
        int[] res = {1, 2, 2};
        for (int i = 2; i < nums.length; i++) {
            System.out.println(getZhongShu2(nums[i]) == res[i]);
        }

    }

    /*改进版写法 使用数组的排序*/
    public int getZhongShu2(int[] nums) {
        if (nums.length < 2) {
            return nums[0];
        }
        Arrays.sort(nums);
        ArrayList<MyMap> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            int count = 1;
            while (i <= nums.length - 2 && nums[i] == nums[i + 1]) {
                i++;
                count++;
            }
            list.add(new MyMap(nums[i], count));
        }
        if (nums[nums.length - 2] != nums[nums.length - 1]) {
            list.add(new MyMap(nums[nums.length - 1], 1));
        }

        int size = list.size();
        if (size == 1) {
            return list.get(0).value;
        }

        if (size % 2 == 0) {
            return (list.get(size / 2).value + list.get(size / 2 - 1).value) / 2;
        }
        return list.get(size / 2).value;
    }

    /*使用hashmap和优先队列*/
    public int getZhongShu(int[] nums) {
        // Arrays.sort(nums);
        /*使用hashmap获取频数*/
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        /*使用优先队列*/
        PriorityQueue<MyMap> queue = new PriorityQueue<>(new Comparator<MyMap>() {
            @Override
            public int compare(MyMap o1, MyMap o2) {
                return o2.count - o1.count;
            }
        });
        for (Integer key : map.keySet()) {
            queue.offer(new MyMap(key, map.get(key)));
        }
        if (queue.size() < 2) {
            return nums[0];
        }
        ArrayList<Integer> list = new ArrayList<>();
        MyMap root = queue.poll();
        list.add(root.value);
        int maxCount = root.count;
        while (!queue.isEmpty()) {
            MyMap poll = queue.poll();
            if (poll.count != maxCount) {
                break;
            } else {
                list.add(poll.value);
            }
        }
        int size = list.size();
        if (size == 1) {
            return list.get(0);
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        if (size % 2 == 0) {
            return (list.get(size / 2) + list.get(size / 2 - 1)) / 2;
        }
        return list.get(size / 2);
    }

    /*
    第三题：
    有一大堆墓碑碎片，每个碎片就是一个字符串，让你给出排列组合的所有可能，要去重。
    比如  a  b c   这么3块墓碑,排列组合有：
    abc acb bac bca cab cba  这么多种。
    比如 墓碑是 a b ab  ，则 要记得去重，结果是  abab aabb baab baba abba ,
    其实还有一个 abab,因为和第一个重了，所以要去掉。加粗的是 那个连着的 ab 。
    */

    @Test
    public void T_allText(){
        String [][] s = {{"a","b","c"},{"a","b","ab"}};
        for (int i = 1; i < s.length; i++) {
            List<String> list = allText(s[i]);
            for (String s1 : list) {
                System.out.println(s1);
            }
        }

    }
    public List<String> allText(String[] resource) {
        List<String> nums = quanPai2(resource.length);
        HashSet<String> set = new HashSet<>();
        for (String numStr : nums) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < numStr.length(); i++) {
                sb.append(resource[Character.getNumericValue(numStr.charAt(i))]);
            }
            set.add(sb.toString());
        }
        return new ArrayList<>(set);
    }

    @Test
    public void T_quanPai(){
        List<String> strings = quanPai2(3);
        for (String string : strings) {
            System.out.println(string);
        }
    }

    /*递归获取全排列*/
    public List<String> quanPai(int n) {
        if (n < 2) {
            ArrayList<String> list = new ArrayList<>();
            list.add("0");
            return list;
        }

        List<String> strs = quanPai(n - 1);
        List<String> res = new ArrayList<>();
        for (String str : strs) {
            for (int i = 0; i <= str.length(); i++) {
                String s = str.substring(0, i) + (n - 1) + str.substring(i);
                res.add(s);
            }
        }
        return res;
    }

    /*直接获取全排列*/
    public List<String> quanPai2(int n) {
        List<String> res = new ArrayList<>();
        if(n == 1){
            res.add("0");
            return res;
        }
        res.add("0");
        n--;
        while (n > 0){
            int size = res.size();
            while (size > 0){
                String str = res.remove(size - 1);
                for (int j = 0; j <= str.length(); j++) {
                    String s = str.substring(0, j) + (n) + str.substring(j);
                    res.add(s);
                }
                size--;
            }
            n--;
        }
        return res;
    }
}

class MyMap {
    int value;
    int count;

    MyMap(int value, int count) {
        this.value = value;
        this.count = count;
    }
}
