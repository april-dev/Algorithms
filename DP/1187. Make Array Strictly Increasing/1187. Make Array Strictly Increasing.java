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

//Used the same method to solve Q1007. Minimum Domino Rotations For Equal Row
//But 1007 is not DP problem. Simple array.
public int minDominoRotations(int[] A, int[] B) {
        int res1 = helper(A, B);
        int res2 = helper(B, A);
        if (res1!=-1 && res2!=-1) return Math.min(res1, res2);
        else if (res1!=-1) return res1;
        else if (res2!=-1) return res2;
        else return -1;
    }
    public int helper(int[] A, int[] B){
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(A[0], 0);
        if (A[0]!=B[0]) dp.put(B[0], 1);
        for (int i=1; i<A.length; i++){
            Map<Integer, Integer> temp = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry: dp.entrySet()){
                int key = entry.getKey();
                int val = entry.getValue();
                int lastCount = temp.containsKey(key)? temp.get(key): Integer.MAX_VALUE;
                if (A[i]==key) temp.put(key, Math.min(lastCount, val));
                else if (B[i]==key) temp.put(key, Math.min(lastCount, val+1));
            }
            dp = temp;
        }
        if (dp.size()==0) return -1;
        int res = Integer.MAX_VALUE;
        for (int key: dp.keySet()) res = Math.min(res, dp.get(key));
        return res;
    }
