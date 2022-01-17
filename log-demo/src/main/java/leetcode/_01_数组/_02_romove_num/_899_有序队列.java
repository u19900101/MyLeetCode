package leetcode._01_数组._02_romove_num;

/**
 * @author pppppp
 * @date 2022/1/16 16:27
 * 给出了一个由小写字母组成的字符串 S。然后，我们可以进行任意次数的移动。
 * 在每次移动中，我们选择前 K 个字母中的一个（从左侧开始），将其从原位置移除，并放置在字符串的末尾。
 * 返回我们在任意次数的移动之后可以拥有的按字典顺序排列的最小字符串。

 * 示例 1：
 * 输入：S = "cba", K = 1
 * 输出："acb"
 * 解释：
 * 在第一步中，我们将第一个字符（“c”）移动到最后，获得字符串 “bac”。
 * 在第二步中，我们将第一个字符（“b”）移动到最后，获得最终结果 “acb”。
 *
 *
 * 示例 2：
 * 输入：S = "baaca", K = 3
 * 输出："aaabc"
 * 解释：
 * 在第一步中，我们将第一个字符（“b”）移动到最后，获得字符串 “aacab”。
 * 在第二步中，我们将第三个字符（“c”）移动到最后，获得最终结果 “aaabc”。

 */
public class _899_有序队列 {
    public static void main(String[] args){
        String[] s = {"cba","baaca"};
        String[] t = {"acb","aaabc"};
        int[] res = {1,3};
        for (int i = 0; i < s.length; i++) {
            System.out.println(orderlyQueue(s[i],res[i] ) == t[i]);
        }
    }
    public static String orderlyQueue(String s, int k) {

        return "";
    }
}
