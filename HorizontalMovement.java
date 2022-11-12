/* An interface that allows a particular piece to move in a horizontal direction
 * The pieces usually allowed to move horizontally are the Queen, Rook, King and Knight and hence these classes will inherit this interface*/
interface HorizontalMovement
{
    public default boolean HorizontalMove(ChessPiece piece, int row, int column)
    {
        if(column >= 0 && column < piece.getChessBoard().numColumns())
        {            
            int b = column; // stores the current column of the piece
            int diff = piece.getColumn()-b; // stores the difference between the indicated column and current column of the piece 
            int j=1;
            if(diff>0) // if else if allows the piece to move horizontally from either west to east or vice versa
            {
              j=-1;
            }
            
            if((piece.getLabel()).equals("K")) // this condition checks if the piece is a King and will work only to allow the king to move by one column horizontal direction
            {     
              if(piece.getColumn()+1==column || piece.getColumn()-1==column)
                return true;
              else
                return false;
            }
            
            if((piece.getLabel()).equals("N")) // this condition checks if a piece is a Knight and will allow it to move by either 1 row and 2 column or vice versa on the chessboard
            {     
               int rN = Math.abs(piece.getRow()-row);
               int cN = Math.abs(piece.getColumn()-column);
               if((rN==2 && cN==1) || (rN==1 && cN==2))
                 return true;
               else
                 return false;
            }
            
            // loop that checks if a piece exists between current and indicated column of a piece
            for(int i=1;i<Math.abs((piece.getColumn()-b));i++)
            {
               if( (piece.getChessBoard().hasPiece(piece.getRow(),piece.getColumn()+ (i*j))))
               {
                 /*if(piece.getLabel().equals("N"))
                 {
                   return true;
                 }*/
                   return false;
               }
           }
           return true;
       }        
       return false;
   }
}