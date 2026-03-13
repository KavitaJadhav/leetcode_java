//https://leetcode.com/problems/word-search/
//| Aspect            | Complexity                                       |
//| ----------------- | ------------------------------------------------ |
//| Time (worst-case) | O(m × n × 4^L)                                   |
//| Space (recursion) | O(L)                                             |
//| Practical note    | Early pruning reduces actual calls significantly |

//Note: 4^L is the DFS branching factor — it's worst-case, but in practice the board[i][j] != word.charAt(wordIndex) pruning reduces it a lot.

//Recursion stack
//Max depth of recursion = length of the word L → O(L)

//Board modification
//We modify the board in-place (mark #), so no extra board space is needed

package backtrack;

public class WordSearchI {
    private boolean dfs(char[][] board, String word, int iIndex, int jIndex, int wordIndex){
        int rows = board.length;
        int columns = board[0].length;

        if(iIndex < 0 || iIndex >=rows || jIndex < 0 || jIndex >=columns) return false;
        char character = board[iIndex][jIndex];
        if(character != word.charAt(wordIndex)) return false;
        char cellValue = board[iIndex][jIndex];
        board[iIndex][jIndex] = '#';

        wordIndex++;
        if(wordIndex == word.length()) return true ;
        boolean result =  dfs(board, word,iIndex+1, jIndex, wordIndex) ||
                dfs(board, word,iIndex-1, jIndex, wordIndex) ||
                dfs(board, word,iIndex, jIndex+1, wordIndex)||
                dfs(board, word,iIndex, jIndex-1, wordIndex);

        board[iIndex][jIndex] = cellValue;
        return result;
    }


    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int columns = board[0].length;

        for(int iIndex=0; iIndex< rows; iIndex++){
            for(int jIndex=0; jIndex< columns; jIndex++){
                if(board[iIndex][jIndex]==word.charAt(0));
                if(dfs(board, word,iIndex, jIndex, 0)) return true ;
            }
        }
        return false;
    }

}