//https://leetcode.com/problems/minimum-window-substring/
//Minimum window containing all chars from substring
package patterns.sliding_window;

import java.util.*;

public class WindowString {
//public class Solution {
    public String minWindow(String source, String target) {
        int[] need = new int[(int) Math.pow(2, 16)];
        int[] current = new int[(int) Math.pow(2, 16)];
        int left = 0;
        int right = 0;

        int matched = 0;
        int required = 0;
        int minWindowStart = -1;
        int minWindowSize = Integer.MAX_VALUE;;

        for(int index = 0; index<target.length(); index++){
            char  ch = target.charAt(index);

            if (need[ch] == 0) {
                required++;
            }

            need[ch]++;
        }

        while(right<source.length()){
            char ch = source.charAt(right);
            current[ch]++;
            if(need[ch]>0 && current[ch]==need[ch])
                matched++;

            while(matched == required){
                int newSize = (right-left)+1;
                if(newSize < minWindowSize){
                    minWindowStart= left;
                    minWindowSize = newSize;
                }
                char leftChar = source.charAt(left);

                current[leftChar]--;
                if(need[leftChar]>0 && current[leftChar]<need[leftChar])
                    matched--;

                left++;
            }

            right++;
        }
        if(minWindowStart==-1)
            return "";

        return source.substring(minWindowStart, minWindowStart + minWindowSize);
    }
}

// aabbcc
// abc
// 1,1,1
// 2,2,1