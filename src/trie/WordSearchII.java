//️⃣ Time Complexity
//m = rows
//n = columns
//k = number of words
//L = maximum word length

//Time -         O(kL + mn × 4^L)
//Space -        O(kL + mn)


//Trie construction
//Each word inserted character by character.
//O(k × L)
//
//DFS Search
//For each board cell we start DFS.
//Worst case:
//O(m × n × 4^L)
//
//Explanation:
//Each DFS explores up to 4 directions
//Depth limited by maximum word length
//However, Trie pruning stops many paths early, so practical runtime is much smaller.

//Space Complexity
//Trie storage
//O(k × L)
//Recursion stack
//O(L)
//Board
//O(m × n)
//Total:
//O(kL + mn)

package trie;

import java.util.*;

public class WordSearchII {
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

    class WordSearch {
        char[][] board;
        Trie root;
        List<String> result = new ArrayList<>();

        public WordSearch(char[][] board) {
            this.board = board;
            this.root = new Trie();
        }

        public List<String> find_words(String[] words) {


            for (String word : words) {
                insertInTrie(word);
            }


            int rows = board.length;
            int columns = board[0].length;
            for (int iIndex = 0; iIndex < rows; iIndex++) {
                for (int jIndex = 0; jIndex < columns; jIndex++) {
                    dfs(root, board, iIndex, jIndex);

                }
            }
            return result;
        }

        private void dfs(Trie trie, char[][] board, int iIndex, int jIndex) {
            int rows = board.length;
            int columns = board[0].length;

            if (iIndex < 0 || iIndex >= rows || jIndex < 0 || jIndex >= columns) return;
            char cellValue = board[iIndex][jIndex];

            if (cellValue == '#') return;

            if (!trie.children.containsKey(cellValue)) return;

            Trie child = trie.children.get(cellValue);
            if (child.word != null) {
                result.add(child.word);
                child.word = null;
            }

            board[iIndex][jIndex] = '#';
            dfs(child, board, iIndex + 1, jIndex);
            dfs(child, board, iIndex - 1, jIndex);
            dfs(child, board, iIndex, jIndex + 1);
            dfs(child, board, iIndex, jIndex - 1);

            board[iIndex][jIndex] = cellValue;
//            Pruning tree to avoid vising nodes again. improve performance.
            if (child.children.isEmpty()) {
                trie.children.remove(cellValue);
            }
        }

        private void insertInTrie(String word) {
            Trie current = root;
            for (int index = 0; index < word.length(); index++)
                current = current.addChild(word.charAt(index));
            current.word = word;

        }

    }


    public List<String> findWords(char[][] board, String[] words) {
        return new WordSearch(board).find_words(words);
    }
}