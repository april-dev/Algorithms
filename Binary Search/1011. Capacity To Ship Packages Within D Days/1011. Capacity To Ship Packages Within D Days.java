public int shipWithinDays(int[] weights, int D) {
        int left = 0, right = 0;
        for (int weight:weights){
            left = Math.max(left, weight);
            right += weight;
        }
        
        while (left<right){
            int mid = left + (right - left)/2;
            int count = 1;
            int sum = 0;
            
           /*
            for (int w:weights){
                if (sum+w>mid){
                    count+=1;
                    sum=0;
                }
                sum+=w;
            }
            */
                
            /*
            for (int w:weights){
                sum+=w;
                if (sum>mid){
                    count+=1;
                    sum=w;
                }
               
            }
            */
            for (int w:weights){
                if (sum+w>mid){
                    count+=1;
                    sum=w;
                }else{
                    sum+=w;
                }
            
            }
            
            if (count>D){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return right;
    }
