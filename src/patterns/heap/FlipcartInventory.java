package patterns.heap;

public class FlipcartInventory {
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