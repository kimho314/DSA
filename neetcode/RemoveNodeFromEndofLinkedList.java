package neetcode;

import java.util.ArrayList;
import java.util.List;

public class RemoveNodeFromEndofLinkedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    static void main(String[] args) {
        RemoveNodeFromEndofLinkedList sol = new RemoveNodeFromEndofLinkedList();
        ListNode head = sol.create(new int[]{1, 2, 3, 4});
        ListNode node = sol.removeNthFromEnd2(head, 2);
        sol.print(node);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            nodes.add(cur);
            cur = cur.next;
        }

        int target = nodes.size() - n;
        if (target == 0) {
            return head.next;
        }
        nodes.get(target - 1).next = nodes.get(target).next;
        return head;
    }


    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode left = dummy;
        ListNode right = head;
        while (n > 0) {
            right = right.next;
            n--;
        }

        while (right != null) {
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;
        return dummy.next;
    }

    private void print(ListNode head) {
        ListNode cur = head;
        StringBuilder sb = new StringBuilder();
        while (cur != null) {
            sb.append(cur.val).append(" ");
            cur = cur.next;
        }
        sb.append("\n");
        IO.println(sb.toString());
    }

    private ListNode create(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            cur.next = node;
            cur = cur.next;
        }

        return head;
    }
}
