package leetcode._01_binary_search;

/**
 * @author pppppp
 * @date 2022/1/14 8:26
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。
 * 由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 * <p>
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 * <p>
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。
 * 实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 */
public class _278_第一个错误的版本 {
    public static void main(String[] args) {
        int n = 5;
        int bad = 4;

        /*if(nums[0] == target){
            return 0;
        }else if(nums[nums.length-1] == target){
            return nums.length-1;
        }
        int L = 0;
        int R = nums.length-1;
        while (L < R){
            int mid = L + ((R-L)>> 1);
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                R = mid-1;
            }else {
                L = mid+1;//当L + 1 = R 时，L退化为R
            }
        }
        // if(nums[R] == target){
        //     return R;
        // }

        return nums[L] == target ? L :-1;*/
    }

    public int firstBadVersion(int n) {
        return -1;
    }

    boolean isBadVersion(int version){
        return false;
    }
}
