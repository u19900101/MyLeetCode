package leetcode._06_回溯;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author pppppp
 * @date 2022/2/24 14:04
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * <p>
 * 说明：
 * <p>
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 * <p>
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class _216_组合总和_III {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    @Test
    public void T_() {
        // List<List<Integer>> lists = combinationSum3GF(3, 9);
        // List<List<Integer>> lists = combinationSum3GF(3, 7);
        List<List<Integer>> lists = combinationSum3USE77(4, 24);
        System.out.println();
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (n > 45 || k > 9) {
            return ans;
        }
        dfs2(k, n, 9, ans);
        return ans;
    }
    /*自己的题解  从大数开始 有一定的剪枝效果*/
    private void dfs2(int k, int n, int curIndex, List<List<Integer>> ans) {

        if (k == 0 && n == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        if (n < sumN(k)) {
            return;
        }
        for (int i = curIndex; i >= 1; i--) {
            temp.add(i);
            dfs2(k - 1, n - i, i - 1, ans);
            temp.remove(temp.size() - 1);
        }
    }

    private int sumN(int k) {
        int sum = 0;
        while (k > 0) {
            sum += k;
            k--;
        }
        return sum;
    }

    /*官方题解--二进制（子集）枚举  可以完成但是太复杂了*/
    public List<List<Integer>> combinationSum3GF(int k, int n) {
        if (n > 45 || k > 9) {
            return ans;
        }
        for (int i = 0; i < (1 << 9); i++) {
            if (i == 27) {
                System.out.println();
            }
            if (check(k, n, i)) {
                ans.add(new ArrayList<>(temp));
            }
        }
        return ans;
    }

    private boolean check(int k, int n, int mask) {
        temp.clear();
        int sum = 0;
        for (int j = 0; j < 9; j++) {
            if ((mask & (1 << j)) != 0) {
                temp.add(j + 1);
                sum += j + 1;
                if (sum == n) {
                    return temp.size() == k && (mask >> (j + 1) == 0);
                }
                if (sum > n || temp.size() == k) {
                    return false;
                }
            }
        }
        return false;
    }

    /*2.使用77中的组合*/
    public List<List<Integer>> combinationSum3USE77(int k, int n) {
        if (n > 45 || k > 9) {
            return ans;
        }
        dfs77(k, n, 1, ans);
        return ans;
    }

    private void dfs77(int k, int n, int curIndex, List<List<Integer>> ans) {
        if (temp.size() == k) {
            if (sumArr(temp) == n) {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }

        for (int i = curIndex; i <= Math.min(9,n - (k - temp.size()) + 1); i++) {
            temp.add(i);
            dfs77(k, n, i + 1, ans);
            temp.remove(temp.size() - 1);
        }
    }

    private boolean isStop(int k, int n, int i) {
        int sumArr = sumArr(temp);
        int absNum = k - temp.size(), j = i;
        while (absNum > 0 && j<= 9) {
            sumArr += j;
            if (sumArr > n) {
                return true;
            }
            j++;
            absNum--;
        }
        return false;
    }

    private int sumArr(List<Integer> temp) {
        int sum = 0;
        for (Integer integer : temp) {
            sum += integer;
        }
        return sum;
    }


    /*代码随想*/
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum3KR(int k, int n) {
        backTracking(n, k, 1, 0);
        return result;
    }

    private void backTracking(int targetSum, int k, int startIndex, int sum) {
        // 减枝
        if (sum > targetSum) {
            return;
        }

        if (path.size() == k) {
            if (sum == targetSum) {
                result.add(new ArrayList<>(path));
            }
            return;
        }

        // 减枝 9 - (k - path.size()) + 1
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            path.add(i);
            sum += i;
            backTracking(targetSum, k, i + 1, sum);
            //回溯
            path.removeLast();
            //回溯
            sum -= i;
        }
    }

}
