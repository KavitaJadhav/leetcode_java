//🔥 Show optimized Word Ladder
//
//🔥 Show bidirectional BFS (very important for big interviews)
//
//🔥 Walk through dry run step-by-step
//
//🔥 Give you production-ready BFS template to memorize

//Complexity
//Let N = number of words, L = word length
//Time: O(N² × L) — for every word, compare with all others character by character
//Space: O(N) — queue + set

package graph;

import java.util.*;

public class WordLadder {
    private boolean isTransformatinWord(String from, String to) {
        int difference_count = 0;
        for (int i = 0; i < from.length(); i++) {
            if (from.charAt(i) != to.charAt(i)) difference_count++;
        }
        return difference_count == 1;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        if (beginWord.equals(endWord)) return 0;

        Set<String> wordSet = new HashSet<>(wordList);
        Queue<String> queue = new ArrayDeque<>();
        queue.add(beginWord);

        int transformations = 1;
        String current_word;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int counter = 1; counter <= levelSize; counter++) {
                current_word = queue.remove();

                for (String word : new HashSet<>(wordSet)) {
                    if (isTransformatinWord(current_word, word)) {
                        if (word.equals(endWord)) return transformations + 1;
                        queue.add(word);
                        wordSet.remove(word);
                    }
                }
            }
            transformations++;
        }
        return 0;
    }


    public static void main(String[] args) {
        WordLadder wordLadder = new WordLadder();
        System.out.println(wordLadder.ladderLength("hit", "hot", new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"))));
        System.out.println(wordLadder.ladderLength("hit", "cog", new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"))));
        System.out.println(wordLadder.ladderLength("hit", "cog", new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log"))));
        System.out.println(wordLadder.ladderLength("hit", "hit", new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log"))));
        System.out.println(wordLadder.ladderLength("hit", "xyz", new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log"))));
    }

}
