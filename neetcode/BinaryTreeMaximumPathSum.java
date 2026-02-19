import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeMaximumPathSum {
    public static void main(String[] args) {
        BinaryTreeMaximumPathSum sol = new BinaryTreeMaximumPathSum();
        TreeNode root = sol.create(new Integer[] {1, 2, 3});
        int res = sol.maxPathSum(root);
        IO.println(res);

        root = sol.create(new Integer[] {-15, 10, 20, null, null, 15, 5, -5});
        res = sol.maxPathSum(root);
        IO.println(res);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
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

    private int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    private int getMax(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getMax(root.left);
        int right = getMax(root.right);
        int path = root.val + Math.max(left, right);
        return Math.max(0, path);
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        int left = getMax(root.left);
        int right = getMax(root.right);
        res = Math.max(res, root.val + left + right);
        dfs(root.left);
        dfs(root.right);
    }

    public int maxPathSum2(TreeNode root) {
        int[] res = new int[] {root.val};
        dfs2(root, res);
        return res[0];
    }

    private int dfs2(TreeNode root, int[] res) {
        if (root == null) {
            return 0;
        }

        int leftMax = Math.max(dfs2(root.left, res), 0);
        int rightMax = Math.max(dfs2(root.right, res), 0);

        res[0] = Math.max(res[0], root.val + leftMax + rightMax);
        return root.val + Math.max(leftMax, rightMax);
    }
}
