//🔥 Show optimized Word Ladder
//
//🔥 Show bidirectional BFS (very important for big interviews)
//
//🔥 Walk through dry run step-by-step
//
//🔥 Give you production-ready BFS template to memorize

//Complexity
//Time: O(N × L) (N = words, L = word length)
//Space: O(N × L) for pattern map + BFS queue

package graph;

import java.util.*;

public class WordLadderOptimized {
    public Map<String, List<String>> buildPatternMap(List<String> words) {
        Map<String, List<String>> patternMap = new HashMap<>();

        String pattern;
        for (String word : words) {
            for (int index = 0; index < word.length(); index++) {
                pattern = word.substring(0, index) + "*" + word.substring(index + 1);
                patternMap.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }
        return patternMap;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        if (beginWord.equals(endWord)) return 0;

        Map<String, List<String>> patternMap = buildPatternMap(wordList);


        Set<String> wordSet = new HashSet<>(wordList);
        Queue<String> queue = new ArrayDeque<>();
        queue.add(beginWord);

        int transformations = 1;
        String current_word;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int counter = 1; counter <= levelSize; counter++) {
                current_word = queue.remove();

                for (int index = 0; index < current_word.length(); index++) {
                    String pattern = current_word.substring(0, index) + "*" + current_word.substring(index + 1);

                    if (!patternMap.containsKey(pattern)) continue;
                    for (String word : patternMap.get(pattern)) {
                        if (wordSet.contains(word)) {
                            if (word.equals(endWord)) return transformations + 1;
                            queue.add(word);
                            wordSet.remove(word);
                        }
                    }
                }
            }
            transformations++;
        }
        return 0;
    }


    public static void main(String[] args) {
        WordLadderOptimized wordLadder = new WordLadderOptimized();
        System.out.println(wordLadder.ladderLength("hit", "hot", new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"))));
        System.out.println(wordLadder.ladderLength("hit", "cog", new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"))));
        System.out.println(wordLadder.ladderLength("hit", "cog", new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log"))));
        System.out.println(wordLadder.ladderLength("hit", "hit", new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log"))));
        System.out.println(wordLadder.ladderLength("hit", "xyz", new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log"))));
    }

}
