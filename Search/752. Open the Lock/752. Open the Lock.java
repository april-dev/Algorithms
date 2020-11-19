public int openLock(String[] deadends, String target) {
        Queue<String> q = new LinkedList<>();
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        q.offer("0000");
        visited.add("0000");
        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                String s = q.poll();
                
                if(deads.contains(s)) continue;     
                if(s.equals(target)) return level;
                
                for(int i = 0; i < 4; i ++) {
                    char c = s.charAt(i);
                    String s1 = s.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + s.substring(i + 1);
                    String s2 = s.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) + s.substring(i + 1);
                    if(!visited.contains(s1)) {
                        q.offer(s1);
                        visited.add(s1);
                    }
                    if(!visited.contains(s2)) {
                        q.offer(s2);
                        visited.add(s2);
                    }
                }
            }
            level ++;
        }
        return -1;
    }
