/**
Find the middle, split the lists into 2 parts, reverse the second half, compare the elements until one of the lists reaches end

Time complexity: O(N)
Space complexity: O(1)
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode sp = head;
        ListNode fp;
        
        if(head.next==null)
            return true;
        
        fp=head.next;
        
        //sp by the end of it will point to the middle 
        while(fp!=null && fp.next!=null)
        {
            sp=sp.next;
            fp=fp.next.next;
        }
        
        //reset fp to 1st node of second half of the list
        fp=sp.next;
        
        //disconnect 1st half from 2nd
        sp.next=null;
        sp=head;
        
        //reverse the 2st half of the linked list
        ListNode p1 = null;
        ListNode p2 = fp;
        ListNode p3;
        
        while(p2.next!=null)
        {
            p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }
        p2.next=p1;
        
        //p2 points to beginning of the 2nd half of the linked list (reversed)
        while(p2!=null && sp!=null)
        {
            if(p2.val!=sp.val)
                return false;
            p2=p2.next;
            sp=sp.next;
        }
        return true;
    }
}