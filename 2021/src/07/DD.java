/**
 * @author pppppp
 * @date 2021/7/20 8:34   耗时 20min
 */
/*  题目：某个富翁招收保镖，为了提高吸引力，设置了一个特殊的工资，
    第一天保镖能获取1元报酬，随后两天能获得2元，在随后三天能够获得3元...
    以此类推，给定一个天数，得出能够获得的报酬
    输入 3， 返回5   1+2+2 = 5
    输入 10，返回30  1+2+2+3+3+3+4+4+4+4 = 30
*   */
public class DD {
    public static void main(String[] args){
        int flag = 6;
        System.out.println(demo(flag));
    }
    static int demo(int inNum){
        int sum = 0;
        for (int i = 1; ; i++) {
            if(inNum >= i){
                sum += i*i;
            }else {
                sum = sum+inNum*i;
                break;
            }
            inNum -=i;
        }
        return sum;

    }
}
