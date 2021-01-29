import java.util.ArrayList;
import java.util.List;

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
    List<Integer> rightSide = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return rightSide;
        }
        recursive(root, 0);
        return rightSide;
    }

    private void recursive(TreeNode root, int level) {
        if (level == rightSide.size()) {
            rightSide.add(root.val);
        }
        if (root.right != null) {
            recursive(root.right, level+1);
        }
        if (root.left != null) {
            recursive(root.left, level+1);
        }
    }
}