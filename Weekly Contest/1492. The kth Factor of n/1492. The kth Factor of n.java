//Just check the divisibility and count; note that we only go till n / 2. In the end, if k == 1, then the last divisor is our number n itself.
//O(n)

public int kthFactor(int n, int k) {
        for (int i=1; i<=n/2; i++){
            if (n%i==0) {
                k-=1;
                if (k==0) return i;
            }
        }
        return k==1? n:-1;       
    }
    
//Just loop until square root of n, by caching the other facters to a list.
//O(sqrt n)

public int kthFactor(int n, int k) {
        List<Integer> divisor = new ArrayList<>();
        int count =0;
        for (int i=1; i*i<=n; i++){
            if (n%i==0){
                if (i*i!=n) divisor.add(n/i);
                count += 1;
                if (count==k) return i;
            }
        }
        if (count+divisor.size()<k) return -1;
        return divisor.get(divisor.size()-(k-count));
    }
    
 //Space is O(1)
 int kthFactor(int n, int k) {
    int d = 1;
    for (; d * d <= n; ++d)
        if (n % d == 0 && --k == 0)
            return d;
    for (d = d - 1; d >= 1; --d) {
        if (d * d == n)
            continue;
        if (n % d == 0 && --k == 0)
            return n / d;
    }
    return -1;
}
