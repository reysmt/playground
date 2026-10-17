class TrieNode {
    boolean isWord;
    TrieNode[] children;

    public TrieNode() {
        children = new TrieNode[26];
        isWord = false;
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
        return dfs(root, word, 0);
    }

    private boolean dfs(TrieNode current, String word, int index) {
        TrieNode node = current;

        for (int i = index; i < word.length(); i++) {
            char c = word.charAt(i);

            if (c == '.') {
                
                for(TrieNode child : node.children){
                    if(child != null && dfs(child, word, i + 1)){
                        return true;
                    }
                }
                return false;

            } else {
                int trieIndex = c - 'a';
                if(node.children[trieIndex] == null){
                    return false;
                }
                node = node.children[trieIndex];
            }
        }
        return node.isWord;
    }
}
