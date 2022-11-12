/* This class will allow the movement of the Rook piece on the chessboard in a vertical, horizontal, or diagnol direction by implementing the VeritcalMovement and HorizontalMovement Interfaces*/
public class RookPiece extends ChessPiece implements VerticalMovement, HorizontalMovement
{
    // field to store the row to move to
    private int toRow;
    
    // field to store the column to move to
    private int toColumn;
    
    // field to store the move 
    private int move;

    // field to store the label of the piece
    private final String label = "R";

    // field to store the icon of the piece
    private final Object icon = null;

    // field to store which player the piece belongs to
    private ChessGame.Side side;
    
    // field to store the piece itself
    private ChessPiece piece;
    
    /* constructor to inherit values for label, row and column to move to, side to which piece belongs and the chessboard 
     * from the chesspiece class*/
    public RookPiece(String label ,int toRow, int toColumn, ChessGame.Side side,ChessBoard chessBoard)
    {
        super(label,toRow,toColumn,side,chessBoard);
    }

    // method to return the icon of the piece
    public Object getIcon()
    {
        return icon;
    }

    // method to return the label of the piece
    public String getLabel()
    {
        return label;
    }

    // method returns if it is legal to move this piece from its current position to the inidicated position assuming that there is no piece at that position
    public boolean isNonLegalCaptureMove(int row,int column)
    {
        ChessGame.Side side = this.getSide();
        if(column==this.getColumn()) // 
        {
            if(VerticalMove(this, row, column))
        {
            return true; 
        } 
            return false;
     }
     else if(row==this.getRow())
     {
            if(HorizontalMove( this, row, column))
        {
            return true; 
        }
       return false;
     }   
     else if(isLegalCaptureMove(row, column))
        {
          if(row == this.getRow() && VerticalMove(this, row, column))
          {
            return true;
          }
          if(column == this.getColumn() && HorizontalMove(this, row, column))
          {
            return true;
          }
        }
        return false;
}
}

