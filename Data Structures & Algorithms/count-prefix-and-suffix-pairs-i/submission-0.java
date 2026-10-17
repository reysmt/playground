

class TrieNode {
    HashMap<Integer, TrieNode> children = new HashMap<>();
    int endCount = 0; // quante parole già inserite terminano esattamente qui
}

class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        TrieNode root = new TrieNode(); // locale: niente stato condiviso tra chiamate
        int res = 0;

        for (String w : words) {
            int n = w.length();
            TrieNode node = root;

            for (int i = 0; i < n; i++) {
                // codifico la coppia (prefisso, suffisso) in un solo intero
                int key = (w.charAt(i) - 'a') * 26 + (w.charAt(n - 1 - i) - 'a');

                node = node.children.computeIfAbsent(key, k -> new TrieNode());

                // ogni parola precedente che finisce in questo nodo
                // è sia prefisso sia suffisso di w
                res += node.endCount;
            }

            node.endCount++; // inserisco w solo dopo averla interrogata
        }
        return res;
    }
}