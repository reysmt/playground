class TrieNode {
    public boolean isWord;
    public TrieNode[] children;
    public TrieNode () {
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
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(current.children[index] == null){
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isWord = true;
    }

    public boolean search(String word) {
        return dfs(word, root, 0);
    }

    private boolean dfs(String word, TrieNode root, int index){
        TrieNode cur = root;

        for(int i = index; i < word.length(); i++){
            char c = word.charAt(i);

            if(c == '.'){

                for(TrieNode child : cur.children) {
                    if(child != null && dfs(word, child, i + 1)){
                        return true;
                    }
                }
                return false;

            }else{

                if(cur.children[c - 'a'] == null){
                    return false;
                }
                cur = cur.children[c - 'a'];
                
            }
        }
        return cur.isWord;
    }
}
