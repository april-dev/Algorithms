class RandomizedCollection {
    HashMap<Integer, List<Integer>> map;
    List<int[]> nums;
        private Random rnd;


    public RandomizedCollection() {
        map = new HashMap<>();
        nums = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        boolean res = !map.containsKey(val);
        if (res)  map.put(val, new ArrayList<>());
        map.get(val).add(nums.size());
        nums.add(new int[]{val, map.get(val).size()-1});
        return res;            
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int numsIdx = map.get(val).get(map.get(val).size()-1);
        int[] swap = nums.get(nums.size()-1);
        int swapVal = swap[0], swapIdx = swap[1];
        
        nums.set(numsIdx, swap);
        map.get(swapVal).set(swapIdx, numsIdx);

        if (map.get(val).size()==1) map.remove(val);
        else map.get(val).remove(map.get(val).size()-1);
        
        nums.remove(nums.size()-1);
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        int max = nums.size();
        int min = 0;
        int idx = (int)(Math.random()*(max-min)+min);
        return nums.get(idx)[0];
    }
}
