//https://leetcode.com/problems/first-unique-character-in-a-string/
//| Metric           | Value                           |
//| ---------------- | ------------------------------- |
//| Time Complexity  | **O(n)**                        |
//| Space Complexity | **O(1)** (26 lowercase letters) |

package hash_map;

class Solution {
    public int firstUniqChar(String string) {
        int[] charCount = new int[26];

        for (int index = 0; index < string.length(); index++) {

            char character = string.charAt(index);
            charCount[character - 'a']++;
        }

        for (int index = 0; index < string.length(); index++) {
            char character = string.charAt(index);

            if (charCount[character - 'a'] == 1) return index;
        }

        return -1;
    }
}