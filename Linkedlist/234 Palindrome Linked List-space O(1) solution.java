/**
 * 又忘了，好像每个文件只能有一个public class，就是跟文件的同名类
 * 当然没有这个public class也没关系
 * 这道题又涉及到reverse一个LinkedList的问题
 * reverse至少需要三个指针：prev，curr，next
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        // find the total number of the list
        int counter = 0;
        ListNode tail = head;
        while (tail.next != null) {
            counter++;
            tail = tail.next;
        }
        counter++;
        int mid = (counter % 2 == 0) ? counter/2 : (counter+1)/2;

        // find the middle node
        ListNode midNode = head;
        for (int i = 1; i < mid; i++) {
            midNode = midNode.next;
        }

        // reverse the list after the middle node
        ListNode prev = midNode;
        ListNode curr = prev.next;
        ListNode next;
        // 这里用curr是不是null作循环的判定条件
        // 而且只有curr不是null，才能给next赋值
        while (curr != null) {
            // Because curr is not null, so be able to assign curr.next to next
            next = curr.next;
            // Since we have stored curr.next in next, be able to modify curr.next now
            curr.next = prev;
            // Forward the references
            prev = curr;
            curr = next;
        }

        // determine if it's a palindrome
        boolean result = true;
        ListNode itrLeft = head;
        ListNode itrRight = tail;
        while (itrRight != midNode) {
            if (itrRight.val != itrLeft.val) {
                result = false;
                break;
            }
            itrLeft = itrLeft.next;
            itrRight = itrRight.next;
        }

        // recover the list
        if (counter > 1) {
            curr = prev.next;
            while (curr != midNode) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
        }
        return result;
    }
}