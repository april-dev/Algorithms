//Two solutions are the same.
//consider 0....N.........N....N....N....N....0
// index   a    b         c    d    e    f    g
//N means negative number. If number of N is odd, then max len is between (index (a+1) to  index(f-1)) and (index (b+1) to  index(g-1)) 
//contest solution
 public int getMaxLen(int[] nums) {
        int i=0;
        int len = 0;
        int prod = 1;
        List<int[]> list = new ArrayList<>();
        for (int j=0; j<=nums.length; j++){
            if (j==nums.length || nums[j]==0){
                
                if (!list.isEmpty()){
                    if (list.size()%2==0){
                        len = Math.max(len, j-1-list.get(0)[0]+1);
                    }else{
                        len = Math.max(len, j-1-(list.get(0)[1]+1)+1);
                        len = Math.max(len, list.get(list.size()-1)[1]-1-list.get(0)[0]+1);            
                    }
                }else{
                    len = Math.max(len, j-1-i+1);
                }
                i=j+1;
                list = new ArrayList<>();
                continue;
            }
            if (nums[j]<0){
                list.add(new int[]{i, j});
                i=j+1;
                continue;
            }
            
        }
        return len;
    }
    
    //Simpler solution
    public int getMaxLen(int[] nums) {
        // sum is used to count the number of negative numbers from zeroPosition to current index
        int firstNegative = -1, zeroPosition = -1, sum = 0, max = 0;
        for(int i = 0;i < nums.length; i++){
            if(nums[i] < 0){
                sum++;
				// we only need to know index of first negative number
                if(firstNegative == -1) firstNegative = i;
            }
			// if current number is 0, we can't use any element from index 0 to i anymore, so update zeroPosition, and reset sum and firstNegative. If it is a game, we should refresh the game when we meet 0. 
            if(nums[i] == 0){
                sum = 0;
                firstNegative = -1;
                zeroPosition = i;
            }
            else{
			    // consider index of zero
                if(sum%2 == 0) max = Math.max(i - zeroPosition, max);
				// consider index of first negative number
                else max = Math.max(i - firstNegative, max);   
            }
        }
        return max;
    }
