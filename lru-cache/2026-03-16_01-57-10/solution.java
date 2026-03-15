class ListNode{
    int key;
    int val;
    ListNode prev;
    ListNode next;
    ListNode(int key, int val){
        this.key = key;
        this.val = val;
    }
}
class LRUCache {
    Map<Integer, ListNode> map;
    ListNode left, right;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.left = new ListNode(0, 0);
        this.right = new ListNode(0, 0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    private void addNodeLeft(ListNode node){
        ListNode nextNode = this.left.next;
        this.left.next = node;
        node.next = nextNode;
        node.prev = this.left;
        nextNode.prev = node;
    }

    private void removeNode(ListNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public int get(int key) {
        if(this.map.containsKey(key)){
            ListNode node = this.map.get(key);
            removeNode(node);
            addNodeLeft(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(this.map.containsKey(key)){
            ListNode node = this.map.get(key);
            removeNode(node);
        }
        ListNode newNode = new ListNode(key, value);
        addNodeLeft(newNode);
        this.map.put(key, newNode);
        if(this.map.size() > this.capacity){
            this.map.remove(this.right.prev.key);
            removeNode(this.right.prev);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */