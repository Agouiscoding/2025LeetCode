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



class PL {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        // 1) 快慢指针找中点
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 若为奇数长度，slow 在正中间，跳过中间节点
        if (fast != null) slow = slow.next;

        // 2) 反转后半段
        ListNode second = reverse(slow);

        // 3) 前半与后半（已反转）逐一比较
        ListNode p1 = head, p2 = second;
        boolean ok = true;
        while (p2 != null) {
            if (p1.val != p2.val) {
                ok = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // 4)（可选）恢复链表：reverse(second);
        // reverse(second);

        return ok;
    }

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
