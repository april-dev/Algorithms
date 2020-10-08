//circle
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null || head.next==null || k==0) return head;
        ListNode cur = head;
        int len = 1;
        while (cur.next!=null){
            cur = cur.next;
            len++;
        }
        cur.next = head;
        k = len - k%len;
        while (k>0) {
            cur = cur.next;
            k--;
        }
        head = cur.next;
        cur.next = null;
        return head;       
    }


public ListNode rotateRight(ListNode head, int k) {
        if (head==null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        int len = 0;
        while (p.next!=null){
            p = p.next;
            len++;
        }
        ListNode cur = dummy;
        p=dummy;
        
        k = k%len;
        if (k==0) return dummy.next;
        len = len - k;
        while (len >0){
            cur = cur.next;
            len--;
        }
        ListNode temp = p.next;
        p.next = cur.next;
        cur.next = null;
        while (p.next!=null){
            p= p.next;
        }
        p.next = temp;
        return dummy.next;
    }
