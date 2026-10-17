class TrieNode {
    TrieNode[] children;
    public TrieNode() {
        children = new TrieNode[26];
    }
}

class Solution {
    TrieNode root = new TrieNode();
    public int prefixCount(String[] words, String pref) {
        int res = 0;
        for (String word : words) {
            insert(word);
            if(startsWith(pref)){
                res++;
                System.out.println(word);
            }
            root = new TrieNode();
        }
        return res;
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return true;
    }
}