public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null || lists.length==0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a,b)->a.val-b.val);
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for (ListNode l: lists){
            if (l != null) pq.offer(l);
        }
        while (!pq.isEmpty()){
            tail.next = pq.poll();
            tail = tail.next;
            if (tail.next!=null) pq.offer(tail.next);
        }
        return dummy.next;    
    }
