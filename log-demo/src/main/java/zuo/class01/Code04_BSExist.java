package zuo.class01;

public class Code04_BSExist {

	public static void main(String[] args) {
		int[] nums = {-1, 0, 3, 5, 9, 12};
		int target = 12;
		boolean search = exist(nums, target);
		System.out.println(search);
	}

	public static boolean exist(int[] sortedArr, int num) {
		if (sortedArr == null || sortedArr.length == 0) {
			return false;
		}
		int L = 0;
		int R = sortedArr.length - 1;
		int mid = 0;
		while (L < R) {
			mid = L + ((R - L) >> 1);
			if (sortedArr[mid] == num) {
				return true;
			} else if (sortedArr[mid] > num) {
				R = mid - 1;
			} else {
				L = mid + 1;
			}
		}
		return sortedArr[L] == num;
	}

}
