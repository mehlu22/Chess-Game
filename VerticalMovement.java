/* An interface that allows a particular piece to move in a vertical direction
 * The pieces usually allowed to move horizontally are the Queen, Rook, King, Pawn, and Knight and hence these classes will inherit this interface*/
interface VerticalMovement
{
    public default boolean VerticalMove(ChessPiece piece, int row, int column)
    {
        if(row >=0 && row<piece.getChessBoard().numRows())
        {
          int a = row; // stores the current row of the piece
          int diff = piece.getRow()-a; // stores the difference between the indicated row and current row of the piece
          int j=1;
          if(diff>0) // if else if allows the piece to move horizontally from either north to south or vice versa
          {
            j=-1;
          }     
      
          if((piece.getLabel()).equals("P") && diff>1) // this condition checks if the piece is a pawn and will work to allow the pawn to move by one row in vertical direction
          {
            if(piece.getRow()!=1 && piece.getRow()!=6)
              return false;
            else
              return true;
           }
      
           if((piece.getLabel().equals("K"))) // this condition checks if the piece is a King and will work only to allow the king to move by one row vertical direction
           {
             if((piece.getRow()+1==row ||(piece.getRow()-1==row)))
               return true;
             else
               return false;
            }
      
           if(piece.getLabel().equals("N")) // this condition checks if a piece is a Knight and will allow it to move by either 1 row and 2 column or vice versa on the chessboard
           {
             int rN = Math.abs(piece.getRow()-row);
             int cN = Math.abs(piece.getColumn()-column);
             if((rN==2 && cN==1) || (rN==1 && cN==2))
               return true;
             else
               return false;
           }
           // loop that checks if a piece exists between current and indicated row of a piece
           for(int i=1;i<Math.abs((piece.getRow()-a));i++)
           {
             System.out.println(piece.getRow());
             if(piece.getChessBoard().hasPiece(piece.getRow() + (i*j),piece.getColumn()))
             {
               return false;
             }
           }
           return true;
        }            
        return false;
    }
}