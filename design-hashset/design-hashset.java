class MyHashSet {
    int size=(int)(1000001);
    boolean[] data;
    public MyHashSet() {
        data=new boolean[size];
    }
    
    public void add(int key) {
        data[key]=true;
    }
    
    public void remove(int key) {
        data[key]=false;
    }
    
    public boolean contains(int key) {
        return data[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */