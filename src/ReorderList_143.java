import java.util.ArrayList;
import java.util.List;

/**
 * 143. 重排链表
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * <p>
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 * <p>
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 示例 1：
 * <p>
 * 输入：head = [1,2,3,4]
 * 输出：[1,4,2,3]
 *  <p>
 * 提示：
 * <p>
 * 链表的长度范围为 [1, 5 * 104]
 * 1 <= node.val <= 1000
 */
public class ReorderList_143 {
    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            list.add(temp);
            temp = temp.next;
        }

        int left = 0;
        int right = list.size() - 1;

        while (left < right) {
            list.get(left).next = list.get(right);
            if (right - 1 < left + 1) {
                list.get(right).next = null;
            } else if (right - 1 == left + 1){
                list.get(right).next = list.get(left + 1);
                list.get(left + 1).next = null;
                break;
            } else {
                list.get(right).next = list.get(left + 1);
            }
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ReorderList_143 h = new ReorderList_143();
        h.reorderList(l1);
    }
}
