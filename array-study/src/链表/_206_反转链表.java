package 链表;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class _206_反转链表 {

    public ListNode reverseList(ListNode head) {
        // 传入head，返回新head
        // 递归和非递归

        // 0或者1个节点
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;

    }


    public ListNode reverseList2(ListNode head) {
        // 传入head，返回新head
        // 递归和非递归

        // 0或者1个节点
        if (head == null || head.next == null) return head;

        ListNode newHead = null;
        ListNode temp = null;

        while (true) {
            temp = head.next.next;
            newHead = head.next;
            head.next = head;
            if (temp == null) {
                break;
            }
        }
        return newHead;

    }

}
