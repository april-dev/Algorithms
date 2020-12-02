class Solution {

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    ListNode head;
    Random random;
    public Solution(ListNode head) {
        this.head = head;
        random = new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        ListNode cur = head;
        int res = cur.val;
        int i=1;
        while (cur.next!=null){
            cur = cur.next;
            if (random.nextInt(i+1) == i) res = cur.val;
            i++;
        }
        return res;
    }
}
