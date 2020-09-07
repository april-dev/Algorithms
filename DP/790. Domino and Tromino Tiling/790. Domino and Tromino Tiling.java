public int numTilings(int N) {
        int md = (int) 1e9;
        md+=7;
        long [] v = new long[1001];
        v[1] = 1;
        v[2] = 2;
        v[3] = 5;
        for (int i=4; i<=N; i++){
            v[i] = 2*v[i-1] + v[i-3];
            v[i] %= md;
        }
        return (int)v[N];
        
    }
