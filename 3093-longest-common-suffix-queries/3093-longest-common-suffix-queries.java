class Solution {

    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        int bestIdx = -1;
    }

    TrieNode root = new TrieNode();

    private boolean better(String[] words, int a, int b) {
        if (b == -1) return true;

        if (words[a].length() != words[b].length()) {
            return words[a].length() < words[b].length();
        }

        return a < b;
    }

    private void insert(String word, int idx, String[] words) {
        TrieNode node = root;

        if (better(words, idx, node.bestIdx)) {
            node.bestIdx = idx;
        }

        for (int i = word.length() - 1; i >= 0; i--) {
            int c = word.charAt(i) - 'a';

            if (node.child[c] == null) {
                node.child[c] = new TrieNode();
            }

            node = node.child[c];

            if (better(words, idx, node.bestIdx)) {
                node.bestIdx = idx;
            }
        }
    }

    private int query(String word) {
        TrieNode node = root;

        for (int i = word.length() - 1; i >= 0; i--) {
            int c = word.charAt(i) - 'a';

            if (node.child[c] == null) {
                break;
            }

            node = node.child[c];
        }

        return node.bestIdx;
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {

        for (int i = 0; i < wordsContainer.length; i++) {
            insert(wordsContainer[i], i, wordsContainer);
        }

        int[] ans = new int[wordsQuery.length];

        for (int i = 0; i < wordsQuery.length; i++) {
            ans[i] = query(wordsQuery[i]);
        }

        return ans;
    }
}