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
    public ListNode sortList(ListNode head) {
        ListNode start=new ListNode(0,head);
        ListNode currNode=head;

        while(currNode!=null && currNode.next!=null){

            if(currNode.val<=currNode.next.val){
                currNode=currNode.next;
                continue;
            }
            boolean moved=false;
            ListNode prev=start;
            ListNode head1=start.next;
            while(head1!=currNode.next){
                if(currNode.next.val<head1.val){
                prev.next=currNode.next;
                currNode.next=currNode.next.next;
                prev.next.next=head1;
                moved=true;
                break;
                }
                prev=head1;
                head1=head1.next;
            } 
            if(!moved)
            currNode=currNode.next;
        }
        return start.next; 
    }
}