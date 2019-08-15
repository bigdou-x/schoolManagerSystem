package com.bigdou.school.datastructure;

/**
 * <P>文件描述：单链表Demo</P>
 *
 * @author xuqing
 * @version V1.0
 * @date 2019-8-1 10:57:15
 */
public class ListNodeDemo {

    public static void main(String[] args) {
        ListNode rootNode = new ListNode(1, null);
//        ListNode tmpNode = rootNode;
//        tmpNode.next = new ListNode(1, null);
//        tmpNode = tmpNode.next;
        ListNode rootNode1 = new ListNode(9, null);
        ListNode tmpNode1 = rootNode1;
        tmpNode1.next = new ListNode(9, null);
        tmpNode1 = tmpNode1.next;


        System.out.println(addTwoNumbers(rootNode, rootNode1));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rootNode = new ListNode(0, null);
        ListNode tmpNode = rootNode;
        int result = 0;
        while (l1 != null || l2 != null) {
            if (l1 == null && l2 == null) {
                break;
            }
            int sum = ((l1 == null) ? 0 : l1.value) + ((l2 == null) ? 0 : l2.value) + result;
            tmpNode.next = new ListNode(sum % 10, null);
            tmpNode = tmpNode.next;
            result = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (result > 0) {
            tmpNode.next = new ListNode(result, null);
        }
        return rootNode.next;
    }

}
