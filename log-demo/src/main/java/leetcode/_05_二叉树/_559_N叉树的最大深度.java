package leetcode._05_二叉树;

import java.util.List;

/**
 * @author pppppp
 * @date 2022/2/17 15:37
 */
public class _559_N叉树的最大深度 {
    public int maxDepth(Node root) {
        if(root == null){
            return 0;
        }
        List<Node> children = root.children;
        int max = 0;
        for (Node child : children) {
            max = Math.max(maxDepth(child),max);
        }
        return max+1;
    }
}
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};