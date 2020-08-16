//TLE
public int minDays(int n) {
     if (n<3) return n;
     return 1+Math.min(n%2+minDays(n/2), n%3+minDays(n/3));
}
//TLE
public int minDays(int n) {
        if (n == 1) return 1;
        if (n % 6 == 0)
            return 1 + Math.min(minDays(n/3), minDays(n/2));
        if (n % 3 == 0)
            return 1 + Math.min(minDays(n/3), minDays(n-1));
        if (n%2 == 0)
            return 1 + Math.min(minDays(n/2), minDays(n-1));
        return 1 + minDays(n-1);
    }

//Use HashMap
Map<Integer, Integer> map = new HashMap<>();
    public int minDays(int n) {
        if (n<3) return n;
        if (!map.containsKey(n)){
            map.put(n, 1+Math.min(n%2+minDays(n/2), n%3+minDays(n/3)));
        }
        return map.get(n);
    }
    
    
    
