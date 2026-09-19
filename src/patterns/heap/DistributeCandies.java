package patterns.heap;

public class DistributeCandies {

    public int candy(ArrayList<Integer> ratings) {
        int[] candies=new int[ratings.size()];
        Arrays.fill(candies, 1);

        for(int index = 1; index< ratings.size(); index++){
            if(ratings.get(index) > ratings.get(index-1))
                candies[index] = 1+candies[index-1];
        }

        for(int index = ratings.size()-2; index>=0; index--){
            if(ratings.get(index) > ratings.get(index+1) && candies[index] <= candies[index+1])
                candies[index] = Math.max(candies[index], candies[index+1]+1);
        }

        int result = 0;

        for(int index = 0; index< candies.length; index++){
            result+= candies[index];
        }
        return result;
    }
}

// [1,2,3,2,2,1,2,3]
// [1,2,3,1,2,1,2,3]