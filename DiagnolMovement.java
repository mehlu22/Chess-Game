/* An interface that allows a particular piece to move in a diagnol direction
 * The pieces usually allowed to move diagnolly are the Queen, Pawn, King and Bishop and hence these classes will inherit this interface*/
interface DiagnolMovement
{
    public default boolean DiagnolMove(ChessPiece piece, int row, int column)
    {
       if(row >=0&& row<piece.getChessBoard().numRows() && column >=0 && column <piece.getChessBoard().numColumns())
       {
          int a = row; // stores the current row of the piece
          int b = column; // stores the current column of the piece
          int diff = (piece.getRow()-a); // stores the difference between the indicated row and current row of the piece
          int diff1 = (piece.getColumn()-b); // stores the difference between the indicated column and current column of the piece  
          if(Math.abs(diff)!=Math.abs(diff1)) // will check if the piece is moving diagnolly or not
          return false;
          int j=1;
          int k=1;
          if(diff>0) // if else if allows the piece to move diagnolly from NW to SE, SE to NW, NE to SW, and SW to NE
          {
            j=-1;
          }
          else if(diff1>0)
          {
            k=-1;
          }
          if((piece.getLabel()).equals("K")) // this condition checks if the piece is a King and will work only to allow the king to move by one row or column in diagnol direction
          {
             if(piece.getRow()+1==row ||(piece.getRow()-1==row) && (piece.getColumn()+1==column || piece.getColumn()-1==column))
               return true;
             else
               return false;
           }
                
         for(int i=1;i<Math.abs(diff); i++) // loop checks if there is a piece on any row or column in a diagnol direction
         {
           if(piece.getChessBoard().hasPiece(piece.getRow() + (i*j),piece.getColumn()+(i*k)))
           {                    
             return false;  
           } 
         }  
         return true;         
       }
       return false;
    }
}