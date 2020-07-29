// why j = (m + n + 1)/2 - i
//1 If m + n is even, then split the elements evenly into the left and right part, so i + j = m + n - i - j. 
//(Clearly the 1st middle number is in the left part and the 2nd middle number is in the right part) => thus j = (m + n)/2 - i (1)
//2 If m + n is odd, then put the median in the left part, so the number of elements in the left part is one more than that of elements in the right part.
//That's where + 1 comes in the formula: i + j = m + n - i - j + 1 => thus j = (m + n + 1)/2 - i(2)

//Then!!! (1) can be merged to (2)! How? Let's list them together:

//(1) j = (m + n)/2 - i, if m + n is even
//(2) j = (m + n + 1)/2 - i, if m + n is odd
//Notice that if a number num is even, then num/2 = (num + 1)/2, for example 4/2 = (4 + 1)/2 = 2. So (m + n)/2 is equal to (m + n + 1)/2 in (1). 
//Thus we can merge them to (2). That's the reason why we use j = (m + n + 1)/2 - i through our code.


public double findMedianSortedArrays(int[] nums1, int[] nums2) {
 int m = nums1.length;
	int n = nums2.length;
	
	if (m > n) {
		return findMedianSortedArrays(nums2, nums1);
	}
	
	int i = 0, j = 0, imin = 0, imax = m, half = (m + n + 1) / 2;
	double maxLeft = 0, minRight = 0;
	while(imin <= imax){
		i = (imin + imax) / 2;
		j = half - i;
		if(j > 0 && i < m && nums2[j - 1] > nums1[i]){
			imin = i + 1;
		}else if(i > 0 && j < n && nums1[i - 1] > nums2[j]){
			imax = i - 1;
		}else{
			if(i == 0){
				maxLeft = (double)nums2[j - 1];
			}else if(j == 0){
				maxLeft = (double)nums1[i - 1];
			}else{
				maxLeft = (double)Math.max(nums1[i - 1], nums2[j - 1]);
			}
			break;
		}
	}
	if((m + n) % 2 == 1){
		return maxLeft;
	}
	if(i == m){
		minRight = (double)nums2[j];
	}else if(j == n){
		minRight = (double)nums1[i];
	}else{
		minRight = (double)Math.min(nums1[i], nums2[j]);
	}
	
	return (double)(maxLeft + minRight) / 2;
}
