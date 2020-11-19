public int racecar(int target) {
        Queue<int[]> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        queue.add(new int[]{0, 1});
        visited.add(0 + "," + 1);
        
        int level = 0;        
        while(!queue.isEmpty()){
            int size = queue.size();
            while (size-->0){
                int[] cur = queue.poll();
                if (cur[0]==target) return level;
                
                int[] nxt = {cur[0]+cur[1], cur[1]*2};
                String key = nxt[0] + "," + nxt[1];
                    
                if (nxt[0]<target*2 && nxt[0]>0 && !visited.contains(key)) {
                        queue.offer(nxt);
                        visited.add(key);
                }
                
                nxt = new int[]{cur[0], cur[1]>0?-1:1};
                key = nxt[0] + "," + nxt[1];
                
                if (nxt[0]<target*2 && nxt[0]>0 && !visited.contains(key)) {
                        queue.offer(nxt);
                        visited.add(key);
                }                    
            }
            level++;
        }
        return -1;
    }
