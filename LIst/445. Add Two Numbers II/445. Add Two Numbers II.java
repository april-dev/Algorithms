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

//Recursive
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int size1 = getLength(l1);
        int size2 = getLength(l2);
        ListNode head = new ListNode(1);
        // Make sure l1.length >= l2.length
        head.next = size1 < size2 ? helper(l2, l1, size2 - size1) : helper(l1, l2, size1 - size2);
        // Handle the first digit
        if (head.next.val > 9) {
            head.next.val = head.next.val % 10;
            return head;
        }
        return head.next;
    }
    // get length of the list
    public int getLength(ListNode l) {
        int count = 0;
        while(l != null) {
            l = l.next;
            count++;
        }
        return count;
    }
    // offset is the difference of length between l1 and l2
    public ListNode helper(ListNode l1, ListNode l2, int offset) {
        if (l1 == null) return null;
        // check whether l1 becomes the same length as l2
        ListNode result = offset == 0 ? new ListNode(l1.val + l2.val) : new ListNode(l1.val);
        ListNode post = offset == 0 ? helper(l1.next, l2.next, 0) : helper(l1.next, l2, offset - 1);
        // handle carry 
        if (post != null && post.val > 9) {
            result.val += 1;
            post.val = post.val % 10;
        }
        // combine nodes
        result.next = post;
        return result;
    }
