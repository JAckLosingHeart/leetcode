/**
 * 学会了很重要的一点，如果序列化和反序列化树用DFS的话
 * 记得用先序遍历，因为反序列的时候很方便
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    public static void main (String args[]) {
        String str = "a,b,c,";
        // 果然split最后如果是个null的话，并不会加入数组
        String[] strArray = str.split(",");
        System.out.println(strArray.length);
        System.out.println(Arrays.toString(strArray));
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return recursiveSerialize(root, "");
    }
    private String recursiveSerialize(TreeNode root, String str) {
        if (root == null) {
            str += "null,";
        } else {
            str += root.val + ",";
            str = recursiveSerialize(root.left, str);
            str = recursiveSerialize(root.right, str);
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        List<String> dataList = new LinkedList<>(Arrays.asList(dataArray));
        return recursiveDeserialize(dataList);
    }
    private TreeNode recursiveDeserialize(List<String> dataList) {
        if (dataList.get(0).equals("null")) {
            dataList.remove(0);
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(dataList.get(0)));
        dataList.remove(0);
        node.left = recursiveDeserialize(dataList);
        node.right = recursiveDeserialize(dataList);
        return node;
    }
}