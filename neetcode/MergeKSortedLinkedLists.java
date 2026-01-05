import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLinkedLists {
    public static void main(String[] args) {
        MergeKSortedLinkedLists sol = new MergeKSortedLinkedLists();
        ListNode root =
                sol.mergeKLists2(sol.create(new Integer[][] {{1, 2, 4}, {1, 3, 5}, {3, 6}}));
        sol.print(root);
        root = sol.mergeKLists2(sol.create(new Integer[][] {}));
        sol.print(root);
        root = sol.mergeKLists2(sol.create(new Integer[][] {{}}));
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

    private static class Pair implements Comparable<Pair> {
        public int val;
        public int listIdx;
        public ListNode curNode;

        public Pair(int val, int listIdx, ListNode node) {
            this.val = val;
            this.listIdx = listIdx;
            this.curNode = node;
        }

        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.val, other.val);
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        int len = lists.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < len; i++) {
            pq.offer(new Pair(lists[i].val, i, lists[i]));
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            cur.next = p.curNode;
            cur = cur.next;
            ListNode next = p.curNode.next;
            if (next != null) {
                pq.offer(new Pair(next.val, p.listIdx, next));
            }

        }

        return dummy.next;
    }

    public ListNode mergeKLists3(ListNode[] lists) {
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

    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        while (lists.length > 1) {
            List<ListNode> mergedLists = new ArrayList<>();
            for (int i = 0; i < lists.length; i += 2) {
                ListNode l1 = lists[i];
                ListNode l2 = (i + 1) < lists.length ? lists[i + 1] : null;

                mergedLists.add(merge(l1, l2));
            }
            lists = mergedLists.toArray(new ListNode[0]);
        }

        return lists[0];
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }

            cur = cur.next;
        }

        if (l1 != null) {
            cur.next = l1;
        } else {
            cur.next = l2;
        }

        return dummy.next;
    }
}
