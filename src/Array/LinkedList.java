package Array;

/**
 * Created by 431 on 2014/12/11.
 */
public class LinkedList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int temp;
        ListNode aft = head;
        ListNode pre = head.next;
        while (pre != null) {
            temp = aft.val;
            aft.val = pre.val;
            pre.val = temp;
            if (pre.next != null && pre.next.next != null) {
                pre = pre.next.next;
                aft = aft.next.next;
            } else {
                break;
            }
        }
        return head;
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head;
        while (head != null) {

            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(9);
        listNode.next.next = new ListNode(5);
        listNode.next.next.next = new ListNode(3);
        ListNode node = sortList(listNode);
        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.print("null");
    }
}


