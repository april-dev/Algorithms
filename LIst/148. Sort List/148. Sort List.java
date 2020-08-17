public ListNode sortList(ListNode head) {
        if (head==null || head.next==null) return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newhead = slow.next;
        slow.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(newhead);
        /*
        //alternative way to define slow and fast;
        ListNode prev = null, slow = head, fast = head;
    
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
 
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow); 
        */
        return merge(l1, l2);
    }
    //same as Merge two sorted lists
    public ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1!=null && l2!=null){
            if (l1.val<l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1!=null) cur.next = l1;
        if (l2!=null) cur.next = l2;
        return dummy.next;
    }
    
    //
