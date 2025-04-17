class LRUCache {

    class Node {
        int key;
        int val;

        Node prev;
        Node next;

        Node(int key , int val) {
            this.key = key;
            this.val = val;
        }
    }

    public Node[] map;
    public int count , capacity;
    public Node head, tail;

    public LRUCache(int capacity) {

        this.capacity = capacity;
        count = 0;

        map = new Node[10000 + 1];

        head = new Node(0 , 0);
        tail = new Node(0 , 0);
        
        head.next = tail;
        tail.prev = head;

        head.prev = null;
        tail.next = null;
        
    }
    
    public int get(int key) {

        if(map[key] == null) {
            return -1;
        }

        Node node = map[key];

        int nodeVal = node.val;

        deleteNode(node);
        addToHead(node);

        return nodeVal;
        
    }
    
    public void put(int key, int value) {

        if(map[key] != null) {
            Node node = map[key];

            node.val = value;

            deleteNode(node);
            addToHead(node);
        }
        else {
            Node node = new Node(key , value);

            map[key] = node;

            if(count < capacity) {
                count++;
                addToHead(node);
            }
            else {
                map[tail.prev.key] = null;
                deleteNode(tail.prev);

                addToHead(node);
            }
        }

        return;
    }

    public void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;

        return;
    }

    public void addToHead(Node node) {
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;

        head.next = node;
        
        return;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */