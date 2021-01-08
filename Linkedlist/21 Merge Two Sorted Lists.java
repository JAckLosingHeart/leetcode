
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode result = new ListNode();
        ListNode itr = result;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                itr.val = l1.val;
                l1 = l1.next;
            } else {
                itr.val = l2.val;
                l2 = l2.next;
            }
            itr.next = new ListNode();
            itr = itr.next;
        }
        // 这才让我回忆起来归并排序合并时，不可能两个数列同时到头
        // 由于while循环结束条件的限制，总是一个结束了，一个未结束
        if (l1 != null) {
            itr.val = l1.val;
            itr.next = l1.next;
        }
        if (l2 != null) {
            itr.val = l2.val;
            itr.next = l2.next;
        }
        return result;
    }
}