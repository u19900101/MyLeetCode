package leetcode.od;

import java.util.*;

/**
 * @author pppppp
 * @date 2022/1/22 10:27
 * 2和5  6和9 可以相互使用
 */
public class _s2_数字排列 {
    public static void main(String[] args) {
        Object[][] nums = {
                {"1,4,8", 81},
                {"1,2,3", 81},
        };
        for (int i = 1; i < nums.length; i++) {
            System.out.println(f(String.valueOf(nums[i][0])) == (Integer) nums[i][1]);
        }
    }

    private static int f(String s) {
        s = s.replaceAll("\\D", "");
        if (s.length() != 3
                || s.charAt(0) == s.charAt(1)
                || s.charAt(1) == s.charAt(2)
                || s.charAt(0) == s.charAt(2)) {
            return -1;
        }

        if(s.indexOf("6") != -1 && s.indexOf("9") == -1){
            s = s.replaceAll("6","9");
        }else if(s.indexOf("2") != -1 && s.indexOf("5") == -1){
            s = s.replaceAll("2","5");
        }
        int[] nums = {Integer.valueOf(s.substring(0,1)),Integer.valueOf(s.substring(1,2)),Integer.valueOf(s.substring(2,3))};
        int max = nums[0] > nums[1] ? (nums[0] > nums[2] ? nums[0] : nums[2]) : (nums[1] > nums[2] ? nums[1] : nums[2]);
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<String> strL = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            strL.add(i + "" );
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(i != j){
                    strL.add(i + "" + j);
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if(i != j && i != k && j!= k){
                        strL.add(i + "" + j + k);
                    }
                }
            }
        }

        for (String s1 : strL) {
            String st = "";
            for (int i = 0; i < s1.length(); i++) {
                st += nums[Integer.valueOf(s1.substring(i,i+1))];
            }
            list.add(Integer.valueOf(String.valueOf(st)));
            if(st.indexOf("6") != -1 || st.indexOf("9") != -1 || st.indexOf("5") != -1|| st.indexOf("2") != -1){
                if(st.indexOf("6") != -1){
                    list.add(Integer.valueOf(st.replace("6", "9")));
                }
                if(st.indexOf("9") != -1){
                    list.add(Integer.valueOf(st.replace("9", "6")));
                }
                if(st.indexOf("5") != -1){
                    list.add(Integer.valueOf(st.replace("5", "2")));
                }
                if(st.indexOf("2") != -1){
                    list.add(Integer.valueOf(st.replace("2", "5")));
                }
            }
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        max = max > list.size() ? list.size() - 1 : max - 1;
        return list.get(max);
    }

}
