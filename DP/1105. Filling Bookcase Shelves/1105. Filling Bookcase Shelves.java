//DP
public int minHeightShelves(int[][] books, int shelf_width) {
        int n = books.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        for (int i=0; i<n; i++){
            int w = 0;
            int h = 0;
            for (int j=i; j>=0; j--){
                w += books[j][0];
                if (w>shelf_width) break;
                
                h = Math.max(h, books[j][1]);
                dp[i] = Math.min(dp[i], (j==0? 0:dp[j-1]) + h );
            }
        }
        return dp[n-1];
    }

//DP another version
public int minHeightShelves(int[][] books, int shelf_width) {
        int n = books.length;
        int[] dp = new int[n+1];
        dp[0] = 0;
        
        for (int i=1; i<=n; ++i){
            int height = books[i-1][1];
            int width = books[i-1][0];
            dp[i] = dp[i-1] + height;
            
            for (int j=i-1; j>0 && width +books[j-1][0]  <= shelf_width; --j){
                height = Math.max(height, books[j-1][1]);
                width += books[j-1][0];
                dp[i] = Math.min(dp[i], dp[j-1]+height);
            }
        }
        return dp[n];
    }

//Recursive + memo
class Solution {
    private int[][] m = new int[1001][1001];
    public int minHeightShelves(int[][] books, int shelfWidth) {
        return minHeightShelves(books, shelfWidth, 0, 0, 0);
    }
    
    private int minHeightShelves(int[][] books, int maxWidth, int idx, int w, int h) {
        if (idx >= books.length) return h;
        if (m[idx][w] != 0) return m[idx][w];
        return m[idx][w] = Math.min(
            // min of placing book in new shelf, updating latest h and w of current book
            h + minHeightShelves(books, maxWidth, idx+1, books[idx][0], books[idx][1]),
            // or placing book in same shelf and check min h
            w + books[idx][0] > maxWidth ? Integer.MAX_VALUE : minHeightShelves(books, maxWidth, idx+1, w + books[idx][0], Math.max(h, books[idx][1]))
        );
    }

}
