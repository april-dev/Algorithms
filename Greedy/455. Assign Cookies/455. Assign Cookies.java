public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count =0;
        int p = 0;
        for (int i=0; i<g.length; i++){
            while (p<s.length && s[p]<g[i]) p++;
            if (p==s.length) break;
            count+=1;
            p++;            
        }
        return count;
    }
    
  public int findContentChildren(int[] children, int[] cookies) {
        Arrays.sort(children);
        Arrays.sort(cookies);
        
        int child = 0;
        for (int cookie = 0; child < children.length && cookie < cookies.length; cookie ++) {
            if (cookies[cookie] >= children[child]) {
                child ++;
            }
        }
        
        return child;
    }  
