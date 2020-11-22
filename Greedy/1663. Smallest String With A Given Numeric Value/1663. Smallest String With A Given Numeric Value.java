 public String getSmallestString(int n, int k) {
        char[] array = new char[n];
        k -= n;
        
        int i = n - 1;
        while (k > 0) {
            int tmp = Math.min(k, 25);
            array[i] += tmp;
            k -= tmp;
            --i;
        }
        
        return new String(array);
    }
