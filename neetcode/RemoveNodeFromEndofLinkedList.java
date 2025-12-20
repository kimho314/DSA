import java.util.*;

public class RemoveNodeFromEndofLinkedList {
    public class ListNode {
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
        RemoveNodeFromEndofLinkedList sol = new RemoveNodeFromEndofLinkedList();
        ListNode head = sol.create(new int[] {1, 2, 3, 4});
        ListNode node = sol.removeNthFromEnd3(head, 2);
        sol.print(node);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            nodes.add(cur);
            cur = cur.next;
        }

        int removeIdx = nodes.size() - n;
        if (removeIdx == 0) {
            return head.next;
        }

        nodes.get(removeIdx - 1).next = nodes.get(removeIdx).next;
        return head;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }

        int target = len - n;
        System.out.println(len + " " + target);
        if (target == 0) {
            return head.next;
        }

        cur = head;
        for (int i = 0; i < len; i++) {
            if (i + 1 == target) {
                cur.next = cur.next.next;
                break;
            }
            cur = cur.next;
        }
        return head;
    }

    public ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy;
        ListNode fast = head;
        while (n > 0) {
            fast = fast.next;
            n--;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }

    private void print(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
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
