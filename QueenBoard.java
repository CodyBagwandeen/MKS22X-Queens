public class QueenBoard{
  private int[][] board;

  public static void main(String[] args){
    System.out.println("Initiliazing a board");
    System.out.println("Q1 = new QueenBoard(5)\n");

    QueenBoard Q1 = new QueenBoard(8);

    System.out.println("testing toString on blank board");
    System.out.println("Q1\n");
    System.out.println(Q1);

    System.out.println("Testing adding a queen");
    System.out.println("Q1.addQueen(4,0) : Should be True");
    System.out.println(Q1.addQueen(4,0));

    System.out.println("Q1\n");
    System.out.println(Q1);
    System.out.println("Q1 debug\n");
    System.out.println(Q1.toStringdebug());

    System.out.println("Testing adding a queen");
    System.out.println("Q1.addQueen(3,1) : Should be False");
    System.out.println(Q1.addQueen(3,1));

    System.out.println("Q1\n");
    System.out.println(Q1);
    System.out.println("Q1 debug\n");
    System.out.println(Q1.toStringdebug());

    System.out.println("Testing adding a queen");
    System.out.println("Q1.addQueen(3,0) : Should be True");
    System.out.println(Q1.addQueen(0,0));

    System.out.println("Q1\n");
    System.out.println(Q1);
    System.out.println("Q1 debug\n");
    System.out.println(Q1.toStringdebug());

    System.out.println("Testing removing a queen");
    System.out.println("Q1.removeQueen(0,0) : Should be True");
    System.out.println(Q1.removeQueen(0,0));

    System.out.println("Q1\n");
    System.out.println(Q1);
    System.out.println("Q1 debug\n");
    System.out.println(Q1.toStringdebug());

    QueenBoard Q2 = new QueenBoard(8);

    System.out.println("Testing solving");
    System.out.println("Q2.solve : Should be True");
    System.out.println(Q2.solve());

    System.out.println("Q2\n");
    System.out.println(Q2);
    System.out.println("Q2 debug\n");
    System.out.println(Q2.toStringdebug());

    QueenBoard Q3 = new QueenBoard(8);

    System.out.println("Testing counting");
    System.out.println("Q3.countSolutions : Should be 92");
    System.out.println(Q3.countSolutions());

    System.out.println("Q3\n");
    System.out.println(Q3);
    System.out.println("Q3 debug\n");
    System.out.println(Q3.toStringdebug());

    runTest(5);




  }

  public String toString(){
    String output = "";
    for(int r = 0; r < board.length; r++){
      for( int c = 0; c < board.length; c++){
        if(board[r][c] == -1){
          output += "Q ";
        } else {
          output += "_ ";
        }
        if(c == board.length -1 ){
          output += "\n";
        }
      }
    }
    return output;

  }

  public String toStringdebug(){
    String output = "";
    for(int r = 0; r < board.length; r++){
      for( int c = 0; c < board.length; c++){
        if(board[r][c] == -1){
          output += "Q ";
        } else {
          output += board[r][c] + " ";
        }
        if(c == board.length -1 ){
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
    if(board[r][c] == 0){
      for(int index = 0; c + index < board.length ; index++){ // marking across
        board[r][c + index] += 1;
      }
      for( int index = 0; r + index < board.length && c + index < board.length; index++){ // marking diagonally down
        board[r+index][c+index] += 1;
      }
      for(int index = 0; r - index >= 0 && c + index < board.length; index++){ // marking diagonally up
        board[r-index][c+ index] += 1;
      }
      board[r][c] = -1;

      return true;
    } else {
      return false;
    }
  }

  private boolean removeQueen(int r, int c){
    if(board[r][c] == -1){
      for(int index = 0; c + index < board.length ; index++){ // marking across
        board[r][c + index] -= 1;
      }
      for( int index = 0; r + index < board.length && c + index < board.length; index++){ // marking diagonally down
        board[r+index][c+index] -= 1;
      }
      for(int index = 0; r - index >= 0 && c + index < board.length; index++){ // marking diagonally up
        board[r-index][c+ index] -= 1;
      }
      board[r][c] = 0;

      return true;
    } else {
      return false;
    }

  }

  /**
  *@return false when the board is not solveable and leaves the board filled with zeros;
  *        true when the board is solveable, and leaves the board in a solved state
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public boolean solve(){
    for(int r = 0; r < board.length; r++){
      for( int c = 0; c < board.length; c++){
        if(board[r][c] != 0){
          throw new IllegalStateException();
        }
      }
    }
    return solveR(0);

  }

  public boolean solveR(int col){
    int l = board.length; // big brain play so i dont have to type board.length 1000000 times
    if( col >=  l){
      return true;
    } else {
      for( int r = 0; r < l; r++){
        if( addQueen(r,col)){
          if(solveR(col+1)){
            return true;
          }else {
            removeQueen(r,col);
          }
        }
      }
    }
    return false;

  }

  /**
  *@return the number of solutions found, and leaves the board filled with only 0's
  *@throws IllegalStateException when the board starts with any non-zero value
  */

  public int countSolutions(){
    for(int r = 0; r < board.length; r++){
      for( int c = 0; c < board.length; c++){
        if(board[r][c] != 0){
          throw new IllegalStateException();
        }
      }
    }
    return countH(0);

  }
  public int countH(int col){
    int l = board.length; // big brain play so i dont have to type board.length 1000000 times
    int sum = 0;  // amount of solutions
    if( col >=  l){
      return 1;
    } else {
      for( int r = 0; r < l; r++){
        if(addQueen(r,col)){
          sum += countH(col+1);
          removeQueen(r,col);
        }
      }
    }
    return sum;
  }

  //testcase must be a valid index of your input/output array
public static void runTest(int i){
QueenBoard b;
int[]tests =   {1,2,3,4,5,8};
int[]answers = {1,0,0,2,10,92};
if(i >= 0 && i < tests.length ){
  int size = tests[i];
  int correct = answers[i];
  b = new QueenBoard(size);
  int ans  = b.countSolutions();

  if(correct==ans){
    System.out.println("PASS board size: "+tests[i]+" "+ans);
  }else{
    System.out.println("FAIL board size: "+tests[i]+" "+ans+" vs "+correct);
  }
}
}
}
