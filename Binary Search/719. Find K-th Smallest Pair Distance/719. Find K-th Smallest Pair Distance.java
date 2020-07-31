
/*

Read top voted discuss:
Time complexity O(nlogd + nlogn) (don't forget the sorting)

given an integer num, let count(num) denote the number of pair distances that are no greater than num, 
then the K-th smallest pair distance will be the smallest integer such that count(num) >= K.

Here is a quick justification of the alternative definition. 
Let num_k be the K-th pair distance in the sorted pair distance array with index K - 1, as specified in the first definition. 
Since all the pair distances up to index K - 1 are no greater than num_k, we have count(num_k) >= K. 
Now suppose num is the smallest integer such that count(num) >= K, we show num must be equal to num_k as follows:

If num_k < num, since count(num_k) >= K, then num will not be the smallest integer such that count(num) >= K, which contradicts our assumption.

If num_k > num, since count(num) >= K, by definition of the count function, there are at least K pair distances that are no greater than num, 
which implies there are at least K pair distances that are smaller than num_k. This means num_k cannot be the K-th pair distance, contradicting our assumption again.
*/

public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0, right = nums[n-1] - nums[0];
        while (left<right){
            int mid = left + (right - left)/2;
            int count = 0, j=0;
            //two pointer technique; time complexity is O(n) not O(n^2) because j keeps increasing not going back to 0 for each i.
            for (int i=0; i<n; i++){
                while (j<n && nums[j]-nums[i]<=mid) j++;
                count += (j-i-1);
            }
            if (count<k){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return left;
    }
    
