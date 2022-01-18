package leetcode._7_栈和队列;

import java.util.Stack;

/**
 * @author pppppp
 * @date 2022/1/18 9:51
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：s = "(]"
 * 输出：false
 * 示例 4：
 * <p>
 * 输入：s = "([)]"
 * 输出：false
 * 示例 5：
 * <p>
 * 输入：s = "{[]}"
 * 输出：true
 */
public class _20_有效的括号 {
    public static void main(String[] args) {
        String[] nums = {"()", "()[]{}", "(]", "([)]", "{[]}", "(])"};
        boolean[] res = {true, true, false, false, true, false};
        for (int i = 0; i < nums.length; i++) {
            System.out.println(isValid2(nums[i]) == res[i]);
        }
    }

    public static boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')' || c == ']' || c == '}') {
                if (stack.empty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (c == ')' && pop != '(' || c == ']' && pop != '[' || c == '}' && pop != '{') {
                    return false;
                }
            }else {
                stack.push(c);
            }
        }
        return stack.empty();
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.empty() && (c == ')' || c == ']' || c == '}')) {
                return false;
            }
            switch (c) {
                case ')':
                    if (stack.peek() == '(') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.peek() == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.peek() == '{') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                default:
                    stack.push(c);
            }
        }
        return stack.empty();
    }
}
