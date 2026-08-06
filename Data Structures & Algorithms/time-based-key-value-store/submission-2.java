class TimeMap {
    HashMap<String, ArrayList<Pair<Integer, String>>> map;
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair<>(timestamp, value));

    }

    public String get(String key, int timestamp) {
        
        if(!map.containsKey(key)) return "";
        ArrayList<Pair<Integer,String>> list = map.get(key);
        return binearySearch(timestamp,list);
    }
    private String binearySearch(int timestamp, ArrayList<Pair<Integer,String>> list){
        int left = 0, right = list.size() - 1;
        while(left <= right){
            int pivot = left + (right - left) / 2;
            int val = list.get(pivot).getKey();
            if(val > timestamp){
                // its on the left
                right = pivot - 1;
            }else{
                // this maybe correct
                left = pivot + 1;
            }
        }
        if(right == -1) return "";
        return list.get(right).getValue();
    }
}
