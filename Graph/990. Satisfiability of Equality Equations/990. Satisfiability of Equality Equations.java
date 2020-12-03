class Solution {
    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        for (int i=0; i<26; i++) parent[i] = i;
        for (String s:equations){
            int a = s.charAt(0) - 'a';
            int b = s.charAt(3) - 'a';
            if (s.charAt(1)=='=' && s.charAt(2)=='='){
                union(parent, a, b);
            }
        }
        for (String s:equations){
            int a = s.charAt(0) - 'a';
            int b = s.charAt(3) - 'a';
            if (s.charAt(1)=='!' && s.charAt(2)=='='){
                int p1 = find(parent, a);
                int p2 = find(parent, b);
                if (p1==p2) return false;
            }
        }
        return true;
    }
    public int find(int[] parent, int i){
        if (parent[i] != i){
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }
    public void union(int[] parent, int a, int b){
        int p1 = find(parent, a);
        int p2 = find(parent, b);
        if (p1!=p2) parent[p2] = p1;
    }
}
