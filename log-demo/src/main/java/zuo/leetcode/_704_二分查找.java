package zuo.leetcode;

/**
 * @author pppppp
 * @date 2022/1/13 22:31
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 */
public class _704_二分查找 {

    public static void main(String[] args) {
        // int[] nums = {-1, 0, 3, 5, 9, 12};
        int[] nums = {2,5};
        int target = 7;
        // int target = 9;
        int search = search(nums, target);
        System.out.println(search);
    }

    public static int search(int[] nums, int target) {
        if(nums[0] == target){
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

        return nums[L] == target ? L :-1;
    }

    public static int search0(int[] nums, int target) {
        if(nums[0] == target){
            return 0;
        }else if(nums[nums.length-1] == target){
            return nums.length-1;
        }
        int start = 0;
        int end = nums.length-1;

        return getIndex(start,end,nums,target);

    }

    private static int getIndex(int start, int end, int[] nums,int target) {
        int mid = start + ((end-start)>> 1);
        /*到达边界 停止*/
        if(mid == 0 || mid == nums.length-1){
            if(nums[start] == target){
                return start;
            }

            if(nums[end] == target){
                return end;
            }
            return -1;
        }else {
            if (nums[mid] > target) {
                end = mid-1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return getIndex(start, end, nums,target);
    }
}
