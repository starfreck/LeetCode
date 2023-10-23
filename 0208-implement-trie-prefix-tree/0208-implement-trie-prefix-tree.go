type TrieNode struct {
	children map[rune]*TrieNode
	terminal bool
}

type Trie struct {
    root *TrieNode
}


func Constructor() Trie {
    return Trie{
        root: &TrieNode{
            children: make(map[rune]*TrieNode),
			terminal: false,
        },
    }
}


func (trie *Trie) Insert(word string)  {
    // word =  strings.ToLower(word)
	node := trie.root
	for _ , char := range (word)   {
		// Create a new node if it doesn't already exist
		if node.children[char] == nil {
			node.children[char] = &TrieNode{
				children: make(map[rune]*TrieNode),
				terminal: false,
			}
		}
		// Update the node and set the last node
		node = node.children[char]
		// fmt.Printf("index %d and char is %c\n",index,char)
	}
	node.terminal = true;
}


func (trie *Trie) Search(word string) bool {
    // word =  strings.ToLower(word)
	node := trie.root
	for _, char := range word {
		if node.children[char] != nil {
			node = node.children[char]
		} else {
			return false
        }
	}
	return node.terminal
}


func (trie *Trie) StartsWith(prefix string) bool {
    // word =  strings.ToLower(word)
	node := trie.root
	for _, char := range prefix {
		if node.children[char] != nil {
			node = node.children[char]
		} else {
			return false
        }
	}
    return true
}


/**
 * Your Trie object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Insert(word);
 * param_2 := obj.Search(word);
 * param_3 := obj.StartsWith(prefix);
 */