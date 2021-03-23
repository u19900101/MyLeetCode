package hw_od.one_start;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author lppppp
 * @create 2021-03-23 19:58
 */
public class num_1 {
//【喊7的次数重排】   35min
//     in   0   1  0
//     out  1   0  0
    @Test
    public void T_1(){
        String s = "0 1 0";
        String[] s1 = s.split(" ");
        int totalNumatLeast = 0;
        for (int i = 0; i < s1.length; i++) {
            if(Integer.valueOf(s1[i]) == 1){
                totalNumatLeast +=7;
            }
        }
        int numOfPerson = s1.length;
        // int numOfPerson = 3;
        int []times = new int[numOfPerson];

        for (int i = 1; i <= totalNumatLeast; i++) {
            int isGuo = isGuo(i);
            times[(i-1)%numOfPerson] += isGuo;
            System.out.print(i%numOfPerson + " -- "+isGuo+"\t");
            if(i%numOfPerson == 0){
                System.out.println();
            }
        }
        System.out.println(Arrays.toString(times));

        String res = "";
        for (int time : times) {
            res += time + " ";
        }
        System.out.println(res);
    }

    private int isGuo(int i) {
        if(i%7 ==0 || String.valueOf(i).contains("7")){
            return 1;
        }else {
            return 0;
        }
    }


}
