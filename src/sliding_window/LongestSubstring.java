//https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/1943901975/
//https://github.com/KavitaJadhav/data_structure_questions/blob/main/ds_patterns/sliding_window/large_substring.rb
// | Aspect | Complexity                                       |
//| ------ | ------------------------------------------------ |
//| Time   | O(n) – each character is visited once            |
//| Space  | O(min(n, charset)) – HashMap stores unique chars |

        package sliding_window;

import java.util.*;

class LongestSubstring {
    public int lengthOfLongestSubstring(String string) {
        if (string == null) return 0;

        int maxSize = 0;
        int left = 0;
        Map<Character, Integer> charMap = new HashMap<>();

        for (int right = 0; right < string.length(); right++) {
            char character = string.charAt(right);

            if (charMap.containsKey(character) && charMap.get(character) >= left) {
                left = charMap.get(character) + 1;
            }
            maxSize = Math.max(maxSize, ((right - left) + 1));

            charMap.put(character, right);
        }
        return maxSize;
    }

    public static void main(String[] args) {
        LongestSubstring longestSubstring = new LongestSubstring();
        System.out.println(longestSubstring.lengthOfLongestSubstring(""));
        System.out.println(longestSubstring.lengthOfLongestSubstring(" "));
        System.out.println(longestSubstring.lengthOfLongestSubstring("a"));
        System.out.println(longestSubstring.lengthOfLongestSubstring("aaa"));
        System.out.println(longestSubstring.lengthOfLongestSubstring("abcabc"));
        System.out.println(longestSubstring.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(longestSubstring.lengthOfLongestSubstring("abcdabcdefabcde"));
    }
}