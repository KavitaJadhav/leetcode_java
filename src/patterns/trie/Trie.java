//https://leetcode.com/problems/implement-trie-prefix-tree/
// Let L = length of the word
//
//Insert
//O(L)
//Search
//O(L)
//StartsWith
//O(L)
//
//Space for Trie:
//O(total characters inserted)


package patterns.trie;

import java.util.HashMap;
import java.util.Map;

class Trie {
    class Node {
        public Map<Character, Node> children = new HashMap<>();
        String word = null;

        public Node() {
        }
    }

    Node root;

    public Trie() {
        this.root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for (int index = 0; index < word.length(); index++) {
            char character = word.charAt(index);


            if (!node.children.containsKey(character)) {
                node.children.put(character, new Node());
            }

            node = node.children.get(character);
        }
        node.word = word;
    }

    public boolean search(String word) {
        Node node = root;
        for (int index = 0; index < word.length(); index++) {
            char character = word.charAt(index);
            if (!node.children.containsKey(character)) return false;
            node = node.children.get(character);
        }

        return word.equals(node.word);
    }

    public boolean startsWith(String prefix) {
        Node node = root;
        for (int index = 0; index < prefix.length(); index++) {
            char character = prefix.charAt(index);
            if (!node.children.containsKey(character)) return false;
            node = node.children.get(character);
        }
        return true;
    }
}
