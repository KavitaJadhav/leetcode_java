//Time Complexity
//Graph build: O(N × L)
//DFS: O(C + E)
//Worst-case DFS edges E = O(C²)

//Total Time Complexity:
//O(N×L+C+E)=O(N×L+C2) - C2 = c square
//Practically, C ≤ 26 (letters a–z), so DFS is effectively O(N × L) in interviews.

//Space Complexity
//Graph (dependencyMap) → O(C + E) ≈ O(C²) worst case
//DFS recursion stack → O(C)
//Visiting + visited sets → O(C)
//Result string → O(C)

//
//✅ Total Space Complexity: O(C²) worst case, practically O(26²) = negligible

//6️⃣ Summary Table
//Component	Time Complexity	Space Complexity
//Build graph	O(N × L)	O(C + E) ≈ O(C²)
//DFS traversal	O(C + E) ≈ O(C²)	O(C) recursion stack
//Total	O(N × L + C²)	O(C²)


package graph;

import java.util.*;

public class AlienDictionaryReversed {
    private String order_chars(String[] words) {
        StringBuilder result = new StringBuilder();

        Map<Character, List<Character>> dependencyMap = buildDependencyMap(words);

        Set<Character> letters = new HashSet<>(dependencyMap.keySet());
        Set<Character> visited = new HashSet<>();
        Set<Character> visiting = new HashSet<>();
        for (Character letter : letters) {
            if (!dfs(letter, dependencyMap, result, visited, visiting)) return "";
        }
        return result.reverse().toString();
    }

    private boolean dfs(Character letter, Map<Character, List<Character>> dependencyMap, StringBuilder result, Set<Character> visited, Set<Character> visiting) {
        if (visiting.contains(letter)) return false;
        if (visited.contains(letter)) return true;
        List<Character> dependencies = dependencyMap.get(letter);

        visiting.add(letter);
        for (Character dependency : dependencies) {
            if (!dfs(dependency, dependencyMap, result, visited, visiting)) return false;
        }
        visiting.remove(letter);
        result.append(letter);
        visited.add(letter);

        return true;
    }

    private Map<Character, List<Character>> buildDependencyMap(String[] words) {
        Map<Character, List<Character>> dependencyMap = new HashMap<>();
        for (String word : words) {
            for (char letter : word.toCharArray()) {
                dependencyMap.putIfAbsent(letter, new ArrayList<>());
            }
        }


        for (int word_index = 0; word_index < words.length - 1; word_index++) {
            String word1 = words[word_index];
            String word2 = words[word_index + 1];

            int min_length = Math.min(word1.length(), word2.length());

            for (int char_index = 0; char_index < min_length; char_index++) {
                char char2 = word2.charAt(char_index);
                char char1 = word1.charAt(char_index);
                if (char1 != char2) {
                    dependencyMap.get(char1).add(char2);
                    break;
                }
            }
        }
        return dependencyMap;
    }

    public static void main(String[] args) {
        AlienDictionaryReversed alienDictionary = new AlienDictionaryReversed();
        System.out.println(alienDictionary.order_chars(new String[]{"wrt", "wrf", "er", "ett", "rftt"}));
    }
}
