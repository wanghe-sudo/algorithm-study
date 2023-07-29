package 链表;

/**
 * 判断链表是否有环
 * 使用快慢指针，判断是否有环（肉眼看到的环，程序无法知晓）
 */
public class _141_环形链表 {
    public boolean asCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast == null || fast.next == null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }
}
