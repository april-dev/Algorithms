class RandomizedSet {
    ArrayList<Integer> nums;
    HashMap<Integer, Integer> map;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        nums = new ArrayList<>();
        map = new HashMap<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, nums.size());
        nums.add(val);
        return true;   
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int idx = map.get(val);
        if (idx < nums.size()-1){
            int last = nums.get(nums.size()-1);
            nums.set(idx, last);
            map.put(last, idx);
        }
        map.remove(val);
        nums.remove(nums.size()-1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int max = nums.size();
        int min = 0;
        int idx = (int) (Math.random()*(max-min)+ min);
        return nums.get(idx);
    }
}
