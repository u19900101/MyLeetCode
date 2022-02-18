package leetcode._05_二叉树;

import org.junit.Test;

/**
 * @author pppppp
 * @date 2022/2/17 16:25
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 * <p>
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 * 输入：root = [1,2,3,4,5,6]
 * 输出：6
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：root = [1]
 * 输出：1
 */
public class _222_完全二叉树的节点个数 {

    /*直接递归--不使用完全二叉树的性质*/
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    @Test
    public void T_() {
        Integer[] nums = {1, 2, 3, 4, 5, 6};
        TreeNode treeNode = Util.arrToTree(nums);
        int i = countNodes2(treeNode);
        System.out.println(i);
    }

    /*二分查找 + 位运算*/
    public int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = 0;
        TreeNode node = root;
        while (node.left != null) {
            level++;
            node = node.left;
        }
        int low = 1 << level, high = (1 << (level + 1)) - 1;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (exists(root, level, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public boolean exists(TreeNode root, int level, int k) {
        int bits = 1 << (level - 1);
        TreeNode node = root;
        while (node != null && bits > 0) {
            if ((bits & k) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            bits >>= 1;
        }
        return node != null;
    }

    @Test
    public void T_bits() {
        int bits = 2, k = 8;
        while (bits > 0) {
            if ((bits & k) == 0) {
                System.out.println("l");
            } else {
                System.out.println("r");
            }
            bits >>= 1;
        }
    }

    //获取 整数 num 的第 i 位的值
    /*
    1 左移 i 位后，得到一个数，这个数只有第 i 位为1，其它位都为0
    num 与这个数相与，得到的结果 要么是0，要么非0。
    结果为 非0 表示第 i 位为1，结果为0 表示第 i 位为0*/
    private static int getBit(int num, int i) {
        while (num > 1) {
            System.out.println(num & 1);
            num >>= 1;
        }
        return num & (1 << i);
    }


    /*将自然数转为2进制数的字符串*/
    public String toBinaryString( int num) {
        if(num == 0){
            return "0";
        }
        StringBuilder s = new StringBuilder();
        while (num > 0) {
            /*和1进行 & 操作，可以获取最低为的数值*/
            // System.out.println(num & 1);
            s.insert(0,(num&1));
            num >>= 1;
        }
        return s.toString();
    }
    @Test
    public void T_kk(){
        for (int i = 0; i < 10; i++) {
            System.out.println(Integer.toBinaryString(i) + "---" + toBinaryString(i));
        }

    }
}
