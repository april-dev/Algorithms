//Time complexity: O(n * log(MAX^2)), where MAX is the maximum element in A
/*
We need the pair (p, q) to record the maximum fraction in the matrix that is no greater than each candidate solution. 
This is necessary because on the one hand, the candidate solution itself cannot tell us what the numerator and denominator of the fraction are 
(remember the candidate solution is just a floating-point number); on the other hand, even if we can get the numerator and denominator of the candidate solution, 
these values may not be contained in the input array (remember all the fractions must be formed by pair of integers from the input array). 
This is different from the case when the matrix elements are integers, where at the end of the binary search, 
the candidate solution must be equal to the kth smallest element in the matrix.
*/

public int[] kthSmallestPrimeFraction(int[] A, int K) {
    double l = 0, r = 1;
    int p = 0, q = 1;
    
    for (int n = A.length, cnt = 0; true; cnt = 0, p = 0) {
        double m = (l + r) / 2;
        
        for (int i = 0, j = n - 1; i < n; i++) {
            while (j >= 0 && A[i] > m * A[n - 1 - j]) j--;
            cnt += (j + 1);
            
            if (j >= 0 && p * A[n - 1 - j] < q * A[i]) {
                p = A[i];
                q = A[n - 1 - j];
            }
        }
        
        if (cnt < K) {
            l = m;
        } else if (cnt > K) {
            r = m;
        } else {
            return new int[] {p, q};
        }
    }
}
