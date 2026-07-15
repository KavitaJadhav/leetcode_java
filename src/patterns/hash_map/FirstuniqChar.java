//https://leetcode.com/problems/first-unique-character-in-a-string/
//| Metric | Complexity                          |
//| ------ | ----------------------------------- |
//| Time   | **O(N)**                            |
//| Space  | **O(1)** (26 lowercase letters max) |

package patterns.hash_map;

import java.util.HashMap;
import java.util.Map;

class FirstuniqChar {
    public int firstUniqChar(String string) {
        Map<Character, Integer> charactersMap = new HashMap<>();

        for (int index = 0; index < string.length(); index++) {

            char character = string.charAt(index);
            charactersMap.put(character, charactersMap.getOrDefault(character, 0) + 1);
        }

        for (int index = 0; index < string.length(); index++) {
            if (charactersMap.get(string.charAt(index)) == 1) return index;
        }


        return -1;
    }
}