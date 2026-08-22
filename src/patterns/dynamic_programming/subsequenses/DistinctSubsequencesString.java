package patterns.dynamic_programming.subsequenses;

public class DistinctSubsequencesString {

    public int numDistinct(String original, String subsequence) {
        int rows = original.length();
        int columns = subsequence.length();
        int mod = 1000000007;
        int[][] dp = new int[rows+1][columns+1];

        for(int row = 0; row<rows; row++){
            dp[row][0]=1;
        }

        for(int row = 1; row<=rows; row++){
            for(int column = 1; column<=columns; column++){
                dp[row][column] = dp[row-1][column];
                char rowChar = original.charAt(row-1);
                char columnChar = subsequence.charAt(column-1);
                if(rowChar==columnChar){
                    dp[row][column] = dp[row-1][column] +  dp[row-1][column-1];
                }else{
                    dp[row][column] = dp[row-1][column];
                }
                dp[row][column] %=mod;
            }
        }
        return dp[rows][columns];
    }
}
// A = "abc"
// B = "abc"

// A = "rabbbit"
// B = "rabbit"

//
//    ,r,a,b,b,b,i,t
//   1,0,0,0,0,0,0,0
// r-1,1,0,0,0,0,0,0
// a-1,1,1,0,0,0,0,0
// b-1,1,1,1,0,0,0,0
// b-1,1,1,2,1,0,0,0
// b-1,1,1,3,3,1,0,0
// i-1,1,1,3,3,1,1,0
// t-1,1,1,3,3,1