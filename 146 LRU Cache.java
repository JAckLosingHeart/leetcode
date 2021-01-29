class LRUCache {

    int capacity;
    int[] pair = new int[3001];
    LinkedList<Integer> cache = new LinkedList<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        Arrays.fill(pair, -1);
    }

    public int get(int key) {
        int value = pair[key];
        if (value != -1) {
            cache.remove((Integer)key);
            cache.addFirst(key);
        }
        return value;
    }

    public void put(int key, int value) {
        if (get(key) != -1) {
            pair[key] = value;
            return;
        }
        if (cache.size() >= capacity) {
            pair[cache.getLast()] = -1;
            cache.removeLast();
        }
        cache.addFirst(key);
        pair[key] = value;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */