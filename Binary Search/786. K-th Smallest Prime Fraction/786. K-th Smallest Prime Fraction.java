//Time complexity: O(n * log(MAX^2)), where MAX is the maximum element in A
/*
We need the pair (p, q) to record the maximum fraction in the matrix that is no greater than each candidate solution. 
This is necessary because on the one hand, the candidate solution itself cannot tell us what the numerator and denominator of the fraction are 
(remember the candidate solution is just a floating-point number); on the other hand, even if we can get the numerator and denominator of the candidate solution, 
these values may not be contained in the input array (remember all the fractions must be formed by pair of integers from the input array). 
This is different from the case when the matrix elements are integers, where at the end of the binary search, 
the candidate solution must be equal to the kth smallest element in the matrix.
*/

public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        double left = 0, right = 1;
        int p=0, q=1;
        int n = arr.length;
        
        while (true){
            double m = (left +right)/2;
            int count = 0;
            p = 0;
            for (int i=0, j=n-1; i<n; i++){
                while (j>=0  && arr[i] > m*arr[n-1-j]) j--;
                count += (j+1);
            
                if (j >= 0 && p * arr[n - 1 - j] < q * arr[i]) {
                    p = arr[i];
                    q = arr[n - 1 - j];
                }
            }
            if (count < k) left = m;
            else if (count > k) right = m;
            else return new int[]{p,q};
        }        
    }

//PriorityQueue
//O(max(n,k) * logn)
public int[] kthSmallestPrimeFraction(int[] arr, int k) {    
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->arr[a[0]]*arr[b[1]] - arr[a[1]]*arr[b[0]]);
        int n = arr.length;
        
        for (int i=0; i<n-1; i++) pq.offer(new int[] {i, n-1});
        for (int i=0; i<k-1; i++){
            int[] cur = pq.poll();
            if (cur[1]-1>cur[0]){
                cur[1]--;
                pq.offer(cur);
            }
        }
        
        int[] peek = pq.peek();
        return new int[]{arr[peek[0]], arr[peek[1]]};               
    }
