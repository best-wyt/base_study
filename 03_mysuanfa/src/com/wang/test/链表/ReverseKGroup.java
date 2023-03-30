package com.wang.test.链表;

/**
* @Author: wyt
* @Description: K 个一组翻转链表
* @DateTime: 2023/3/16 13:26
*/
public class ReverseKGroup {


    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
//        ListNode head3 = new ListNode(4);
//        ListNode head4 = new ListNode(5);
        head.next = head1;
        head1.next = head2;
//        head2.next = head3;
//        head3.next = head4;
        reverseKGroup(head , 3);
    }


    /**
     * @param head ListNode类
     * @param k    int整型
     * @return ListNode类
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        // write code here
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode pre = newHead;
        int sum = 0;
        while (head != null) {
            head = head.next;
            sum++;
        }

        int count = sum / k;
        ListNode cur;
        ListNode curNext;
        for (int i = 0; i < count; i++) {
             cur = pre.next;
            for (int j = 1; j < k; j++) {
                // 每次循环cur_next会被从新赋值
                curNext = cur.next;
                // 移动cur.next
                cur.next = curNext.next;
                // 不停的将后面的节点移到前面
                curNext.next = pre.next;
                // 更新pre.next 也就是head
                pre.next = curNext;
            }
            pre = cur;
        }

        return newHead.next;

    }


    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
}