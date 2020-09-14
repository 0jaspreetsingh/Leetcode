package LinkedList;

/**
 * 23. Merge k Sorted Lists
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class MergeKSortedLists {

    //Definition for singly-linked list.
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
    }


    public ListNode mergeKLists(ListNode[] lists) {
        return mergeSort(lists, 0, lists.length - 1);
    }

    private ListNode mergeSort(ListNode[] lists, int left, int right) {

        if (left <= right) {
            if (left == right) {
                return lists[left];
            }
            if (left + 1 == right) {
                return mergeTwoLists(lists[left], lists[right]);
            } else {
                int mid = left + (right - left) / 2;
                ListNode a = mergeSort(lists, left, mid);
                ListNode b = mergeSort(lists, mid + 1, right);
                ListNode ans = mergeTwoLists(a, b);
                return ans;
            }
        }

        return null;


    }

    private ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode ans = new ListNode(0);
        ListNode temp = ans;
        while (a != null && b != null) {
            if (a.val < b.val) {
                temp.next = a;
                a = a.next;
            } else {
                temp.next = b;
                b = b.next;
            }
            temp = temp.next;
        }
        if (a != null) {
            temp.next = a;
        } else if (b != null) {
            temp.next = b;
        }

        return ans.next;
    }
}
