class TrieNode {
    TrieNode[] children;
    boolean isWord;
    int endCount;
    public TrieNode(){
        children = new TrieNode[26];
        isWord = false;
        endCount = 0;
    }
}

class Solution {
    TrieNode root = new TrieNode();
    public int[] sumPrefixScores(String[] words) {
        int[] res = new int[words.length];
        for(String word : words){
            TrieNode current = root;
            for(int i = 0; i < word.length(); i++){
                int charIndex = word.charAt(i) - 'a';
                if(current.children[charIndex] == null){
                    current.children[charIndex] = new TrieNode();
                }
                current = current.children[charIndex];
                current.endCount ++;
            }
            current.isWord = true;
        }

        for(int w = 0; w < words.length; w++){
            TrieNode current = root;
            int sum = 0;
            for(int i = 0; i < words[w].length(); i++){
                int index = words[w].charAt(i) - 'a';
                current = current.children[index];
                sum += current.endCount;
            }
            res[w] = sum;
        }

        return res;
    }
}
