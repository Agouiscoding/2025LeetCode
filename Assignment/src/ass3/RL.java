package ass3;



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;

        // 1) 找中点（slow 指向中点或左中点）
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2) 反转后半段：从 slow.next 开始
        ListNode head2 = reverse(slow.next);
        slow.next = null; // 断开，形成两条链：head 和 head2

        // 3) 交替合并两条链：head 与 head2
        ListNode p1 = head, p2 = head2;
        while (p2 != null) {
            ListNode n1 = p1.next;
            ListNode n2 = p2.next;

            p1.next = p2;
            p2.next = n1;

            p1 = n1;
            p2 = n2;
        }
    }

    // 迭代反转链表，返回新头
    private ListNode reverse(ListNode head) {
        ListNode prev = null, cur = head;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
        }
        return prev;
    }
}
