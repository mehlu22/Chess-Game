/* This class will allow the movement of the Knight piece on the chessboard in a perpecdicular direction by implementing the VeritcalMovement and HorizontalMovement Interfaces*/
public class KnightPiece extends ChessPiece implements VerticalMovement, HorizontalMovement
{
    // field to store the row to move to
    private int toRow;
    
    // field to store the column to move to
    private int toColumn;
    
    // field to store the move 
    private int move;

    // field to store the label of the piece
    private final String label = "N";

    // field to store the icon of the piece
    private final Object icon = null;

    // field to store which player the piece belongs to
    private ChessGame.Side side;
    
    // field to store the piece itself
    private ChessPiece piece;

    /* constructor to inherit values for label, row and column to move to, side to which piece belongs and the chessboard 
     * from the chesspiece class*/
    public KnightPiece(String label ,int toRow, int toColumn, ChessGame.Side side,ChessBoard chessBoard)
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
      if(VerticalMove(this, row, column) || HorizontalMove(this, row, column))
      {
         return true; 
      }
      
      // this if else if will check if the Knight piece can capture another piece of the opposite team by moving perpendicularly to that position
       if(isLegalCaptureMove(row, column))
       {
         if((column==this.getColumn()+1 && row==this.getRow()+2) || (column==this.getColumn()+2 && row==this.getRow()+1) && VerticalMove(this, row, column)  && HorizontalMove(this, row, column))
         {
           return true;
         }
       }
         return false;
     }
}

