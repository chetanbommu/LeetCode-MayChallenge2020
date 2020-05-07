package trees.v2;

import java.util.HashMap;

/** https://leetcode.com/problems/cousins-in-binary-tree/ */
public class CousinsInBinaryTree {

    HashMap<Integer, Integer> depthLookUp;
    HashMap<Integer, TreeNode> parentLookUp;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        CousinsInBinaryTree driver = new CousinsInBinaryTree();
        System.out.println("Is Cousins? " + driver.isCousins(root, 2, 3));
        System.out.println("Is Cousins? " + driver.isCousins(root, 4, 5));
    }

    /** Approach :
     * Generate data for Depth and Parent of each node.
     * Then check if depth of both the given nodes are same & parents are not same.
     *
     * LeetCode stats:
     * Runtime: 0 ms, faster than 100.00% of Java online submissions.
     * Memory Usage: 37.5 MB, less than 7.14% of Java online submissions.
     * */
    public boolean isCousins(TreeNode root, int x, int y) {
        depthLookUp = new HashMap<>();
        parentLookUp = new HashMap<>();
        dfs(root, null); /** Method to load data into depthLookUp & parentLookUp */
        return depthLookUp.get(x) == depthLookUp.get(y) &&
                parentLookUp.get(x) != parentLookUp.get(y);
    }

    public void dfs(TreeNode node, TreeNode parent) {
        if(node != null) {
            depthLookUp.put(node.val, parent == null ? 0 : depthLookUp.get(parent.val) + 1);
            parentLookUp.put(node.val, parent);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
