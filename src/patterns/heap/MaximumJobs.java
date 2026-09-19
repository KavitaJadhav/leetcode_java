//https://www.scaler.com/academy/mentee-dashboard/class/514062/assignment/problems/9291?navref=cl_tt_lst_sl
package patterns.heap;

public class MaximumJobs {

    class Tuple{
        public int start;
        public int end;
        public Tuple(int start, int end){
            this.start =start;
            this.end = end;
        }

    }
    public int solve(ArrayList<Integer> startTimes, ArrayList<Integer> endTimes) {
        ArrayList<Tuple> pairs = new ArrayList<>();

        for(int index = 0; index < startTimes.size(); index++){
            pairs.add(new Tuple(startTimes.get(index), endTimes.get(index)));
        }
        pairs.sort((a,b)-> a.end-b.end);

        int result= 1;
        Tuple previous = pairs.get(0);
        for(int index = 1;index<pairs.size();index++){
            Tuple current = pairs.get(index);
            if(current.start >= previous.end){
                result++;
                previous=current;}
        }
        return result;
    }
}
