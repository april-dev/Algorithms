public int makeConnected(int n, int[][] connections) {
        int[] parent = new int[n];
        for (int i=0; i<n; i++){
            parent[i] = i;
        }
        int count = 0;
        for (int[] edge:connections){
            int u=edge[0], v=edge[1];
            int pu = find(parent, u), pv = find(parent, v);
            if (pu==pv){
                count++;
            }else{
                parent[pu] = pv;
            }
        }
        int ds = 0;
        for (int i=0; i<n; i++){
            //int p = find(parent, i);
            //if (p==i) ds++;
            if (parent[i]==i) ds++;
        }
        if (count-(ds-1)>=0){
            return ds-1;
        }else{
            return -1;
        }
    }
    public int find(int[] parent, int i){
        if (parent[i]!=i){
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }
