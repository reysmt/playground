class TrieNode {
    TrieNode[] children;
    int prefCount;
    public TrieNode() {
        children = new TrieNode[26];
        prefCount = 0;
    }
}

class Solution {
    TrieNode root = new TrieNode();
    public int prefixCount(String[] words, String pref) {
        int res = 0;
        for (String word : words) {
            insert(word);
        }
        return countStartsWith(pref);
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
            node.prefCount++;
        }
    }

    public int countStartsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (node.children[index] == null) {
                return 0;
            }
            node = node.children[index];
        }
        return node.prefCount;
    }
}