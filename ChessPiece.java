/* This class allows us to create types of chesspieces. 
 * The methods and instances of the class allow to store and return the label, icon, row and column to move to, side to which piece belongs and chessboard.
 * Some methods towards the end of the class also allow to check if a piece is allowed to move to an indicated position either if that position is empty or to make a kill of the opposite piece
 * A method called moveDone() handles the processing once the move is completed*/

public abstract class ChessPiece 
{
    //field to store the label name
    private String label;

    //field to store the row number
    private int row;

    //field to store the column number
    private int column;

    //field to store the icon
    private Object icon;

    //field to store which player the piece belongs to
    private ChessGame.Side side;

    // field to declare the chessboard
    private ChessBoard chessBoard;

    // A contructor to pass in the values of the label, row and column to move the piece to, the player to which the piece belongs to and the chessboard type
    public ChessPiece(String label, int row, int column, ChessGame.Side side, ChessBoard chessBoard )
    {
        this.label = label;
        this.row = row;
        this.column = column;
        this.side = side;
        this.chessBoard = chessBoard;
        chessBoard.addPiece(this,row,column);
    }
    
    // returns which player the piece belongs to
    public ChessGame.Side getSide()
    {
        return side;
    }
 
    // method returns the current column of the particular piece
    public int getColumn()
    {
        return column;
    }
    
    // method return the particular row of the piece
    public int getRow()
    {
        return row;
    }

    // method allows to move the piece to a particular row and column on the chessboard
    public void setLocation(int row, int column)
    {
        this.row = row;
        this.column = column;
    }

    // method returns the chessboard of type Chessboard from the chessboard class
    public ChessBoard getChessBoard()
    {
        return chessBoard;
    }

    // method returns the label of the particular piece
    public String getLabel()
    {
      return this.label;
    }

   // method returns the icon of the particular piece
   public Object getIcon()
    {
      return this.icon;
    }

   // method returns if it is allowed to move the piece from its current location to the input location
    public boolean isLegalMove(int toRow, int toColumn)
    {      
       if(isLegalCaptureMove(toRow,toColumn))
       {
          return isNonLegalCaptureMove(toRow,toColumn);
       }
       else if(getChessBoard().hasPiece(toRow, toColumn) == false)
       {
          return isNonLegalCaptureMove(toRow,toColumn);
       }
       return false;
     }
        
    // method returns if it a piece is allowed to capture a piece of the other player at a particular position if the move for the piece is legal
    public boolean isLegalCaptureMove(int row, int column)
    {
      return(getChessBoard().hasPiece(row,column) && getChessBoard().getPiece(row,column).getSide() != this.getSide());
    }

    /* An abstract method inherited in each of the types of piece class that checks if it legal to move a piece 
    from its current position to the indicated position if there is no piece present out there*/
    public abstract boolean isNonLegalCaptureMove(int row, int column);
    
    // method that handles the processing once the move is done
    public void moveDone()
    {
      //System.out.println("5555");
    }

}