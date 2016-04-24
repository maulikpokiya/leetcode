/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = null;
        ListNode temp = null;
        int carryBit = 0, sum = 0;

        while(true) {

            if(l1 != null && l2 != null) {
                sum = l1.val + l2.val + carryBit;
                carryBit = 0;

                l1 = l1.next;
                l2 = l2.next;

            } else if(l1 == null && l2 != null) {
                sum = l2.val + carryBit;
                carryBit = 0;
                l2 = l2.next;

            } else if(l1 != null && l2 == null) {
                sum = l1.val + carryBit;
                carryBit = 0;
                l1 = l1.next;

            } else if(carryBit == 1) {
                sum = 1;
                carryBit = 0;
            } else {
                break;
            }

            if(sum > 9) {
                sum = sum - 10;
                carryBit = 1;
            }

            if(head==null) {
                temp = new ListNode(sum);
                head = temp;
            } else {
                temp.next = new ListNode(sum);
                temp = temp.next;
            }

            temp.next = null;
        }
        return head;
    }
}