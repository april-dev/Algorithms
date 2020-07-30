/*
The key point for any binary search is to figure out the "Search Space". 
For me, I think there are two kind of "Search Space" -- index and range(the range from the smallest number to the biggest number). 
Most usually, when the array is sorted in one direction, we can use index as "search space", when the array is unsorted and we are going to find a specific number, 
we can use "range".

Let me give you two examples of these two "search space"

index -- A bunch of examples -- https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/ ( the array is sorted)
range -- https://leetcode.com/problems/find-the-duplicate-number/ (Unsorted Array)
The reason why we did not use index as "search space" for this problem is the matrix is sorted in two directions, we can not find a linear way to map the number and its index.
*/

public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0], right = matrix[n-1][n-1]+1;
        while (left<right){
            int mid = left + (right - left)/2;
            int count = 0;
            for (int i=0; i<n; i++){
                int j = n-1;
                while (j>=0 && matrix[i][j]>mid ) j--;
                count += (j+1);
            }
            if (count<k){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }


//Solution 2 Heap
//heap solution is O( k log r ), 
//where r is a number of rows. Heap doesn't have more than r elements inside, which means every poll/offer operations takes O(log r) time, which we repeat k times.
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
        for(int j = 0; j <= n-1; j++) pq.offer(new Tuple(0, j, matrix[0][j]));
        for(int i = 0; i < k-1; i++) {
            Tuple t = pq.poll();
            if(t.x == n-1) continue;
            pq.offer(new Tuple(t.x+1, t.y, matrix[t.x+1][t.y]));
        }
        return pq.poll().val;
    }
}

class Tuple implements Comparable<Tuple> {
    int x, y, val;
    public Tuple (int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
    
    @Override
    public int compareTo (Tuple that) {
        return this.val - that.val;
    }
}
