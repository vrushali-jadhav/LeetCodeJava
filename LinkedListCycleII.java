/* 1. If we have a slow pointer and a fast pointer, at any time, if the fast pointer meets the slow pointer, before the slow pointer reaches the end of the linked list, there's a cycle
2. After detecting the cycle, if we reset the slow pointer to the beginning, and move pointers at the same speed, they will meet at the beginning of the cycle
3. 1 -> 2 -> 3 -> 4 -> 5, the slow pointer and the fast pointer meet at 4. T 
   |___________________|  
   
4. The distance travelled by the fast pointer from 4 (after resetting SP to head and moving both with speed 1), is equal to the distance of the of the start of the cycle from the head 
Time complexity: O(N)
Space complexity: O(1)
*/
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        int distance; 
        boolean cycleDetected = false;
        int count = 0;
        
        while(fastPointer!=null && fastPointer.next!=null)
        {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if(slowPointer == fastPointer) //cycle detected
            {
                cycleDetected = true;
                break; 
            }
        }
        if(!cycleDetected)
            return null;
        else
        {
            //reset the slowPointer to head
            slowPointer = head;
            while(slowPointer!=fastPointer)
            {
                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next;
            }
            //they met. Since they will meet at the beginning of the cycle, we can either return slow or fast
        }
        return slowPointer;
    }
}