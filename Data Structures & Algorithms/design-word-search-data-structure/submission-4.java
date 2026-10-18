class TrieNode {
    boolean isWord;
    TrieNode[] children;
    int index;

    public TrieNode() {
        children = new TrieNode[26];
        isWord = false;
        index = 0;
    }
}

class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isWord = true;
    }

    public boolean search(String word) {
        Deque<TrieNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {

            TrieNode current = stack.pop();
            int currentIndex = current.index;

            if (currentIndex == word.length()) {
                if (current.isWord) {
                    return true;
                }
                continue;
            }

            char c = word.charAt(currentIndex);
            if (c == '.') {
                for (TrieNode child : current.children) {
                    if (child != null) {
                        child.index = currentIndex + 1;
                        stack.push(child);
                    }
                }

            } else {
                int index = c - 'a';
                if (current.children[index] != null) {
                    current.children[index].index = currentIndex + 1;
                    stack.push(current.children[index]);
                }
            }
            
        }

        return false;
    }
}
