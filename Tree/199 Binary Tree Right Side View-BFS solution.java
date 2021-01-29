/**
 * Java里queue这个interface支持remove第一个，add到最后
 * 但是不支持直接用index取东西，如果要遍历变成数组再用index去遍历
 * 而且tm怎么不支持最简单的先进先出nmd
 *
 * 所以java queue是要用ArrayDeque是吗，比Linkedlist更快的工具
 * offer是在尾部加入一个
 * poll是把头部弹出
 */

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSide = new ArrayList<>();
        if (root == null) {
            return rightSide;
        }
        rightSide.add(root.val);

        Deque<TreeNode> currentLevel = new ArrayDeque<>();
        Deque<TreeNode> nextLevel = new ArrayDeque<>();
        nextLevel.offer(root);
        do {
            currentLevel.addAll(nextLevel);
            nextLevel.clear();
            while (!currentLevel.isEmpty()) {
                TreeNode currNode = currentLevel.poll();
                // 记住不要往函数里面传null引用，否则你不知道函数里会发生什么
                if (currNode.left != null)
                    nextLevel.offer(currNode.left);
                if (currNode.right != null)
                    nextLevel.offer(currNode.right);
            }
            if (!nextLevel.isEmpty()) {
                rightSide.add(nextLevel.peekLast().val);
            }
        } while (!nextLevel.isEmpty());
        return rightSide;
    }
}