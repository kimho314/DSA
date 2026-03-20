public class MergeTwoSortedLinkedLists {
    private static class ListNode {
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
        MergeTwoSortedLinkedLists sol = new MergeTwoSortedLinkedLists();
        sol.print(sol.mergeTwoLists(sol.create(new int[] {1, 2, 4}),
                sol.create(new int[] {1, 3, 5})));
        sol.print(sol.mergeTwoLists(sol.create(null), sol.create(new int[] {1, 2})));
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 != null) {
            cur.next = list1;
        } else {
            cur.next = list2;
        }

        return dummy.next;
    }

    private ListNode create(int[] arr) {
        if (arr == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        for (int elem : arr) {
            ListNode node = new ListNode(elem);
            head.next = node;
            head = head.next;
        }

        return dummy.next;
    }

    private void print(ListNode list) {
        ListNode node = list;
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            int val = node.val;
            sb.append(val).append(" ");
            node = node.next;
        }
        IO.println(sb.toString());
    }
}
