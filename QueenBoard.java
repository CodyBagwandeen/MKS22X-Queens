public class QueenBoard{
  private int[][] board;

  public static void main(String[] args){

  }

  public String toString(){
    String output = "";
    for(int i = 0; i < board.length; i++ ){
      for(int j = 0; j < board[i].length; j++){
        if(board[j][i] == -1){
          output += "Q ";
        } else {
          output += "_ ";
        }
        if( j == board[i].length - 1){
          output += "\n";
        }
      }
    }
    return output;

  }
}
