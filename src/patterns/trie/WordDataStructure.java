//https://leetcode.com/problems/design-add-and-search-words-data-structure/

//| Operation         | Time          | Space          |
//| ----------------- | ------------- | -------------- |
//| addWord           | O(L)          | O(L)           |
//| search (no `.`)   | O(L)          | O(L) recursion |
//| search (with `.`) | O(26^L) worst | O(L) recursion |
//| Trie storage      | —             | O(N × L)       |

package patterns.trie;

import java.util.HashMap;
import java.util.Map;

public class WordDataStructure {

    class Trie {
        public Map<Character, Trie> children = new HashMap<>();
        String word = null;

        public Trie() {
        }

        public Trie addChild(char value) {
            if (!children.containsKey(value)) {
                children.put(value, new Trie());
            }
            return children.get(value);
        }
    }

    Trie root;

    public WordDataStructure() {
        this.root = new Trie();
    }

    public void addWord(String word) {
        Trie current = root;
        for (int index = 0; index < word.length(); index++)
            current = current.addChild(word.charAt(index));
        current.word = word;
    }

    private boolean search(String word, Trie node, int index) {
        if (index == word.length()) {
            return node.word != null;
        }

        char character = word.charAt(index);
        if (character == '.') {
            for (Trie child : node.children.values()) {
                if (search(word, child, index + 1)) return true;
            }

            return false;
        } else {
            if (!node.children.containsKey(character)) return false;
            Trie child = node.children.get(character);


            return search(word, child, index + 1);
        }
    }

    public boolean search(String word) {
        if (word == null) return false;
        return search(word, root, 0);
    }
}

//
//# 1️⃣ addWord Complexity
//
//Let **L = length of the word**
//
//Insertion into Trie processes each character once.
//
//### Time
//
//```
//O(L)
//```
//
//### Space
//
//Each new character may create a new Trie node.
//
//```
//O(L)
//```
//
//If inserting **N words**:
//
//```
//O(total characters in all words)
//```
//
//---
//
//# 2️⃣ search Complexity
//
//Let **L = search word length**
//
//### Case 1: No wildcard `.`
//
//Example:
//
//```
//search("bad")
//```
//
//Trie traversal follows one path.
//
//**Time**
//
//```
//O(L)
//```
//
//---
//
//### Case 2: With wildcard `.`
//
//Example:
//
//```
//search(".ad")
//```
//
//`.` can branch to **all children**.
//
//Worst-case branching factor = **26** (alphabet).
//
//Worst case:
//
//```
//O(26^L)
//```
//
//But this is extremely rare because:
//
//* Trie pruning stops early
//* Most nodes have few children
//
//Typical runtime is closer to:
//
//```
//O(L × branching_factor)
//```
//
//---
//
//# 3️⃣ Space Complexity
//
//### Trie storage
//
//If **N words of length L** are inserted:
//
//```
//O(N × L)
//```
//
//### Recursion patterns.stack
//
//DFS depth = word length.
//
//```
//O(L)
//```
//
//---
//
//# 4️⃣ Final Summary
//
//| Operation         | Time          | Space          |
//| ----------------- | ------------- | -------------- |
//| addWord           | O(L)          | O(L)           |
//| search (no `.`)   | O(L)          | O(L) recursion |
//| search (with `.`) | O(26^L) worst | O(L) recursion |
//| Trie storage      | —             | O(N × L)       |
//
//---
//
//💡 **Interview Insight**
//
//For **Design Add and Search Words Data Structure**, interviewers mainly expect:
//
//* Trie structure
//* DFS handling of `.`
//* Correct base condition
//* Complexity explanation: **O(26^L) worst-case**
//
//--