package to300.to210;

class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        return reverse(head, null);
    }

    private ListNode reverse(ListNode head, ListNode reversedHead) {
        if (head == null) {
            return reversedHead;
        } else {
            if (reversedHead == null) {
                reversedHead = new ListNode(head.val);
            } else {
                ListNode newNode = new ListNode(head.val);
                newNode.next = reversedHead;
                reversedHead = newNode;
            }
            head = head.next;
            return reverse(head, reversedHead);
        }
    }


    public static class ListNode {
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
}
