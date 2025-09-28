import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeKSortedLinkedLists {
    public static void main(String[] args) {
        MergeKSortedLinkedLists sol = new MergeKSortedLinkedLists();
        ListNode root = sol.mergeKLists(sol.create(new Integer[][] {{1, 2, 4}, {1, 3, 5}, {3, 6}}));
        sol.print(root);
        root = sol.mergeKLists(sol.create(new Integer[][] {}));
        sol.print(root);
        root = sol.mergeKLists(sol.create(new Integer[][] {{}}));
        sol.print(root);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private void print(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    private ListNode[] create(Integer[][] arr) {
        if (arr == null) {
            return null;
        }
        ListNode[] res = new ListNode[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length == 0) {
                continue;
            }
            ListNode head = new ListNode(arr[i][0]);
            ListNode cur = head;
            for (int j = 1; j < arr[i].length; j++) {
                ListNode node = new ListNode(arr[i][j]);
                cur.next = node;
                cur = cur.next;
            }
            res[i] = head;
        }

        return res;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> nodes = new ArrayList<>();
        for (ListNode list : lists) {
            while (list != null) {
                nodes.add(list.val);
                list = list.next;
            }
        }

        Collections.sort(nodes);

        ListNode res = new ListNode(0);
        ListNode cur = res;
        for (int node : nodes) {
            cur.next = new ListNode(node);
            cur = cur.next;
        }
        return res.next;
    }
}
