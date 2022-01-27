package leetcode._05_二叉树;

import java.util.ArrayList;
import java.util.List;

/**
  @author pppppp
  @date 2022/1/27 9:54
  给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 */
public class _144_二叉树的前序遍历 {
    public static void main(String[] args){
        // TreeNode treeNode = new TreeNode(1, null, new TreeNode(2,new TreeNode(3,null,null),null));
        // TreeNode treeNode = new TreeNode(1,null,null);
        // TreeNode treeNode = new TreeNode(1,new TreeNode(2,null,null),null);
        TreeNode treeNode = new TreeNode(1,null,new TreeNode(2,null,null));
        List<Integer> integers = preorderTraversal(treeNode);
        System.out.println(integers.toString());
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        /*中间节点*/
        list.add(root.val);
        /*左子节点*/
        if(root.left != null){
            left = preorderTraversal(root.left);
        }
        if(root.right != null){
            right = preorderTraversal(root.right);
        }
        if(left.size()>0){
            list.addAll(left);
        }
        if(right.size()>0){
            list.addAll(right);
        }

        return list;
    }
}


