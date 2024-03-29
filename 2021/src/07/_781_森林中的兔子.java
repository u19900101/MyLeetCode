import org.junit.Test;

import java.util.*;

/**
 * @author lppppp
 * @create 2021-04-04 22:08
 *
 * ## 难度 中等
 *
 * 森林中，每个兔子都有颜色。其中一些兔子（可能是全部）告诉你还有多少其他的兔子和自己有相同的颜色。
 * 我们将这些回答放在 answers 数组里。
 *
 * 返回森林中兔子的最少数量。
 *
 * **示例:**
 * 输入: answers = [1, 1, 2]
 * 输出: 5
 * 解释:
 * 两只回答了 "1" 的兔子可能有相同的颜色，设为红色。
 * 之后回答了 "2" 的兔子不会是红色，否则他们的回答会相互矛盾。
 * 设回答了 "2" 的兔子为蓝色。
 * 此外，森林中还应有另外 2 只蓝色兔子的回答没有包含在数组中。
 * 因此森林中兔子的最少数量是 5: 3 只回答的和 2 只没有回答的。
 *
 * 输入: answers = [10, 10, 10]
 * 输出: 11
 *
 * 输入: answers = []
 * 输出: 0
 * 说明:
 *
 * answers 的长度最大为1000。
 * answers[i] 是在 [0, 999] 范围内的整数。
 *
 */
public class _781_森林中的兔子 {
    public static int numRabbits(int[] answers) {
        if(answers.length == 0){
            return 0;
        }
        int sum = 0;
        //1.对数组进行从大到小的排序
        Arrays.sort(answers);
        Map<Integer,Integer> map = new HashMap();
        //2.将数组变为 map  key为 数值  value 为个数
        int temp = answers[0];
        int value = 1;
        map.put(temp, value);
        for (int i = 1; i < answers.length; i++) {
            if(answers[i] == temp){
                value++;
            }else {
                value = 1;
                temp = answers[i];
            }
            map.put(temp, value);
        }

        // System.out.println(map);
        Set<Integer> set = map.keySet();
        for (Integer key : set) {
            int tempValue = map.get(key);
          /*  if(key == 0){
                sum += tempValue;
                continue;
            }*/

            if(tempValue<= key+1){
                sum +=  key+ 1;
            }else {
                int i;
                if(tempValue %(key + 1) == 0){
                    i = tempValue /(key + 1);
                }else {
                    i = tempValue /(key + 1) + 1;
                }

                sum += (key+ 1) * i;
            }
        }
        System.out.println(sum);
        return sum;
    }

    public static void main(String[] args) {
        // int[] answers = {1, 1, 2};
        int[] answers = {1,0,1,0,0};
        // int[] answers = {4,0,2,2,4};
        // int[] answers = {2,1,2,2,2,2,2,2,1,1};
        // int[] answers = {0,1,0,2,0,1,0,2,1,1};
        // int[] answers = {1, 1, 1,2};
        // int []answers = {5,1, 1,1, 2,5,6};
        // int []answers = {5,5,5,5,5,5,5};
        // int []answers = {10,10,10};
        int i = numRabbits(answers);
    }

    @Test
    public void T(){
        int i = 7;
        int i1 = (7 % 3)+ 1;
        System.out.println(i1);
    }
}
