package leetcode;

import java.util.*;
import java.io.*;

public class LCD23 {
    private class ListNode {
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

    public static void main(String[] args) {
        LCD23 sol = new LCD23();
        ListNode[] lists = sol.toLinkedList(new int[][] {{1, 4, 5}, {1, 3, 4}, {2, 6}});
        ListNode res = sol.mergeKLists(lists);
        sol.print(res); // [1,1,2,3,4,4,5,6]

        lists = sol.toLinkedList(new int[][] {});
        res = sol.mergeKLists(lists);
        sol.print(res); // [1,1,2,3,4,4,5,6]

        lists = sol.toLinkedList(new int[][] {{}});
        res = sol.mergeKLists(lists);
        sol.print(res); // [1,1,2,3,4,4,5,6]

    }

    private class Pair implements Comparable<Pair> {
        public int value;
        public int listIdx;
        public ListNode node;

        public Pair(int value, int listIdx, ListNode node) {
            this.value = value;
            this.listIdx = listIdx;
            this.node = node;
        }

        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.value, other.value);
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.offer(new Pair(lists[i].val, i, lists[i]));
            }
        }

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            cur.next = p.node;

            ListNode next = p.node.next;
            if (next != null) {
                pq.offer(new Pair(next.val, p.listIdx, next));
            }
            cur = cur.next;
        }

        return dummy.next;
    }

    private ListNode[] toLinkedList(int[][] arr) {
        ListNode[] res = new ListNode[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ListNode dummy = new ListNode(0);
            ListNode cur = dummy;
            for (int j = 0; j < arr[i].length; j++) {
                cur.next = new ListNode(arr[i][j]);
                cur = cur.next;
            }
            res[i] = dummy.next;
        }
        return res;
    }

    private void print(ListNode[] lists) {
        StringBuilder sb = new StringBuilder();
        for (ListNode elem : lists) {
            ListNode cur = elem;
            while (cur != null) {
                sb.append(cur.val).append(" ");
                cur = cur.next;
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private void print(ListNode node) {
        StringBuilder sb = new StringBuilder();
        ListNode cur = node;
        while (cur != null) {
            sb.append(cur.val).append(" ");
            cur = cur.next;
        }
        System.out.println(sb.toString());
    }
}
