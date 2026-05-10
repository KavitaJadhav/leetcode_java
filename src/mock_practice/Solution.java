//https://leetcode.com/problems/number-of-matching-subsequences/description/
package mock_practice;
//Time = O(n + total characters in words)
//Space = O(total characters)
class NumMatchingSubseq {
    public int numMatchingSubseq(String s, String[] words) {
        Map<Character, Queue<String>> map = new HashMap<>();

        // Initialize buckets
        for (char c = 'a'; c <= 'z'; c++) {
            map.put(c, new LinkedList<>());
        }

        // Put words in buckets based on first char
        for (String word : words) {
            map.get(word.charAt(0)).offer(word);
        }

        int count = 0;

        for (char c : s.toCharArray()) {
            Queue<String> queue = map.get(c);
            int size = queue.size();

            while (size-- > 0) {
                String word = queue.poll();

                if (word.length() == 1) {
                    count++; // matched
                } else {
                    map.get(word.charAt(1)).offer(word.substring(1));
                }
            }
        }

        return count;
    }
}
//Time = O(k * n)
class NumMatchingSubseq2 {
    public List<String> findMatchingSubsequences(String s, String[] words) {
        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (isSubsequence(s, word)) {
                result.add(word);
            }
        }

        return result;
    }

    private boolean isSubsequence(String s, String word) {
        int i = 0, j = 0;

        while (i < s.length() && j < word.length()) {
            if (s.charAt(i) == word.charAt(j)) {
                j++;
            }
            i++;
        }

        return j == word.length();
    }
}