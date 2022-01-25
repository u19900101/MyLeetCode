package leetcode._04_字符串;

/**
 * @author pppppp
 * @date 2022/1/25 16:34
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 * <p>
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * <p>
 * 示例 1：
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 * 示例 2：
 * <p>
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 */
public class _541_反转字符串II {
    public static void main(String[] args) {
        String[] s = {"abcdefghi", "abcd", "abcd"};
        String[] r = {"bacdfeg", "bacd","dcba"};
        int[] k = {3,2,4};
        for (int i = 0; i < s.length; i++) {
            System.out.println(reverseStr(s[i], k[i]).equals(r[i]));
        }
    }

    public static String reverseStr(String s, int k) {
        int sIndex = 0;
        StringBuilder sb = new StringBuilder(s);
        if(s.length() <=k){
            return sb.reverse().toString();
        }
        while (sIndex  < s.length()) {
            int to  = sIndex + k-1;
            if(sIndex + k > s.length()){
                to = s.length()-1;
            }
            for (int i = to,j = sIndex; i >= sIndex; i--,j++) {
                sb.setCharAt(j, s.charAt(i));
            }
            sIndex += k*2;
        }
        return sb.toString();
    }

    public String reverseStr2(String s, int k) {
        int n = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; i += 2 * k) {
            reverse(arr, i, Math.min(i + k, n) - 1);
        }
        return new String(arr);
    }

    public void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
