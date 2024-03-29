package leetcode._7_栈和队列;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * @author pppppp
 * @date 2022/1/18 14:59
 * 根据 逆波兰表示法，求表达式的值。
 *
 * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * 说明：
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 *  
 * 示例 1：
 * 输入：tokens = ["2","1","+","3","*"]
 * 输出：9
 * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 *
 * 示例 2：
 * 输入：tokens = ["4","13","5","/","+"]
 * 输出：6
 * 解释：该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
 *
 * 示例 3：
 * 输入：tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * 输出：22
 * 解释：
 * 该算式转化为常见的中缀算术表达式为：
 *   ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 */
public class _150_逆波兰表达式求值 {
    public static void main(String[] args) {
        String[][] nums = {{"2","1","+","3","*"}, {"4","13","5","/","+"},{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}};
        int[] res = {9,6,22};
        for (int i = 0; i < nums.length; i++) {
            System.out.println(evalRPN2(nums[i]) == res[i]);
        }
    }
    public static int evalRPN2(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if(tokens[i].equals("+")){
                stack.push(stack.pop() + stack.pop());
            }else if(tokens[i].equals("-")){
                stack.push(-stack.pop() + stack.pop());
            }else if(tokens[i].equals("*")){
                stack.push(stack.pop() * stack.pop());
            }else if(tokens[i].equals("/")){
                Integer pop2 = stack.pop();
                Integer pop1 = stack.pop();
                stack.push(pop1/pop2);
            } else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if(Arrays.asList("+","-","*","/").contains(tokens[i])){
                Integer pop2 = stack.pop();
                Integer pop1 = stack.pop();
                switch (tokens[i]){
                    case "+": stack.push(pop1 + pop2);break;
                    case "-": stack.push(pop1 - pop2);break;
                    case "*": stack.push(pop1 * pop2);break;
                    case "/": stack.push(pop1 / pop2);break;
                }
            }else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }
}
