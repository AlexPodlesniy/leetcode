package to200.to150;

class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(true) {
            try {
                slow = slow.next;
                fast = fast.next;
                fast = fast.next;
                if (slow == fast) {
                    return true;
                }
            } catch (NullPointerException e) {
                return false;
            }
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
