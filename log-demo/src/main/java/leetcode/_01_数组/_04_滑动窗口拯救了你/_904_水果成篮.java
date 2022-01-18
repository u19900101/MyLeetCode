package leetcode._01_数组._04_滑动窗口拯救了你;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author pppppp
 * @date 2022/1/17 23:13
 * 你正在探访一家农场，农场从左到右种植了一排果树。这些树用一个整数数组 fruits 表示，
 * 其中 fruits[i] 是第 i 棵树上的水果 种类 。

 * 你想要尽可能多地收集水果。然而，农场的主人设定了一些严格的规矩，你必须按照要求采摘水果：

 * 你只有 两个 篮子，并且每个篮子只能装 单一类型 的水果。每个篮子能够装的水果总量没有限制。
 * 你可以选择任意一棵树开始采摘，你必须从 每棵 树（包括开始采摘的树）上 恰好摘一个水果 。
 * 采摘的水果应当符合篮子中的水果类型。每采摘一次，你将会向右移动到下一棵树，并继续采摘。
 * 一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘。
 * 给你一个整数数组 fruits ，返回你可以收集的水果的 最大 数目。

 * 示例 1：
 * 输入：fruits = [1,2,1]
 * 输出：3
 * 解释：可以采摘全部 3 棵树。、

 * 示例 2：
 * 输入：fruits = [0,1,2,2]
 * 输出：3
 * 解释：可以采摘 [1,2,2] 这三棵树。
 * 如果从第一棵树开始采摘，则只能采摘 [0,1] 这两棵树。
 *
 * 示例 3：
 * 输入：fruits = [1,2,3,2,2]
 * 输出：4
 * 解释：可以采摘 [2,3,2,2] 这四棵树。
 * 如果从第一棵树开始采摘，则只能采摘 [1,2] 这两棵树。

 * 示例 4：
 * 输入：fruits = [3,3,3,1,2,1,1,2,3,3,4]
 * 输出：5
 * 解释：可以采摘 [1,2,1,1,2] 这五棵树。
 */
public class _904_水果成篮 {

    public static void main(String[] args) {
        int[][] nums = {{1, 2, 1}, {0, 1, 2, 2}, {1, 2, 3, 2, 2}, {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4},{3,3,3,3,3,3}};
        int[] res = {3, 3, 4, 5,6};
        for (int i = 0; i < nums.length; i++) {
            System.out.println(res[i] == totalFruit2(nums[i]));
        }
    }

    /*使用队列求解*/
    public static int totalFruit2(int[] fruits) {
        if (fruits.length < 3) {
            return fruits.length;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int l = 0,res = 2;
        for (int r = 0; r < fruits.length; r++) {
            map.put(fruits[r],(map.get(fruits[r]) == null ? 0 : map.get(fruits[r])) + 1);
            while (map.size() == 3){
                /*出队列*/
                map.put(fruits[l],map.get(fruits[l]) - 1);
                if(map.get(fruits[l]) == 0){
                    map.remove(fruits[l]);
                }
                l++;
            }
            res = Math.max(r-l+1,res);
        }
        return res;
    }

    /*常规做法*/
    public static int totalFruit(int[] fruits) {
        if (fruits.length < 3) {
            return fruits.length;
        }
        int res = 2,r= 0;
        while (r < fruits.length - 1) {
            /*找到第一个相邻两个不相等的位置*/
            int l = r;
            /*保存临界点的位置*/
            int loc = -1;
            while (l < fruits.length - 1) {
                if (fruits[l] != fruits[l + 1]) {
                    loc = l;
                    break;
                }
                l++;
            }
            /*没有分界点 （1.只有一种水果时 2.或者已经遍历到末尾*/
            if (loc == -1) {
                return r == 0 ? fruits.length : res;
            }
            /*从临界点分别向左右两边进行搜索*/
            /*向左*/
            int tempres = 2;
            l--;
            while (l >= 0 && (fruits[l] == fruits[loc] || fruits[l] == fruits[loc + 1])) {
                tempres++;
                l--;
            }
            /*向右*/
            int tempr = loc + 2;
            while (tempr < fruits.length && (fruits[tempr] == fruits[loc] || fruits[tempr] == fruits[loc + 1])) {
                tempres++;
                tempr++;
            }
            res = tempres > res ? tempres : res;
            /*搜索下一个分界点继续搜索直到结束*/
            r = tempr - 1;
        }
        return res;
    }
}
