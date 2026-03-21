//| Solution                 | Time Complexity                            | Space Complexity | Notes                                                                        |
//| ------------------------ | ------------------------------------------ | ---------------- | ---------------------------------------------------------------------------- |
//| Original substring-check | O(n × m²)                                  | O(n × m)         | Checks all rotations for each string using substring                         |
//| Canonical key map        | O(n × m²) (current) → O(n × m) (optimized) | O(n × m)         | Groups by lexicographically smallest rotation; faster if no substring copies |

//Todo: forgot this approach. revisit.
package string_rotation;

import java.util.*;

public class GroupRotatedStringsOptimised {

    // Returns lexicographically smallest rotation of a string
    private String getCanonical(String string) {
        String doubled = string + string;
        String minRotation = string;

        for (int index = 1; index < string.length(); index++) {
            String rotation = doubled.substring(index, index + string.length());
            if (rotation.compareTo(minRotation) < 0) {
                minRotation = rotation;
            }
        }
        return minRotation;
    }

    private List<List<String>> group(List<String> list) {
        List<List<String>> result = new ArrayList<>();
        if (list == null || list.isEmpty()) return result;

        Map<String, List<String>> map = new HashMap<>();

        for (String string : list) {
            String key = getCanonical(string);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(string);
        }

        result.addAll(map.values());
        return result;
    }

    public static void main(String[] args) {
        GroupRotatedStrings groupRotatedStrings = new GroupRotatedStrings();
        List<String> list = Arrays.asList("abc", "bca", "cab", "xyz", "yzx", "cba", "aaaa");

        System.out.println(groupRotatedStrings.group(list));
    }
}