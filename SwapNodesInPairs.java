/*Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head==null || head.next==null)
            return head;
        
        ListNode newHead=head.next;
        
       ListNode temp=null,temp1=null;

        while (head!=null && head.next!=null ){
             temp=head.next;
        
             head.next=head.next.next;
            
             temp.next=head;
          
             temp1=head;
            
             head=head.next; 
            
             if (head!=null && head.next!=null)
                temp1.next=head.next;       
        }        
        return newHead;
    } 
}
