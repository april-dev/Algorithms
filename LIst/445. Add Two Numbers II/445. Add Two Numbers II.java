public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1!=null){
            s1.add(l1.val);
            l1=l1.next;
        }
        while (l2!=null){
            s2.add(l2.val);
            l2=l2.next;
        }
        
        ListNode dummy = null;
        int sum =0;
        while (!s1.isEmpty() || !s2.isEmpty() || sum!=0){
            int v1=0, v2=0;
            
            if (!s1.isEmpty()) v1=s1.pop();
            if (!s2.isEmpty()) v2=s2.pop();
            
            sum= sum + v1 + v2;         
            ListNode head = new ListNode(sum%10);
            head.next = dummy;
            dummy = head;
            sum=sum/10;
        }
        return dummy;
    }
