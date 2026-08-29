package patterns.sort.merge;

import java.util.*;

public class InversionCount {
    public int inversions = 0;
    int mod = 1000000007;
    public int solve(ArrayList<Integer> input) {
        if(input.size() <= 1)
            return 0;

        sort(input);

        return inversions;
    }

    public ArrayList<Integer>  sort(ArrayList<Integer> input) {
        if(input.size() <= 1)
            return input;
        int mid = (input.size())/2;

        ArrayList<Integer> left= new ArrayList<>();
        for(int index = 0; index < mid; index++){
            left.add(input.get(index));
        }

        ArrayList<Integer> right= new ArrayList<>();
        for(int index = mid; index < input.size(); index++){
            right.add(input.get(index));
        }
        left = sort(left);
        right = sort(right);
        return merge(left, right);
    }

    public ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right){
        int leftIndex = 0;
        int rightIndex = 0;

        ArrayList<Integer> result = new ArrayList<>();

        while(leftIndex < left.size() && rightIndex < right.size()){
            if(left.get(leftIndex)>right.get(rightIndex)){
                result.add(right.get(rightIndex));
                rightIndex++;
                inversions+=(left.size()-leftIndex);
                inversions%=mod;
            }else{
                result.add(left.get(leftIndex));
                leftIndex++;
            }
        }

        while(rightIndex < right.size()){
            result.add(right.get(rightIndex));
            rightIndex++;
        }

        while(leftIndex < left.size()){
            result.add(left.get(leftIndex));
            leftIndex++;
        }
        return result;
    }
}

