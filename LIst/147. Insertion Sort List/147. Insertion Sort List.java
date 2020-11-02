//My solution
public ListNode insertionSortList(ListNode head) {
        if (head==null) return null;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        cur.next = head;
        if (head.next==null) return dummy.next;
        ListNode nex = head.next;
        head.next = null;
        while (nex!=null){
            ListNode prev = dummy;
            cur = dummy.next;
            while (cur!=null && cur.val<nex.val){
                prev = cur;
                cur = cur.next;
            }
            prev.next = nex;
            nex = nex.next;
            prev.next.next = cur;
        }
        return dummy.next;
    }


public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode cur = dummy;   
        ListNode pre = cur;
        ListNode tail = null;
        while (head!=null){
            ListNode temp = head;
            head = head.next;
            cur = dummy;
            while (cur!=null && temp.val>=cur.val){
                pre = cur;
                cur = cur.next;
                tail = cur;
            }
            pre.next = temp;
            temp.next = tail;           
        }
        return dummy.next;
    }
    
    //Better implementation
    //Compared to the solution, while (prev.next!=null && prev.next.val<head.val) is what makes the difference. instead of comparing cur node, comparing cur.next will avoid the need 
    // to create a new ListNode called prev in the solution above.
    
   public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        while (head!=null){
            ListNode temp = head.next;
            if (prev.val>head.val) prev = dummy;
            
            while (prev.next!=null && prev.next.val<head.val){
                prev = prev.next;
            }
            
            head.next = prev.next;
            prev.next = head;
            head = temp;
    }
        return dummy.next;
    } 
