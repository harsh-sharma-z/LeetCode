class MyHashMap {
    HashMap<Integer , Integer> uwu;
    public MyHashMap() {    
        uwu = new HashMap<>();
    }
    
    public void put(int key, int value) {
        uwu.put(key , value);
    }
    
    public int get(int key) {
        return uwu.getOrDefault(key , -1);
    }
    
    public void remove(int key) {
        uwu.remove(key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */