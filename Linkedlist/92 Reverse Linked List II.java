class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Maintain a counter during the whole traversal
        int counter = 1;
        ListNode itr = head;
        // Store the (M-1)th node
        // Since we need to change Node(m-1).next to the new first node in the sublist
        ListNode nodeBeforeM;
        // Store the (M)th node
        // Since we need to change Node(m).next to Node(n+1)
        ListNode nodeM;
        if (m == 1) {
            // If the sublist starts from the 1th node
            nodeBeforeM = null;
            nodeM = head;
        } else {
            // Otherwise
            while (counter < m - 1) {
                itr = itr.next;
                counter++;
            }
            nodeBeforeM = itr;
            nodeM = itr.next;
            itr = nodeM;
            counter++;
        }

        // Reverse the target sublist
        ListNode curr = itr.next;
        ListNode next;
        while (counter < n) {
            next = curr.next;
            curr.next = itr;
            itr = curr;
            counter++;
            curr = next;
        }

        // Correct the boundaries of the reversed sublist
        if (nodeBeforeM != null) {
            nodeBeforeM.next = itr;
        } else {
            head = itr;
        }
        nodeM.next = curr;

        return head;
    }
}