package patterns.heap;
//Todo: explore greedy solution without heap.. array backword traverse
//Todo:Solve similar questions

//In the recent expansion into grocery delivery, Flipkart faces a crucial challenge in effective inventory management. Each grocery item on the platform carries its own expiration date and profit margin, represented by two arrays, A and B of size N. A[i] denotes the time left before expiration date for the ith item, and B[i] denotes profit margin for the ith item. To mitigate potential losses due to expiring items, Flipkart is seeking a strategic solution.
//
//The objective is to identify a method to strategically buy certain items, ensuring they are sold before their expiration date, thereby maximizing overall profit. Can you assist Flipkart in developing an innovative approach to optimize their grocery inventory and enhance profitability?
//
//Your task is to find the maximum profit one can earn by buying groceries considering that you can only buy one grocery item at a time.
//
//NOTE:
//
//You can assume that it takes 1 minute to buy a grocery item, so you can only buy the ith grocery item when the current time <= A[i] - 1.
//You can start buying from day = 0.
//Return your answer modulo 109 + 7.

import java.util.*;
public class MaximiseProfit {
    class Pair{
        public int expiry;
        public int profit;
        public Pair(int expiry, int profit){
            this.profit = profit;
            this.expiry =expiry;
        }
    }
    public int solve(ArrayList<Integer> expiry, ArrayList<Integer> profit) {
        ArrayList<Pair> pairs = new ArrayList<>();
        for(int index = 0; index< expiry.size(); index++){
            pairs.add(new Pair(expiry.get(index), profit.get(index)));
        }
        pairs.sort(Comparator.comparingInt(a->a.expiry));

        PriorityQueue<Pair> heap= new PriorityQueue<>(  Comparator.comparingInt(a -> a.profit));

        for(int index = 0; index< pairs.size(); index++){
            Pair pair = pairs.get(index);
            heap.offer(pair);
            if(heap.size() > pair.expiry)
                heap.poll();
        }

        int result= 0;
        int mod = 1000000007;
        while(!heap.isEmpty()){
            Pair pair =heap.poll();
            result+= pair.profit%mod;
            result%=mod;
        }
        return result;
    }
}

//  A = [1, 3, 2, 3, 3]
//  B = [5, 6, 1, 3, 9]
//  0,1,2
//  5,9,6-20

//  A = [3, 8, 7, 5]
//  B = [3, 1, 7, 19]

//  0,1,2,
//  19,7,3,1
