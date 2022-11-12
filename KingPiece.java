/* This class will allow the movement of the King piece on the chessboard by implementing the DiagnolMovement, VeritcalMovement and HorizontalMovement Interfaces*/
public class KingPiece extends ChessPiece implements VerticalMovement, HorizontalMovement, DiagnolMovement
{
    // field to store the row to move to
    private int toRow;
    
    // field to store the column to move to
    private int toColumn;
    
    // field to store the move 
    private int move;

    // field to store the label of the piece
    private final String label = "K";

    // field to store the icon of the piece
    private final Object icon = null;

    // field to store which player the piece belongs to
    private ChessGame.Side side;
    
    // field to store the piece itself
    private ChessPiece piece;

    /* constructor to inherit values for label, row and column to move to, side to which piece belongs and the chessboard 
     * from the chesspiece class*/
    public KingPiece(String label ,int toRow, int toColumn, ChessGame.Side side,ChessBoard chessBoard)
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
    
   /* public boolean isCastling()
    {
        return this.castling;
    }
    
    public void setcastling(boolean castling)
    {
        this.castling = castling;
    }
    
    private boolean isValidCastling(int toRow, int toColumn)
    {
        if(this.isCastling())
        {
            return false;
        }
        return false;
    }*/
   
    // method returns if it is legal to move this piece from its current position to the inidicated position assuming that there is no piece at that position
    public boolean isNonLegalCaptureMove(int row,int column)
    {
        ChessGame.Side side = this.getSide();
        if(column==this.getColumn()) // condition checks if the current and indicated column is the same and hence only allowing vertical movement
        {
          if(VerticalMove(this, row, column))
        {
          return true; 
        } 
     }
        
        else if(row==this.getRow()) // condition checks if the current and indicated row are the same hence allowing only horizontal movement by one space
        {
          if(HorizontalMove( this, row, column))
          {
            return true; 
          }
        }   
        
        // this if else if will check if the King piece can capture another piece of the opposite team by moving vertically, horizontally or diagnolly by one space to that position
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
     else if((row!=this.getRow() && column!=this.getColumn())) // condition that checks if both the current and indicated row and column have changed hence allowing only diagnol movement by once space
     {
       if(DiagnolMove( this, row, column))
        {
         return true; 
        }
     }
        return false;
    }       
}