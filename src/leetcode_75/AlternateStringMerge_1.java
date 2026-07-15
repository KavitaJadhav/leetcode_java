//https://leetcode.com/problems/merge-strings-alternately/?envType=study-plan-v2&envId=leetcode-75
package leetcode_75;

public class AlternateStringMerge_1 {
    public String mergeAlternately(String word1, String word2) {

        if (word1.length() == 0)
            return word2;
        if (word2.length() == 0)
            return word1;

        int minLength = Math.min(word1.length(), word2.length());
        StringBuilder result = new StringBuilder();
        for (int index = 0; index < minLength; index++) {
            result.append(word1.charAt(index));
            result.append(word2.charAt(index));
        }
        result.append(word1.substring(minLength));
        result.append(word2.substring(minLength));
        return result.toString();
    }
}
