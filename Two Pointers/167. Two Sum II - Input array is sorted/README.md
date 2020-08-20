Each sum is characterized by two indices (i, j), where 0 <= i < j < n with n the length of the input array. If we were to compute them explicitly, we end up with an n-by-n matrix.

If the input array is not sorted, to search for the target, there is no good way but comparing it with elements from the above matrix one by one. This is the naive O(n^2) solution. Of course you can use a HashMap to memorize visited elements and cut down the time to O(n) so we have the classic space-time tradeoff.

Now if the input array is sorted, the n-by-n summation matrix will have the following properties:

Integers in each row are sorted in ascending order from left to right.
Integers in each column are sorted in ascending order from top to bottom.
To find the target, we do not have to scan the whole matrix now since it exhibits some partial order. We may start from the top-right (or bottom-left) corner, then proceed to the next row or previous column depending on the relationship between the matrix element and the target until either it is found or all rows and columns are exhausted. The key here is that we can get rid of a whole row or column due to the two properties of the matrix specified above.

If you have finished leetcode problem "240. Search a 2D Matrix II", you will find that this is exactly the same problem, except now of the two indices, the first has to be smaller than the second. Time complexity for "leetcode 240" is O(m + n), while for this problem we have m = n, plus the indices constraint so the time complexity will be O(n). Also we do not need the HashMap now so space complexity will be O(1).
