class LRUCache {

    
    class Node {
		int key;
		int val;
		Node pre,next;

		Node(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}

	int capacity, size;
	Node head, tail;
	HashMap<Integer,Node> map;

	public LRUCache(int capacity){

		this.size = 0;
		this.capacity = capacity;

		this.head = new Node(0,0);
		this.tail = new Node(0,0);

		this.head.next = tail;
		this.tail.pre = head;

		this.map = new HashMap<>();
	}

	// O(1)
	// Add at the start (at Head)
	private void add(Node node){
		node.pre = head;
		node.next = head.next;
		head.next.pre = node;
		head.next = node;
	}


	// O(1)
	// Remove the Node 
	private void remove(Node node){
		node.pre.next = node.next;
		node.next.pre = node.pre;
	}

	// O(1)
	// Move Node to front
	private void update(Node node){
		remove(node);
		add(node);
	}
    
    // Return the value of the key if the key exists,
    // otherwise return -1
	// O(1)
	public int get(int key){

		Node node = map.get(key);

		if(node == null) return -1;

		// Move Node to front
		update(node);

		return node.val;

	}
    
    // Update the value of the key if the key exists.
    // Otherwise, add the key-value pair to the cache.
    // If the number of keys exceeds the capacity from this operation,       
    // evict the least recently used key.
	// O(1)
	public void put(int key, int value){

		Node node = map.get(key);

		if(node == null){
			
			node = new Node(key,value);
			// Add to the front
			add(node);
			// Add to Map
			map.put(key,node);
			size++;

		} else{
			// Update the Value
			node.val = value;
			// Update the Node in List
			update(node);

		}

		if(size > capacity) {
			Node temp = tail.pre;
			remove(temp);
			map.remove(temp.key);
			size--;
		}

	}
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */