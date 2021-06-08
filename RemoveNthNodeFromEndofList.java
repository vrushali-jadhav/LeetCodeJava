/*
If we use 2 pointers, a slow pointer and the fast pointer, starting slow pointer from first node but starting fast pointer from nth node, and move them at the same speed, by the time fast pointer reaches the end, slow pointer will be pointing to the correct node.

Time complexity: O(N)
Space complexity: O(1)
*/

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = new ListNode();
        p1.next = head;
        ListNode p2=p1;
        ListNode p3=p1;
        int count = 0;
        
        while(count<n)
        {
            p3 = p3.next;
            count++;
        }
        
        while(p3.next!=null)
        {
            p2=p2.next; 
            p3=p3.next;
        }
        p2.next = p2.next.next;
        return p1.next; //return p1.next rather than returning head.  
        //because in case of [1,2], 2, head is at 1 by the end. But when p2.next = p2.next.next is done, p1.next skips the head. As for less then 3 elements in the list, p1 and p2 both are at the dummy node
    }
}