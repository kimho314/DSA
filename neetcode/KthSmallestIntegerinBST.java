import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KthSmallestIntegerinBST {
    public static void main(String[] args) {
        KthSmallestIntegerinBST sol = new KthSmallestIntegerinBST();
        TreeNode root = sol.create(new Integer[] {2, 1, 3});
        int res = sol.kthSmallest(root, 1);
        System.out.println(res);

        root = sol.create(new Integer[] {4, 3, 5, 2, null});
        res = sol.kthSmallest(root, 4);
        System.out.println(res);
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

    public int kthSmallest(TreeNode root, int k) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            q.add(root);
            list.add(root.val);
        }

        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            if (n.left != null) {
                q.add(n.left);
                list.add(n.left.val);
            }
            if (n.right != null) {
                q.add(n.right);
                list.add(n.right.val);
            }
        }

        Collections.sort(list);
        int idx = 1;
        for (Integer elem : list) {
            if (idx == k) {
                return elem;
            }
            idx++;
        }
        return -1;
    }

    public int kthSmallest2(TreeNode root, int k) {
        List<Integer> arr = new ArrayList<>();

        dfs(root, arr);

        return arr.get(k - 1);
    }

    private void dfs(TreeNode node, List<Integer> arr) {
        if (node == null) {
            return;
        }

        dfs(node.left, arr);
        arr.add(node.val);
        dfs(node.right, arr);
    }
}
