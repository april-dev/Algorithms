public List<Integer> findMinHeightTrees(int n, int[][] edges) {
       List<Integer> leafs = new ArrayList<>();
        if (n == 1) {
            leafs.add(0);
            return leafs;
        }
        List<Set<Integer>> neighbors = new ArrayList<>();
        for (int i=0; i<n; i++) neighbors.add(new HashSet<>());
        for (int[] edge:edges){
            neighbors.get(edge[0]).add(edge[1]);
            neighbors.get(edge[1]).add(edge[0]);
        }
        
        for (int i=0; i<n; i++){
            if (neighbors.get(i).size() == 1) leafs.add(i);
        }
        while (n > 2){
            n -= leafs.size();
            List<Integer> newLeafs = new ArrayList<>();
            for (int leaf:leafs){
                int j = neighbors.get(leaf).iterator().next();
                neighbors.get(j).remove(leaf);
                if (neighbors.get(j).size() == 1) newLeafs.add(j);
            }
            leafs = newLeafs;
        }
        return leafs;
    }
