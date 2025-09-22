package to100.to10;

class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode();
        ListNode currentNode = null;
        int currentSum = 0;

        boolean finished = false;

        while (!finished) {
            if (l1 == null && l2 == null) {
                finished = true;
            } else {
                if (currentNode == null) {
                    currentNode = sum;
                } else {
                    ListNode newNode = new ListNode();
                    currentNode.next = newNode;
                    currentNode = newNode;
                }

                if (l1 != null) {
                    currentSum += l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    currentSum += l2.val;
                    l2 = l2.next;
                }

                if (currentSum > 9) {
                    currentNode.val = currentSum - 10;
                    currentSum = 1;
                } else {
                    currentNode.val = currentSum;
                    currentSum = 0;
                }

            }
        }
        if (currentSum > 0) {
            ListNode newNode = new ListNode();
            currentNode.next = newNode;
            currentNode = newNode;
            currentNode.val = currentSum;
        }
        return sum;
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
