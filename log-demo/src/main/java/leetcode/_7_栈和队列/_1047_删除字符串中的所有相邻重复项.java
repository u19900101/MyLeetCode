package leetcode._7_栈和队列;

import com.sun.javaws.IconUtil;
import org.junit.Test;

import java.util.Stack;

/**
 * @author pppppp
 * @date 2022/1/18 10:47
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * <p>
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * <p>
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 * 示例：
 * <p>
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。
 * 之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 */
public class _1047_删除字符串中的所有相邻重复项 {
    public static void main(String[] args) {
        String[] nums = {"abbaca"};
        String[] res = {"ca"};
        for (int i = 0; i < nums.length; i++) {
            System.out.println(removeDuplicates3(nums[i]).equals(res[i]));
        }
    }

    /*较优解*/
    public static String removeDuplicates3(String s) {
        char[] chs = s.toCharArray();
        int top = -1;
        for (int i = 0; i < s.length(); i++) {
            if (top == -1 || chs[top] != chs[i]) {
                chs[++top] = chs[i];
            } else {
                top--;
            }
        }
        return String.valueOf(chs, 0, top + 1);
    }

    /*数组实现*/
    public static String removeDuplicates2(String s) {
        char[] charArray = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = charArray[i];
            if(sb.length() > 0 && sb.charAt(sb.length()-1) == c){
                sb.deleteCharAt(sb.length()-1);
            }else {
                sb.append(c);
            }
        }
        return sb.toString();

    }
    /*使用栈*/
    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!stack.empty() && stack.peek()==c){
                stack.pop();
            }else {
                stack.push(c);
            }
        }
        String res = "";
        while (!stack.empty()){
            res = stack.pop() + res;
        }

        return res;
    }
}
