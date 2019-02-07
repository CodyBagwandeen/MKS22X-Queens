public class QueenBoard{
  private int[][] board;

  public static void main(String[] args){
    System.out.println("Initiliazing a board");
    System.out.println("Q1 = new QueenBoard(5)\n");
    QueenBoard Q1 = new QueenBoard(5);
    System.out.println("testing toString on blank board");
    System.out.println("Q1 \n");
    System.out.println(Q1);

    System.out.println("Q1 \n");
    System.out.println(Q1);
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

  public QueenBoard(int size){
    board = new int[size][size];

  }

  private boolean addQueen(int r, int c){
    board[r][c] = -1;
    return true;
  }

  private boolean removeQueen(int r, int c){
    // do something later
    return true;
  }
}
