/* This class will allow the movement of the bishop piece on the chessboard by implementing the DiagnolMovement interfaces*/
public class BishopPiece extends ChessPiece implements DiagnolMovement
{
    // field to store the row to move to
    private int toRow;
    
    // field to store the column to move to
    private int toColumn;
    
    // field to store the move 
    private int move;

    // field to store the label of the piece
    private final String label = "B";

    // field to store the icon of the piece
    private final Object icon = null;

    // field to store which player the piece belongs to
    private ChessGame.Side side;
    
    // field to store the piece itself
    private ChessPiece piece;

    /* constructor to inherit values for label, row and column to move to, side to which piece belongs and the chessboard 
     * from the chesspiece class*/
    public BishopPiece(String label ,int toRow, int toColumn, ChessGame.Side side,ChessBoard chessBoard)
    {
        super(label,toRow,toColumn,side,chessBoard);
        //this.icon = icon;
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

    // method returns if it is legal to move this piece from its current position to the inidicated position assuiming that there is no piece at that position
    public boolean isNonLegalCaptureMove(int row,int column)
    {   
      ChessGame.Side side = this.getSide();
        if(row != this.getRow() && column!=this.getColumn())
        {
          if(DiagnolMove(this, row, column))
          {
            return true; 
          }     
        }
        
        // this else if will check if the bishop piece can capture another piece of the opposite team by diagnolly moving to that position
        else if(isLegalCaptureMove(row, column))
        {
          if(row != this.getRow() && column != this.getColumn()) //&& DiagnolMove(this, row, column))
          {
            return true;
          }
        }
        return false;
    }
}