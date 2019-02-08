public class QueenBoard{
  private int[][] board;

  public static void main(String[] args){
    System.out.println("Initiliazing a board");
    System.out.println("Q1 = new QueenBoard(5)\n");
    QueenBoard Q1 = new QueenBoard(5);
    System.out.println("testing toString on blank board");
    System.out.println("Q1\n");
    System.out.println(Q1);

    System.out.println("Testing adding a queen");
    System.out.println("Q1.addQueen(3,1)");
    Q1.addQueen(3,1);

    System.out.println("Q1\n");
    System.out.println(Q1);

    System.out.println("Q1.addQueen(2,0)");
    Q1.addQueen(2,0);

    System.out.println("Q1\n");
    System.out.println(Q1);

    System.out.println("Testing removing a Queen");
    System.out.println("Q1.removeQueen(2,0)");
    Q1.removeQueen(2,0);

    System.out.println("Q1\n");
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
    if(board[r][c] == -1){
      board[r][c] = 0;
      return true;
    }
    return false;

  }

  /**
  *@return false when the board is not solveable and leaves the board filled with zeros;
  *        true when the board is solveable, and leaves the board in a solved state
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public boolean solve(){
    return false;
    
  }
}
