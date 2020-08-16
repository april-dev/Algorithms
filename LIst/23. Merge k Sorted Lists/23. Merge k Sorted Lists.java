//complexity: O(n*logk)
// n is total number of nodes in all lists, k is number of lists
//

public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null || lists.length==0) return null;
        //actually not good because of Integer overflow. It is better to use Integer.compare() :
        //PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.length, (a,b)-> Integer.compare(a.val, b.val));
        //or use comparator
        /*
        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.size(),new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                if (o1.val<o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else 
                    return 1;
            }
        });
        */
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);        
        for (ListNode l:lists){
        if (l!=null) pq.add(l);
        }
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (!pq.isEmpty()){
            ListNode cur = pq.poll();
            if (cur.next!=null) pq.add(cur.next);
            p.next = cur;
            p=p.next;
        }
        return dummy.next;
    }
