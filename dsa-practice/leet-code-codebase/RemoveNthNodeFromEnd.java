
//19. Remove Nth Node From End of List

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode temp = head;
        ListNode pre;

        while(temp!=null){
            size+=1;
            temp = temp.next;
        }
        if(size==1 || size==n){
            return head.next;
        }

        int idx = 0;

        ListNode curr = head;

        while(curr!=null){
            if(idx==(size-n-1)){
                //here we can remove
                curr.next = curr.next.next;
            }
            idx+=1;
            curr = curr.next;
            
        }
        return head;
    }
}