package neetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LowestCommonAncestor {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static void main() {
        LowestCommonAncestor sol = new LowestCommonAncestor();
        TreeNode root = sol.create(new Integer[]{5, 3, 8, 1, 4, 7, 9, null, 2});
        TreeNode res = sol.lowestCommonAncestor(root, new TreeNode(3), new TreeNode(8));
        IO.println(res != null ? res.val : null);

        root = sol.create(new Integer[]{5, 3, 8, 1, 4, 7, 9, null, 2});
        res = sol.lowestCommonAncestor(root, new TreeNode(3), new TreeNode(4));
        IO.println(res != null ? res.val : null);

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }

        if (Math.min(p.val, q.val) > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        else if (Math.max(p.val, q.val) < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        else {
            return root;
        }
    }

    private TreeNode create(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            TreeNode current = queue.poll();

            // Add left child
            if (i < arr.length && arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.offer(current.left);
            }
            i++;

            // Add right child
            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }
}
