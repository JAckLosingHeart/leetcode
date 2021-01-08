/**
 * 这道题写的很爽，之所以说爽是因为体会到循环结构的安排也是有门道的，而且写的时候一气呵成
 * 常常通过将一段代码移进移出循环，或者改变循环结束条件可以使得整个循环结构更好
 * 还有几个写循环时需要注意的地方见下方注释
 */

import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 因为知道l1,l2各至少有一个节点，所以可以直接建新node
        ListNode result = new ListNode();
        int sum = l1.val + l2.val;
        result.val = sum % 10;
        int carry = sum / 10;

        l1 = l1.next;
        l2 = l2.next;

        ListNode itr = result;
        while (l1 != null && l2 != null) {
            // 如果需要循环建立新的节点， 那么一定要注意，先验条件再建node，这是原则
            // 不要让代码在确定需要新node之前就建立node
            itr.next = new ListNode();
            itr = itr.next;
            sum = l1.val + l2.val + carry;
            itr.val = sum % 10;
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        /**
         * 这里很重要的一点是：
         * 在遍历链表的时候，要保证itr.next != null再itr = itr.next
         * 否则如果先itr = itr.next，就会导致itr.next一旦是null，你已经过了最后一个非空节点
         */
        if (l1 != null) {
            itr.next = l1;
            do {
                itr = itr.next;
                sum = itr.val + carry;
                itr.val = sum % 10;
                carry = sum / 10;
            } while (itr.next != null && carry > 0);
            if (carry > 0) {
                itr.next = new ListNode(carry);
            }
        } else if (l2 != null) {
            itr.next = l2;
            do {
                itr = itr.next;
                sum = itr.val + carry;
                itr.val = sum % 10;
                carry = sum / 10;
            } while (itr.next != null && carry > 0);
            if (carry > 0) {
                itr.next = new ListNode(carry);
            }
        } else {
            if (carry > 0) {
                itr.next = new ListNode(carry);
            }
        }
        return result;
    }
}