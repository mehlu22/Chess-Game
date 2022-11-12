/* Creates a main class that launches the game by creating a chessboard with all the individual chess pieces on their starting positions. 
 * The game is ready to be started */
import java.util.*;

public class Main
{
  public static void main(String args[])
  {
    // Adding all the pieces to their starting positions on the north side of the chessboard
    ChessBoard board = new ChessBoard(8,8,new EuropeanChessDisplay(), new EuropeanChess());
    ChessPiece piece1 = new QueenPiece("Q", 0,3, ChessGame.Side.NORTH, board);
    ChessPiece piece2 = new RookPiece("R", 0,0, ChessGame.Side.NORTH, board);
    ChessPiece piece3 = new KnightPiece("N", 0,1,ChessGame.Side.NORTH, board);
    ChessPiece piece4 = new BishopPiece("B", 0,2, ChessGame.Side.NORTH, board);
    ChessPiece piece5 = new KingPiece("K", 0,4, ChessGame.Side.NORTH, board);
    ChessPiece piece6 = new PawnPiece("P", 1,0, ChessGame.Side.NORTH, board);
    ChessPiece piece7 = new PawnPiece("P", 1,1, ChessGame.Side.NORTH, board);
    ChessPiece piece8 = new PawnPiece("P", 1,2, ChessGame.Side.NORTH, board);
    ChessPiece piece9 = new PawnPiece("P", 1,3, ChessGame.Side.NORTH, board);
    ChessPiece piece10 = new PawnPiece("P", 1,4, ChessGame.Side.NORTH, board);
    ChessPiece piece11 = new PawnPiece("P", 1,5, ChessGame.Side.NORTH, board);
    ChessPiece piece12 = new PawnPiece("P", 1,6, ChessGame.Side.NORTH, board);
    ChessPiece piece13 = new PawnPiece("P", 1,7, ChessGame.Side.NORTH, board);
    ChessPiece piece14 = new RookPiece("R", 0,7, ChessGame.Side.NORTH, board);
    ChessPiece piece15 = new BishopPiece("B", 0,5, ChessGame.Side.NORTH, board);
    ChessPiece piece16 = new KnightPiece("N", 0,6, ChessGame.Side.NORTH, board);
    
    // Adding all the pieces to their starting positions on the south side of the chessboard
    ChessPiece Spiece1 = new QueenPiece("Q", 7,3, ChessGame.Side.SOUTH, board);
    ChessPiece Spiece2 = new RookPiece("R", 7,0, ChessGame.Side.SOUTH, board);
    ChessPiece Spiece3 = new KnightPiece("N", 7,1,ChessGame.Side.SOUTH, board);
    ChessPiece Spiece4 = new BishopPiece("B", 7,2, ChessGame.Side.SOUTH, board);
    ChessPiece Spiece5 = new KingPiece("K", 7,4, ChessGame.Side.SOUTH, board);
    ChessPiece Spiece6 = new PawnPiece("P", 6,0, ChessGame.Side.SOUTH, board);
    ChessPiece Spiece7 = new PawnPiece("P", 6,1, ChessGame.Side.SOUTH, board);
    ChessPiece Spiece8 = new PawnPiece("P", 6,2, ChessGame.Side.SOUTH, board);
    ChessPiece Spiece9 = new PawnPiece("P", 6,3, ChessGame.Side.SOUTH, board);
    ChessPiece Spiece10 = new PawnPiece("P", 6,4, ChessGame.Side.SOUTH, board);
    ChessPiece Spiece11 = new PawnPiece("P", 6,5, ChessGame.Side.SOUTH, board);
    ChessPiece Spiece12 = new PawnPiece("P", 6,6, ChessGame.Side.SOUTH, board);
    ChessPiece Spiece13 = new PawnPiece("P", 6,7, ChessGame.Side.SOUTH, board);
    ChessPiece Spiece14 = new RookPiece("R", 7,7, ChessGame.Side.SOUTH, board);
    ChessPiece Spiece15 = new KnightPiece("N", 7,6,ChessGame.Side.SOUTH, board);
    ChessPiece Spiece16 = new BishopPiece("B", 7,5, ChessGame.Side.SOUTH, board);
  }
}