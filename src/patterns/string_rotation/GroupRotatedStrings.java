// Given a list of strings, group the strings that are equivalent when rotated. For example, the input
// ["abc", "bca", "cab", "xyz", "yzx", "cba", "aaaa"]
// should return the groups:
//                       {["abc", "bca", "cab"], ["xyz, "yzx"], ["cba"], ["aaaa"]}
//
// The order of the strings or the groups for the result does not matter.
// {["cba"], ["xyz, "yzx"], ["bca", "abc", "cab"], ["aaaa"]}
// is an acceptable solution too.
//
// Knew how to find if one string is a rotated version of the other but couldn't piece out how to put in the common group. Another approach which I preferred is to generate hash of string and seems that is a wrong approach. Any inputs on how to approach for this problem?
//
//
// https://leetcode.com/discuss/post/865428/apple-phone-interview-group-rotated-stri-zv6n/
// https://leetcode.com/problems/group-rotations/description/
//
//
// EACH word
// create rotation list
// find all rotations from main list
// add in result and delete from main list
// return result
// calculate complexity
// space
// time
//
// check if list is empty
// list size one then no changes needed
// element length one then no looping needed
// if nil elements, filter or add as one group and remove all other nil elements

//| Solution                 | Time Complexity                            | Space Complexity | Notes                                                                        |
//| ------------------------ | ------------------------------------------ | ---------------- | ---------------------------------------------------------------------------- |
//| Original substring-check | O(n × m²)                                  | O(n × m)         | Checks all rotations for each string using substring                         |
//| Canonical key map        | O(n × m²) (current) → O(n × m) (optimized) | O(n × m)         | Groups by lexicographically smallest rotation; faster if no substring copies |

package patterns.string_rotation;

import java.util.*;

public class GroupRotatedStrings {
    List<List<String>> group(List<String> list) {
        List<List<String>> result = new ArrayList<>();
        Set<String> unGrouped = new HashSet<>(list);

        for (String string : list) {
            if (unGrouped.contains(string)) {
                List<String> group = new ArrayList<>();

                String doubled = string + string;

                for (int index = 0; index < string.length(); index++) {
                    String substring = doubled.substring(index, index + string.length());
                    if (unGrouped.contains(substring)) {
                        group.add(substring);
                        unGrouped.remove(substring);
                    }
                }

                result.add(group);
            }
        }

        return result;
    }


    public static void main(String[] args) {
        GroupRotatedStrings groupRotatedStrings = new GroupRotatedStrings();
        List<String> list = Arrays.asList("abc", "bca", "cab", "xyz", "yzx", "cba", "aaaa");

        System.out.println(groupRotatedStrings.group(list));
    }
}
