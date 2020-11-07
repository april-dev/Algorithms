public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        while (l1!=null){
            s1.push(l1);
            l1 = l1.next;
        }
        while (l2!=null){
            s2.push(l2);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode dummy = null;
        while (!s1.isEmpty() || !s2.isEmpty() || carry!=0){
            int t1 = 0, t2 = 0;
            if (!s1.isEmpty()) t1 = s1.pop().val;
            if (!s2.isEmpty()) t2 = s2.pop().val;
                       
            int sum = t1 + t2 + carry;        
            ListNode list = new ListNode(sum%10);
            
            carry = sum/10;
            list.next = dummy;
            dummy = list;            
        }
        return dummy;
    }
