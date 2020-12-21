package LinkedList;

/**
 * https://leetcode.com/problems/insertion-sort-list/
 */
public class InsertionSortList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode insertionSortList(ListNode head) {

            ListNode front = new ListNode(Integer.MIN_VALUE);

            ListNode curr = head;
            while (curr != null) {
                ListNode prev = front;
                while (prev.next != null && prev.next.val < curr.val) {
                    prev = prev.next;
                }
                ListNode next = curr.next;
                curr.next = prev.next;
                prev.next = curr;

                curr = next;
            }


            return front.next;
        }
    }
}

