package leetcode._06_回溯;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * @author pppppp
 * @date 2022/3/1 19:11
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * <p>
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，
 * 但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，
 * 这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 * <p>
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 示例 3：
 * <p>
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 */
public class _93_复原IP地址 {


    List<String> path = new ArrayList<>();

    @Test
    public void T_() {
        List<String> list = restoreIpAddresses("1231231231234");
        System.out.println();
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() == 0 || s.length() > 12) {
            return res;
        }

        int len = s.length();
        // char[] ch = s.toCharArray();
        for (int l = 1; l < len; l++) {
            for (int m = l + 1; m - l <= 3; m++) {
                for (int r = len - 1; r >= len - 3 && r > m; r--) {
                    if (check(s.substring(0, l))
                            && check(s.substring(l, m))
                            && check(s.substring(m, r))
                            && check(s.substring(r))) {
                        res.add(s.substring(0, l) + "." + s.substring(l, m) + "." + s.substring(m, r) + "." + s.substring(r));
                    }
                }
            }

        }
        return res;
    }

    private boolean check(String s) {
        if (s.startsWith("0")) {
            return s.length() == 1;
        }
        if (Integer.valueOf(s) >= 0 && Integer.valueOf(s) <= 255) {
            return true;
        }
        return false;
    }

}
