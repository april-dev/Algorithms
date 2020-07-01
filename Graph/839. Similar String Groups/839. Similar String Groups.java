    public int numSimilarGroups2(String[] a) {
        int n = a.length;
        int[] parent = new int[n];
        for (int i = 1; i < n; i++) parent[i] = i;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isSimilarString(a[i], a[j])) {
                    int p1 = find(parent, i), p2 = find(parent, j);
                    if (p1 != p2) {
                        parent[p2] = p1;
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) res++;
        }
        return res;
    }

    private boolean isSimilarString(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) diff++;
        }
        return (diff == 2 || diff == 0);
    }

    private int find(int[] a, int x) {
        if (a[x] != x) {
            a[x] = find(a, a[x]);
        }
        return a[x];
    }
    
    
    
    //DFS
    public int numSimilarGroups(String[] a) {
        int r = 0;
        for (int i = 0; i < a.length; i++)
            if (a[i] != null) {
                r++;
                dfs(i, a);
            }
        return r;
    }

    void dfs(int j, String[] a) {
        String s = a[j];
        a[j] = null;
        for (int i = 0; i < a.length; i++)
            if (a[i] != null && similarGroup(a[i], s))
                dfs(i, a);
    }

    boolean similarGroup(String s, String t) {
        int diff = 0, i = 0;
        while (i < s.length() && diff <= 2)
            if (s.charAt(i) != t.charAt(i++))
                diff++;
        return diff == 2;
    }
