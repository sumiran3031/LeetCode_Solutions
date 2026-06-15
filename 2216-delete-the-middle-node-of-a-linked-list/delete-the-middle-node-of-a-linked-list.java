/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    public ListNode deleteMiddle(ListNode head) {
        if(head==null || head.next==null) return null;

        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=null;

        while(fast !=null && fast.next!=null){
            fast=fast.next.next;
            prev=slow;
            slow=slow.next;
        }
        prev.next=slow.next;
        return head;
    }
    static ListNode createList(int[] arr){
        ListNode dummy=new ListNode(0);
        ListNode curr=dummy;
        for(int val:arr){
            curr.next=new ListNode(val);
            curr=curr.next;
        }
        return dummy.next;
    }
    static void printList(ListNode head){
        while(head !=null){
            System.out.println(head.val);
            if(head.next!=null) System.out.println("->");
            head=head.next;
        }
        System.out.println();
    }
    public static void main (String[] args){
        Solution sol=new Solution();
        ListNode l1=createList(new int[] {1,3,4,7,1,2,6});
        System.out.println("Before:"); printList(l1);
        System.out.println("after:"); printList(sol.deleteMiddle(l1));

        ListNode l2=createList(new int[]{1,2,3,4});
        System.out.println("Before:");printList(l2);
        System.out.println("After:");printList(sol.deleteMiddle(l2));

        ListNode l3=createList(new int[]{2,1});
        System.out.println("Before:"); printList(l3);
        System.out.println("After:"); printList(sol.deleteMiddle(l3));
    }
}