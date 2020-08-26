//equivalent to finding longest length of subarrays with at most 2 different numbers


//Time O(N), Space O(2) (at most 3 entry in hashmap)
public int totalFruit(int[] tree) {
        Map<Integer, Integer> map = new HashMap<>();
        int i=0, j=0;
        int res=0;
        for (j=0; j<tree.length; j++){
            map.put(tree[j], map.getOrDefault(tree[j],0)+1);
            while (map.size()>2){
                map.put(tree[i], map.get(tree[i])-1);
                if (map.get(tree[i])==0) map.remove(tree[i]);
                i++; 
            }          
            res = Math.max(res, j-i+1);
        }
        return res;
    }
    
  //Time O(N), Space O(N)(could contain all unique numbers in the hashmap);
  //This solution return longest splution becasue
  /*
[i,j] is the sliding window, and it's the current longest window.
Suppose we found current longest window [i, j], then this length will be kept, because,
as j++, if the sliding window contains more than 2, then also we will do i++, so that is to say, the current longest length will be kept the same,
in another word, when [i,j] reached a maximum, it will not become smaller
on the other side, when j++, if the current window contains less than two, then i will not increase(because the if statement), in this way, the longest length of sliding window will get updated
*/  
  
  public int totalFruit(int[] tree) {
        Map<Integer, Integer> count = new HashMap<>();
        int i = 0, j;
        for (j = 0; j < tree.length; ++j) {
            count.put(tree[j], count.getOrDefault(tree[j], 0) + 1);
            if (count.size() > 2) {
                count.put(tree[i], count.get(tree[i]) - 1);
                count.remove(tree[i++], 0);
            }
        }
        return j - i;
    }
