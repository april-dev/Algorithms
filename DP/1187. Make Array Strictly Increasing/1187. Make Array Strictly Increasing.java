class Solution {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Map<Integer, Integer> dp = new HashMap<Integer, Integer>();
        dp.put(-1, 0);
        Arrays.sort(arr2);
        
        for (int a1: arr1){
            Map<Integer, Integer> temp = new HashMap<Integer, Integer>();
            for (Map.Entry<Integer, Integer> entry : dp.entrySet()){
                int key = entry.getKey();
                int val = entry.getValue();
                if (a1>key){
                    int lastCount = temp.containsKey(a1)? temp.get(a1):Integer.MAX_VALUE;
                    temp.put(a1, Math.min(val, lastCount));
                }
                int idx = binarySearch(key, arr2);
                if (idx != arr2.length){
                    int lastCount = temp.containsKey(arr2[idx])? temp.get(arr2[idx]):Integer.MAX_VALUE;
                    temp.put(arr2[idx], Math.min(val+1, lastCount));
                }
                
            }
            dp = temp;
        }
        if (dp.size()==0) return -1;
        int res = Integer.MAX_VALUE;
        for (int key:dp.keySet()) res = Math.min(res, dp.get(key));
        return res;        
    }
    
    public int binarySearch(int target, int[] arr){
        // right = arr.length - 1 is not correct, the target is equal to the last element, then left = mid + 1 = right (arr.length)
        int left = 0, right = arr.length;
        while (left < right){
            int mid = left + (right - left)/2;
            //search for the next greater element than target
            if (arr[mid]<=target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }
    
}
