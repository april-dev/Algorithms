 public int minJumps(int[] arr) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i=0; i<arr.length; i++){
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[arr.length];
        q.offer(0);
        visited[0] = true;
        int step = 0;
        while (!q.isEmpty()){
            int size = q.size();
            while (size-->0){
                int cur = q.poll();
                if (cur == arr.length - 1) return step;
                List<Integer> list = map.get(arr[cur]);
                list.add(cur-1); list.add(cur+1);
                for (int idx: list){
                    if (idx>0 && idx<arr.length && visited[idx]==false){
                        q.offer(idx);
                        visited[idx] = true;
                    }
                }
                list.clear();
            }
            step++;
        }
        return -1;
    }
