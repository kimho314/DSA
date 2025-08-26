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
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                node.next = list1;
                list1 = list1.next;
            } else {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }

        if (list1 != null) {
            node.next = list1;
        } else {
            node.next = list2;
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
        while (node != null) {
            int val = node.val;
            System.out.println(val);
            node = node.next;
        }
    }
}
