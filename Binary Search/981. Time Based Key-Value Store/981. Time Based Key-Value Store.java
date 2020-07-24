class Date{
        String value;
        int stamp;
        public Date(String value, int stamp){
            this.value = value;
            this.stamp = stamp;
        }
    }

class TimeMap {
    Map<String, List<Date>> map;
    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Date(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        int prev = binary(map.get(key), timestamp);
        return prev< 0 ? "":map.get(key).get(prev).value;
    }
    public int binary(List<Date> key, int target){
        int left = 0, right = key.size()-1;
        while (left<=right){
            int mid = left + (right - left)/2;
            if (key.get(mid).stamp==target){
                return mid;
            }else if (key.get(mid).stamp>target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left-1;
    }
}


//alternative binary search
protected String binarySearch(List<Data> list, int time) {
        int low = 0, high = list.size() - 1;
        while (low < high) {
            int mid = (low + high) >> 1;
            if (list.get(mid).time == time) return list.get(mid).val;
            if (list.get(mid).time < time) {
                if (list.get(mid+1).time > time) return list.get(mid).val;
                low = mid + 1;
            }
            else high = mid -1;
        }
        return list.get(low).time <= time ? list.get(low).val : "";
    }
    
 //alternative binary search
 String binarySearch(List<Data> list, int time) {
        int low = 0, high = list.size() - 1;
        while (low < high) {
            int mid = (low + high + 1) >> 1;
            if (list.get(mid).time <= time)  
                low = mid;
            else 
                high = mid -1;
        }
        return list.get(low).time <= time ? list.get(low).val : "";  // low == high
    }
