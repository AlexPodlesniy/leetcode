package to100.to30;

import java.util.PriorityQueue;
import java.util.Queue;

class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode result = null;
        ListNode currentNode = null;
        Queue<ListNode> heap = new PriorityQueue<>(lists.length,
                (l1, l2) -> Integer.compare(l1.val, l2.val));

        for (int k = 0; k < lists.length; k++) {
            if (lists[k] != null) {
                heap.add(lists[k]);
            }
        }
        while(heap.peek() != null) {
            ListNode currentMin = heap.poll();
            ListNode newNode = new ListNode(currentMin.val);
            if (result == null) {
                result = newNode;
            } else {
                currentNode.next = newNode;
            }
            currentNode = newNode;
            if (currentMin.next != null) {
                heap.add(currentMin.next);
            }
        }
        return result;
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
