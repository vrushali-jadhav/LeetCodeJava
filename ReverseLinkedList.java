/*
Approach: Use 3 pointers. One pointer points to the prev node. One to the current node and last one to the next node. Traverse the linked list, breaking links from the next nodes and forming new ones with the prev nodes

Space complexity: O(1)
Time complexity: O(N)
*/
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode p1 = null;
        ListNode p2 = head;
        ListNode p3;
        
        if(head==null)
            return null;
        
        while(p2.next!=null)
        {
            p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }
        p2.next = p1;
        head = p2;
        return head;
    }
}