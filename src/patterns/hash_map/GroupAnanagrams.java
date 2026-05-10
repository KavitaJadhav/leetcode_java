//https://leetcode.com/problems/group-anagrams/
// ✅ Total Time Complexity
//O(N⋅K)
//N = number of strings
//K = maximum length of a string
//Using sorted string as key would be slightly slower: O(N * K log K), because sorting each string costs O(K log K).
//
//2️⃣ Space Complexity
//
//HashMap: stores all strings grouped by key → O(N * K)
//Keys: 26-length string (constant)
//Values: all strings → O(N * K)
//Character count array: O(26) = O(1) per string
//| Complexity | Value        |
//| ---------- | ------------ |
//| Time       | `O(N × K)` ✅ |
//| Space      | `O(N × K)` ✅ |

package patterns.hash_map;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class GroupAnanagrams {
    public List<List<String>> groupAnagrams(String[] strings) {
        HashMap<String, List<String>> anagramsMap = new HashMap<>();

        for (String string : strings) {
            int[] numbers = new int[26];

            for (int index = 0; index < string.length(); index++) {
                numbers[string.charAt(index) - 'a']++;
            }

            String key = Arrays.toString(numbers);  // convert char counts to key
            anagramsMap.putIfAbsent(key, new ArrayList<>()); // ensure key exists
            anagramsMap.get(key).add(string);
        }

        return new ArrayList<>(anagramsMap.values());
    }
}