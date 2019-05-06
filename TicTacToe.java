/**
 * TicTacToe
 */
public class TicTacToe {

  static String[] generateRows(String board) {
      String[] rows = {"", "", ""};
      char[] boardChars = board.toCharArray();
  
      for (int i = 0; i < boardChars.length; i++) {
          if (i >= 0 && i < 3) {
              rows[0] = rows[0] + boardChars[i];
          }
          if (i >= 3 && i < 6) {
              rows[1] = rows[1] + boardChars[i];
          }
          if (i >= 6 && i < 9) {
              rows[2] = rows[2] + boardChars[i];
          }
      }

    return rows;
  }

  static void print(String board) {
      String[] rows = {"", "", ""};
      char[] boardChars = board.toCharArray();
  
      for (int i = 0; i < boardChars.length; i++) {
          if (i >= 0 && i < 3) {
              rows[0] = rows[0] + "   [" + boardChars[i] + "] ";
          }

          if (i >= 3 && i < 6) {
              rows[1] = rows[1] + "   [" + boardChars[i] + "] ";
          }
          
          if (i >= 6 && i < 9) {
              rows[2] = rows[2] + "   [" + boardChars[i] + "] ";
          }
      }

      for (int rowNum = 0; rowNum < rows.length; rowNum++) {
              System.out.println(rows[rowNum]);
      }
  }

  static Character checkRows(String[] rows) {
    for (int i = 0; i < rows.length; i++) {
      String row = rows[i];

      if (row.equals("XXX")) {
        return 'X';
      }
      if (row.equals("OOO")) {
        return 'O';
      }
    }

    return null;
  }

  static Character checkCols(String[] rows) {
   
    String[] cols = {"", "", ""};

    for (int rowNum = 0; rowNum < rows.length; rowNum++) {
      char[] rowArr = rows[rowNum].toCharArray();

      for (int colNum = 0; colNum < cols.length; colNum++) {
        cols[colNum] = cols[colNum] + rowArr[colNum];
      }
    }

    for (int i = 0; i < cols.length; i++) {
      String col = cols[i];

      if (col.equals("XXX")) {
        return 'X';
      }
      if (col.equals("OOO")) {
        return 'O';
      }
    }

    return null;
  }

  static Character checkDiagonals(String[] rows) {

      String[] diagonals = {"", ""};
      int x = rows.length - 1;

      for (int rowNum = 0; rowNum < rows.length; rowNum++) {
          char[] rowArr = rows[rowNum].toCharArray();

          diagonals[0] = diagonals[0] + rowArr[rowNum];
          diagonals[1] = diagonals[1] + rowArr[x];
          x = x - 1;
      }

      for (int i = 0; i < diagonals.length; i++) {
          String diagonal = diagonals[i];
     
          if (diagonal.equals("XXX")) {
            return 'X';
          }
          if (diagonal.equals("OOO")) {
            return 'O';
          }
      }

      return null;
  } 

  static boolean checkWinner(String[] rows) {
    // check the rows
    Character winner = null;

    winner = checkRows(rows);

    if (winner == null) {
      winner = checkCols(rows);
    }
    
    if (winner == null) {
      winner = checkDiagonals(rows);
    }
    
    System.out.println("Winner is Player: " + winner);

    return true;
  }

  public static void main(String[] args) {
    String board = "XO--X--OX";
    String[] rows = generateRows(board);
    System.out.println("-----------------------");
    print(board);
    System.out.println("-----------------------");
    checkWinner(rows);
    System.out.println("-----------------------");
  }
}
