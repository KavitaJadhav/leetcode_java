//* https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem
// 3. Sherlock and Valid String

//Hit Counter	Queue (sliding time window)
//Logger Rate Limiter	HashMap with timestamp tracking
//Valid String	Frequency map + frequency-of-frequency
package mock_practice;

import java.util.*;

public class SherlockValidString {

    public static String isValid(String s) {

        HashMap<Character, Integer> freqMap = new HashMap<>();

        // count frequency of each character
        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        // count frequency of frequencies
        HashMap<Integer, Integer> freqCount = new HashMap<>();

        for (int freq : freqMap.values()) {
            freqCount.put(freq, freqCount.getOrDefault(freq, 0) + 1);
        }

        // If only one frequency → valid
        if (freqCount.size() == 1) return "YES";

        // If more than 2 frequencies → invalid
        if (freqCount.size() > 2) return "NO";

        // Exactly 2 frequencies
        List<Integer> keys = new ArrayList<>(freqCount.keySet());

        int f1 = keys.get(0);
        int f2 = keys.get(1);

        int c1 = freqCount.get(f1);
        int c2 = freqCount.get(f2);

        // Identify higher and lower frequency
        int highFreq = Math.max(f1, f2);
        int lowFreq = Math.min(f1, f2);

        // Case 1: one frequency occurs once and can be reduced by 1
        if ((freqCount.get(highFreq) == 1 && highFreq - lowFreq == 1) ||
                (lowFreq == 1 && freqCount.get(lowFreq) == 1)) {
            return "YES";
        }

        return "NO";
    }
}