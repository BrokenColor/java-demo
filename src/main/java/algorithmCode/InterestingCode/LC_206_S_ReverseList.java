package algorithmCode.InterestingCode;

import algorithmCode.InterestingCode.entity.ListNode;

/**
 * 206.反转链表
 *
 * @Author bc
 * @Date 2023/3/12 16:48
 */
public class LC_206_S_ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, curr = head, next;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}
