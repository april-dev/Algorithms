public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int m = nums1.length;
        int n = nums2.length;
        if (m==0 || n==0 ) return res;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(nums1[a[0]]+nums2[a[1]]-nums1[b[0]]-nums2[b[1]]));
        
        for (int i=0; i<n; i++){
            pq.add(new int[]{0, i});
        }
        for (int i=0; i<Math.min(k, m*n); i++){
            int[] cur = pq.poll();
            List<Integer> temp = new ArrayList<>();
            temp.add(nums1[cur[0]]);
            temp.add(nums2[cur[1]]);
            res.add(temp);
            if (++cur[0]<m) pq.add(cur);
        }
        return res;
    }
