package neetcode;

import java.util.LinkedList;
import java.util.Queue;

public class BalancedBinaryTree {
    public static void main(String[] args) {
        BalancedBinaryTree sol = new BalancedBinaryTree();
        TreeNode root = sol.create(new Integer[]{1, 2, 3, null, null, 4});
        System.out.println(sol.isBalanced(root));
        root = sol.create(new Integer[]{1, 2, 3, null, null, 4, null, 5});
        System.out.println(sol.isBalanced(root));
        root = sol.create(new Integer[]{});
        System.out.println(sol.isBalanced(root));
        root = sol.create(new Integer[]{1, 2, 2, 3, null, null, 3, 4, null, null, 4});
        System.out.println(sol.isBalanced(root));
    }

    public static class TreeNode {
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

    public boolean isBalanced2(TreeNode root) {
        return dfs(root)[0] == 1;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{1, 0};
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        boolean balanced = (left[0] == 1 && right[0] == 1) && (Math.abs(left[1] - right[1]) <= 1);
        int height = 1 + Math.max(left[1], right[1]);

        return new int[]{balanced ? 1 : 0, height};
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int maxLeft = maxHeight(root.left);
        int maxRight = maxHeight(root.right);
        boolean res1 = Math.abs(maxLeft - maxRight) <= 1;
        boolean res2 = isBalanced(root.left);
        boolean res3 = isBalanced(root.right);

        return res1 && res2 && res3;
    }

    private int maxHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxHeight(root.right), maxHeight(root.left));
    }

    private void print(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        System.out.println();
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
