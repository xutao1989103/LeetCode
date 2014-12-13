package Array;

import java.util.ArrayList;
import java.util.List;

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

    public static ListNode rotateRight(ListNode head, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode pre = temp;
        ListNode aft = temp;
        int i;
        for (i = 0; pre.next != null; i++) {
            pre = pre.next;
        }
        for (int j = i - (n % i); j > 0; j--) {
            aft = aft.next;
        }
        pre.next = head;
        head = aft.next;
        aft.next = null;
        return head;
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n) return head;
        ListNode p = new ListNode(0);
        ListNode p1 = new ListNode(0);
        p.next = head;
        p1 = p;
        for (int i = 1; i < m; i++) {
            p = p.next;
        }
        ListNode p3 = p.next;
        for (int i = m; i < n; i++) {
            ListNode temp = p3.next.next;
            p3.next.next=p.next;
            p.next=p3.next;
            p3.next=temp;
        }
        return p1.next;
    }

    public static void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        List<ListNode> arrayNode=new ArrayList<ListNode>();
        for(ListNode node=head;node!=null;node=node.next) arrayNode.add(node);
        int i=0;
        int j=arrayNode.size()-1;
        for(;i<j;i++,j--){
            arrayNode.get(i).next=arrayNode.get(j);
            arrayNode.get(j).next=arrayNode.get(i+1);
        }
        arrayNode.get(i).next=null;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;
        ListNode root=new ListNode(0);
        root.next=head;
        ListNode pre=root;
        ListNode aft=root;
        int i=0;
        while (pre.next!=null){
            if(i>=n){
                aft=aft.next;
            }
            i++;
            pre=pre.next;
        }
        aft.next=aft.next.next;
        return root.next;
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next ==  null) return head;
        ListNode pre=head.next;
        ListNode aft=head;
        while (pre!=null){
            if(pre.val==aft.val){
                aft.next=pre.next;
                pre=pre.next;
            }else {
                pre= pre.next;
                aft= aft.next;
            }
        }
        return head;
    }

    public static ListNode deleteAllDuplicates(ListNode head) {
        if(head == null || head.next==null) return head;
        ListNode root=new ListNode(0);
        root.next=head;
        ListNode pre=root.next.next;
        ListNode mid=root.next;
        ListNode aft=root;
        while (pre != null){
            if(pre.val==mid.val){
                if(pre.next!=null&&pre.next.val==pre.val){
                    pre=pre.next;
                }else {
                    mid=pre.next;
                    aft.next=pre.next;
                    if(pre.next!=null){
                        pre=pre.next.next;
                    }else {
                        break;
                    }
                }
            }else {
                aft=aft.next;
                mid=mid.next;
                pre=pre.next;
            }
        }
        return root.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(3);
        listNode.next.next.next.next = new ListNode(5);
        ListNode node = listNode;
        node=deleteAllDuplicates(node);
        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.print("null");
    }
}


