public class ReverseNodesInKGroup {
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
        ReverseNodesInKGroup sol = new ReverseNodesInKGroup();
        ListNode input = sol.arrayToListNode(new int[] {1, 2, 3, 4, 5});
        ListNode res = sol.reverseKGroup(input, 3);
        sol.print(res);
        input = sol.arrayToListNode(new int[] {1, 2, 3, 4, 5, 6});
        res = sol.reverseKGroup(input, 3);
        sol.print(res);
    }

    private void print(ListNode node) {
        ListNode cur = node;
        StringBuilder sb = new StringBuilder();
        while (cur != null) {
            sb.append(cur.val).append(" ");
            cur = cur.next;
        }
        // sb.append("\n");
        IO.println(sb.toString());
    }

    private ListNode arrayToListNode(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int elem : arr) {
            ListNode node = new ListNode(elem);
            cur.next = node;
            cur = cur.next;
        }
        return dummy.next;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode groupPrev = dummy;

        while (true) {
            ListNode kth = getKth(groupPrev, k);
            if (kth == null) {
                break;
            }
            ListNode groupNext = kth.next;

            ListNode prev = kth.next;
            ListNode curr = groupPrev.next;
            while (curr != groupNext) {
                ListNode tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }

            ListNode tmp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = tmp;
        }
        return dummy.next;
    }

    private ListNode getKth(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }
}
