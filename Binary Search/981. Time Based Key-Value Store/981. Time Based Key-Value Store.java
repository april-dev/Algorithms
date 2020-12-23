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
class Date{
        String value;
        int stamp;
    public Date(String value, int stamp){
        this.value = value;
        this.stamp = stamp;
    }
    }
class TimeMap {
    HashMap<String, List<Date>> map;
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
        int prev = binarySearch(timestamp, map.get(key));
        if (prev<0) return "";
        return map.get(key).get(prev).stamp<=timestamp?map.get(key).get(prev).value:"";
    }
    public int binarySearch(int timestamp,List<Date> list){
        int left = 0, right = list.size()-1;
        while (left<right){
            int mid = left + (right - left)/2 + 1;
            if (list.get(mid).stamp>timestamp) right = mid - 1;
            else left = mid;            
        }
        return right;
    }
}
