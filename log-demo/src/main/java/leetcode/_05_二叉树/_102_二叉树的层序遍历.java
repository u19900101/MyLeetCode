package leetcode._05_二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author pppppp
 * @date 2022/1/27 10:52
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 */
public class _102_二叉树的层序遍历 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        List<List<Integer>> lists = levelOrder(treeNode);
        System.out.println(lists.toString());
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> curQ = new LinkedList<>();
        curQ.offer(root);
        while (!curQ.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            Queue<TreeNode> nextQ = new LinkedList<>();
            while (!curQ.isEmpty()) {
                root = curQ.poll();
                temp.add(root.val);
                if (root.left != null) {
                    nextQ.offer(root.left);
                }
                if (root.right != null) {
                    nextQ.offer(root.right);
                }
            }
            curQ = nextQ;
            res.add(temp);
        }
        return res;
    }
}
