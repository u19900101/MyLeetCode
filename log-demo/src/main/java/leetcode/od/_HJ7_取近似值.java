package leetcode.od;

import org.junit.Test;

import java.util.Scanner;

import static leetcode.od._HJ6_质数因子.isZhishu;

/**
 * @author pppppp
 * @date 2022/3/1 10:44
 * 描述
 * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。
 * 如果小数点后数值大于等于 0.5 ,向上取整；小于 0.5 ，则向下取整。
 *
 * 数据范围：保证输入的数字在 32 位浮点数范围内
 * 输入描述：
 * 输入一个正浮点数值
 *
 * 输出描述：
 * 输出该数值的近似整数值
 *
 * 示例1
 * 输入：
 * 5.5

 * 输出：
 * 6

 * 说明：
 * 0.5>=0.5，所以5.5需要向上取整为6   
 * 示例2
 * 输入：
 * 2.499

 * 输出：
 * 2

 * 说明：
 * 0.499<0.5，2.499向下取整为2   
 */
public class _HJ7_取近似值 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            /*Float f = scanner.nextFloat();
            if(f - f.intValue() >= 0.5){
                System.out.println(f.intValue() + 1);
            }else {
                System.out.println(f.intValue());
            }*/
            float v = scanner.nextFloat();
            /*得到第一位小数*/
            float v1 = v * 10 % 10;
            if(v1 >= 5 ){
                System.out.println((int)v  +1);
            }else {
                System.out.println((int)v);
            }
        }
    }

    @Test
    public void T_(){
        for (int i = 0; i < 10; i++) {
            System.out.println(i + 0.1 * i + " " +Math.ceil(i + 0.1 * i));
        }
    }
}
