class Solution {
    int[] cumulativeSum;
    Random random;
    public Solution(int[] w) {
        this.random = new Random();
        cumulativeSum = new int[w.length+1];
        for (int i=1; i<cumulativeSum.length; i++){
            cumulativeSum[i] = cumulativeSum[i-1] + w[i-1];
        }
    }
    
    public int pickIndex() {
        int n = cumulativeSum.length;
        int idx = random.nextInt(cumulativeSum[n-1])+1;
        int l=1, r = n-1;
        while (l<r){
            int mid = l+ (r-l)/2;
            if (cumulativeSum[mid]<idx){
                l = l + 1;
                
            }else{
                r = mid;
            }
        }
        return l-1;
    }
}
