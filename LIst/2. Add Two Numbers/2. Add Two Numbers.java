public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode l = dummy;
        int sum = 0;
        while (l1!=null || l2!=null || sum!=0){
        //if l1 or l2 is empty, treat it as 0
            int v1=0, v2=0;
            if (l1!=null) {
                v1 = l1.val;
                l1=l1.next;
            }
            if (l2!=null) {
                v2 = l2.val;
                l2=l2.next;
            }
            sum += v1+v2;
            ListNode temp = new ListNode(sum%10);
            l.next = temp;
            l=l.next;
            sum=sum/10;
            
        }
        return dummy.next;
    }
