public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        boolean[] reachableClosedBoxes = new boolean[status.length];
        Queue<Integer> q = new LinkedList<>();
        for (int initBox:initialBoxes){
            if (status[initBox]==1) {
                q.add(initBox);
            }else{
                reachableClosedBoxes[initBox] = true;
            }
        }
        int res = 0;
        while (!q.isEmpty()){
            int cur = q.poll();
            res += candies[cur];
            for (int i:keys[cur]){
                if (status[i]==0 && reachableClosedBoxes[i]==true) {
                    q.add(i);
                }
                status[i] = 1;
            }
            for (int i:containedBoxes[cur]){
                if (status[i]==1){
                    q.add(i);
                }else{
                    reachableClosedBoxes[i] = true;
                }
            }
        }
        return res;       
    }
