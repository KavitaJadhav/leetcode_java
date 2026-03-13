//https://leetcode.com/problems/longest-palindromic-substring/
//| Metric | Value |
//| ------ | ----- |
//| Time   | O(n²) |
//| Space  | O(1)  |

//O(n)
//Manacher's Algorithm
//Todo: Explore

package expandAroundCenter;

class MaximumPalindromeString {
    private String palindromeFromCenter(String string, int startIndex, int endIndex) {
        while (startIndex >= 0 && endIndex < string.length() && string.charAt(startIndex) == string.charAt(endIndex)) {
            startIndex--;
            endIndex++;
        }
        return string.substring(startIndex + 1, endIndex);
    }

    public String longestPalindrome(String string) {
        if (string.length() <= 1) return string;
        String result = "";

        for (int index = 0; index < string.length(); index++) {
            String oddPalindrome = palindromeFromCenter(string, index, index);
            String evenPalindrome = palindromeFromCenter(string, index, index + 1);

            if (oddPalindrome.length() > result.length()) result = oddPalindrome;
            if (evenPalindrome.length() > result.length()) result = evenPalindrome;
        }

        return result;
    }
}