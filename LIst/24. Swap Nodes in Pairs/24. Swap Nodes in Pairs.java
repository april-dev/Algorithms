public ListNode swapPairs(ListNode head) {
       ListNode dummy = new ListNode(0);
       dummy.next = head;
       ListNode cur = dummy;
       while (cur.next!=null && cur.next.next!=null){
           ListNode first = cur.next;
           ListNode second = cur.next.next;
           first.next = second.next;
           second.next = first;
           cur.next = second;
           /*alternatives. Both are correct*/
           //cur.next = second;
           //cur.next.next = first;
           cur= cur.next.next;
       }
        return dummy.next;
    }
