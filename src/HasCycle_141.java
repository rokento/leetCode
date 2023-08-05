import java.util.ArrayList;
import java.util.List;

/**
 * 141. 环形链表
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 * <p>
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 * 提示：
 * <p>
 * 链表中节点的数目范围是 [0, 104]
 * -105 <= Node.val <= 105
 * pos 为 -1 或者链表中的一个 有效索引 。
 */

public class HasCycle_141 {

    /**
     * 解法1：通过记录hashCode判断是否存在重复的元素
     * 时间复杂度，空间复杂度为O（n）,n为链表长度
     */
    public boolean hasCycle(ListNode head) {
        if(head == null) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while (temp.next != null) {
            if (list.contains(temp.hashCode())) {
                return true;
            } else {
                list.add(temp.hashCode());
                temp = temp.next;
            }
        }
        return false;
    }

    /**
     * 解法2：快慢指针，快指针每次循环移动2步，慢指针每次移动1步
     * 如果有环快指针在第二圈会追上慢指针，
     * 如果没环，快指针会先到达底部
     * 时间复杂度O(N)
     * 空间复杂度O(1)
     */
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) { // 不相等继续循环
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(-4);
        l4.next = l2;
        l3.next = l4;
        l2.next = l3;
        l1.next = l2;

        HasCycle_141 h = new HasCycle_141();
        System.out.println(h.hasCycle2(l1));
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}