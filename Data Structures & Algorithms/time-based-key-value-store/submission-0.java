class TimeMap {
    HashMap<String, String> pair;
    HashMap<String, Integer> otherPair;
    public TimeMap() {
        pair = new HashMap<String,String>();
        otherPair = new HashMap<String, Integer>();
    }
    
    public void set(String key, String value, int timestamp) {
        pair.put(key, value + "-" + Integer.toString(timestamp));
        otherPair.put(key, timestamp);
    }
    
    public String get(String key, int timestamp) {
        String value = pair.get(key);
        if(value == null){
            return null;
        }

        String[] splitted = value.split("-");
        String time = splitted[1];

        Integer otherPairTs = otherPair.get(key);

        if(Integer.parseInt(time) == otherPairTs){
            return splitted[0];
        }

        return splitted[0]; 
    }
}
