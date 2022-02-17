package leetcode._05_二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author pppppp
 * @date 2022/2/17 14:13
 */
public class Util {

    public static void main(String[] args){
        // Integer[] arr = {3,9,20,null,null,15,7};
        Integer[] arr = {1,2,3};
        TreeNode treeNode = arrToTree(arr);
        System.out.println();
    }
    public static TreeNode arrToTree(Integer[] arr) {
        if (arr.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(arr[0]);
        int i = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (i < arr.length) {
            TreeNode poll = queue.poll();
            if(arr[i] == null){
                i++;
            }else {
                poll.left = new TreeNode(arr[i++]);
                queue.offer(poll.left);
            }

            if (i < arr.length) {
                if(arr[i] == null){
                    i++;
                }else {
                    poll.right = new TreeNode(arr[i++]);
                    queue.offer(poll.right);
                }
            }
        }
        return root;
    }
}
