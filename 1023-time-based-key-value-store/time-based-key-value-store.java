class TimeMap {

    private static class Data {
        String value;
        int timestamp;

        Data(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    private HashMap<String, List<Data>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Data(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        
        List<Data> list = map.get(key);
        int start = 0;
        int end = list.size() - 1;
        String res = "";
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (list.get(mid).timestamp <= timestamp) {
                res = list.get(mid).value;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return res;
    }
}