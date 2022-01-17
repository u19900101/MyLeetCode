package leetcode.od;

import org.junit.Test;

import java.util.*;
import java.text.*;

public class 求解三次根号 {
    public static void main(String[] args) {
     /*   Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Double aDouble = Double.valueOf(s);
        System.out.println(solution(aDouble));*/
        System.out.println(solution(Double.valueOf(0.3)));
    }
    /*牛顿迭代求解三次方*/
    private static String  solution(Double aDouble) {
        double x0 = aDouble,x1 = 0;
        while (true){
            x1 = (2*x0 + aDouble/(x0*x0))/3;
            if(Math.abs(x1-x0) < 1e-6){
                break;
            }
            x0 = x1;
        }
        /*保留一位小数*/
        return String.format("%.1f",x1);
    }
}