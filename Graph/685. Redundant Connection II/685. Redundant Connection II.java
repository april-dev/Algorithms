public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] parent1 = new int[n+1], canA = new int[2], canB = new int[2];
        
        for (int[] edge:edges){
            if (parent1[edge[1]]==0){
                parent1[edge[1]]= edge[0];
            }else{
                canA[0] = parent1[edge[1]];
                canA[1] = edge[1];
                canB[0] = edge[0];
                canB[1] = edge[1];
                edge[1] = 0;
            }
        }
        int[] parent2 = new int[n+1];
        for (int i= 0; i<=n; i++) parent2[i] = i;
        for (int[] edge:edges){
            if (edge[1]==0) continue;
            int u= edge[0], v = edge[1];
            int pu = find(parent2, u);
            if (pu==v){
                if (canA[0]==0) return edge;
                return canA;
            }
            parent2[v] = pu;
        }
        return canB;
        
    }
    public int find(int[] parent2, int u){
        if (parent2[u]!=u){
            parent2[u] = find(parent2, parent2[u]);
        }
        return parent2[u];
    }
