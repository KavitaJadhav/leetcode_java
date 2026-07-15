package leetcode_75;

public class MaxCandies_3 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = Arrays.stream(candies).max().getAsInt();

        List<Boolean> result = new ArrayList<>();
        for (int index = 0; index < candies.length; index++) {
            result.add(candies[index] + extraCandies >= maxCandies);
        }
        return result;
    }
}
