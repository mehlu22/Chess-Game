/* This class will allow the movement of the Queen piece on the chessboard in a vertical, horizontal, or diagnol direction by implementing the VeritcalMovement, HorizontalMovement and DiagnolMovement Interfaces*/
public class QueenPiece extends ChessPiece implements VerticalMovement, HorizontalMovement, DiagnolMovement
{
    // field to store the row to move to
    private int toRow;
    
    // field to store the column to move to
    private int toColumn;
    
    // field to store the move 
    private int move;

    // field to store the label of the piece
    private final String label = "Q";

    // field to store the icon of the piece
    private final Object icon = null;

    // field to store which player the piece belongs to
    private ChessGame.Side side;
    
    // field to store the piece itself
    private ChessPiece piece;
    
    /* constructor to inherit values for label, row and column to move to, side to which piece belongs and the chessboard 
     * from the chesspiece class*/
    public QueenPiece(String label ,int toRow, int toColumn, ChessGame.Side side,ChessBoard chessBoard)
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
        if(column==this.getColumn()) // condition that allows Queen piece to move in vertical direction
        {
          if(VerticalMove(this, row, column))
          {
            return true; 
          } 
          return false;
        }
        else if(row==this.getRow()) // condition that allows Queen piece to move in horizontal direction
        {
          if(HorizontalMove( this, row, column))
          {
            return true; 
          }
        }   
        
         // this if else if will check if the Queen piece can capture another piece of the opposite team by moving either vertically, horizontally or diagnolly to that position
        else if(isLegalCaptureMove(row, column))
        {
          if(row == this.getRow() && VerticalMove(this, row, column))
          {
            return true;
          }
          else if(column == this.getColumn() && HorizontalMove(this, row, column))
          {
            return true;
          }
          else if((row!=this.getRow() && column!=this.getColumn()) && (DiagnolMove(this, row, column)))
          {
            return true;
          }
        }
       else if((row!=this.getRow() && column!=this.getColumn())) // condition that allows Queen piece to move in diagnol direction
       {
         if(DiagnolMove( this, row, column))
         {
           return true; 
          }
       }
       return false;
    }
}
