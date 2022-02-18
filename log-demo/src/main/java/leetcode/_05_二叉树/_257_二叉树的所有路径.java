package leetcode._05_二叉树;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author pppppp
 * @date 2022/2/18 10:24
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 */
public class _257_二叉树的所有路径 {

    @Test
    public void T_() {
        Integer[] nums = {1, 2, 3, null, 5};
        TreeNode root = Util.arrToTree(nums);
        System.out.println(binaryTreePaths(root));

    }

    /*层序遍历--每个节点带有一个String*/
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<NodeT> q = new LinkedList<>();
        q.offer(new NodeT(root, "" + root.val));
        List<String> res = new ArrayList<>();
        while (!q.isEmpty()) {
            NodeT p = q.poll();
            if (p.treeNode.left == null && p.treeNode.right == null) {
                res.add(p.list);
                continue;
            }

            if (p.treeNode.left != null) {
                q.offer(new NodeT(p.treeNode.left, p.list + "->" + p.treeNode.left.val));
            }

            if (p.treeNode.right != null) {
                q.offer(new NodeT(p.treeNode.right, p.list + "->" + p.treeNode.right.val));
            }
        }
        return res;
    }
}

class NodeT {
    public TreeNode treeNode;
    public String list;

    NodeT(TreeNode treeNode, String list) {
        this.list = list;
        this.treeNode = treeNode;
    }
}
