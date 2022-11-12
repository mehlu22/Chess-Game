/* This class  implements the chessgame interface, all the movement interfaces.
 * It allows the piece of a only that player whose turn it is to be selected on the chessboard
 * It also checks if a move is legal and if true the piece is moved on the board, and the turn changes so it is the next players turn */
public class EuropeanChess implements VerticalMovement, HorizontalMovement, DiagnolMovement, ChessGame {
  // field that indicated which piece a particular piece is
  private ChessPiece piece;

  // field that allows the game to start from the north side of the board
  private ChessGame.Side turn = Side.NORTH;

  // This method which create the functions to allow the pieces to move around teh
  // chessboard by adding, removing and replacing pieces at indicated positions
  public boolean makeMove(ChessPiece piece, int toRow, int toColumn) {
    if (piece.isLegalMove(toRow, toColumn)) {
      piece.getChessBoard().removePiece(toRow, toColumn);
      piece.getChessBoard().removePiece(piece.getRow(), piece.getColumn());
      piece.getChessBoard().addPiece(piece, toRow, toColumn);
      piece.setLocation(toRow, toColumn);
      moveDone();
      return true;
    }
    return false;
  }

  // Method that returns which players turn it is
  public ChessGame.Side getTurn() {
    return this.turn;
  }

  // Method that sets which player's turn it is
  public void setTurn(ChessGame.Side turn) {
    this.turn = turn;
  }

  // method that changes which player's turn it is after a move is made
  public void moveDone() {
    if (Side.NORTH == getTurn()) {
      setTurn(Side.SOUTH);
    } else {
      setTurn(Side.NORTH);
    }
  }

  // method that allows pieces of only that player whose turn it is to be selected
  // and does not allow the pieces of the other player to be selected
  public boolean legalPieceToPlay(ChessPiece piece, int row, int column) {
    if (piece.getSide() == getTurn()) {
      return true;
    } else {
      return false;
    }
  }
}