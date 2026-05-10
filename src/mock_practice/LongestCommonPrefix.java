//https://leetcode.com/problems/longest-common-prefix/
//This is the classic Longest Common Prefix (LCP) problem.
//Given your constraints (array size ≤ 200, string length ≤ 200), a simple and efficient approach works perfectly.

//Approach (Horizontal Scanning)
//Start with prefix = first string
//Compare with each string
//Shrink prefix until it matches
//💡 Time Complexity
//Worst: O(N * M)
//where
//        N = number of strings (≤ 200)
//M = string length (≤ 200)
package mock_practice;

class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }
}
//⚡ Follow-up (FAANG twist)

//If interviewer pushes:
//Use Trie (overkill here but good discussion)
//Divide & Conquer approach
//Binary search on prefix length