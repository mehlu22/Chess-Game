interface SpaceCheck
{
    public default boolean verticalChecker(ChessPiece piece, int toRow, int toCol)
    {
      int row = piece.getRow();
      int col = piece.getColumn();
        if(row<toRow)
        {
            for(int x = toRow;x>row;x--)
            {
                if(piece.getChessBoard().hasPiece(x,col))
                {
                    return false;
                }
                //return false;
            }
        }
        return checkSpace(piece, toRow, toCol);
    }
    public default boolean horizontalChecker(ChessPiece piece, int toRow, int toCol)
    {
      int row = piece.getRow();
      int col = piece.getColumn();
        if(col>toCol)
        {
            for(int x = toCol;x<col;x++)
            {
                if(piece.getChessBoard().hasPiece(row,x))
                {
                    return false;
                }

            }
            return checkSpace(piece, toRow, toCol);
        }
        return false;
    }

    //method to check diagnol from NE to SW
    public default boolean diagnolCheckerHelp1(ChessPiece piece, int row, int col, int toRow)
    {
        int tr = row+1;
        int tc = col-1;

        for(int i=0;i<toRow-row-1;i++)
        {
            if(piece.getChessBoard().hasPiece(tr,tc))
            {
                return false;
            }
            tr = tr+1;
            tc = tc-1;
        }
        return true;
    }

    //method to check diagnol from NW to SE
    public default boolean diagnolCheckerHelp2(ChessPiece piece, int row, int col, int toRow)
    {
        int tr = row-1;
        int tc = col+1;

        for(int i=0;i<toRow-row+1;i++)
        {
            if(piece.getChessBoard().hasPiece(tr,tc))
            {
                return false;
            }
            tr = tr-1;
            tc = tc+1;
        }
        return true;
    }

    //to check if there is space on the board
    public default boolean checkSpace(ChessPiece piece, int toRow, int toCol)
    {
       return true;
    }

    public default boolean diagnolChecker(ChessPiece piece, int toRow, int toCol, int row, int col)
    {
        if(row>toRow && col<toCol)
        {
            if(diagnolCheckerHelp1(piece, toRow, toCol, row))
            {
                return checkSpace(piece, toRow, toCol);
            }
            return false;
        }

        if(row<toRow && col<toCol)
        {
            if(diagnolCheckerHelp1(piece, row, col, toRow))
            {
                return checkSpace(piece, toRow, toCol);
            }
            return false;

        }

        if(row>toRow && col>toCol)
        {
            if(diagnolCheckerHelp2(piece, toRow, toCol, toRow))
            {
                return checkSpace(piece, toRow, toCol);
            }
            return false;

        }
        if(row<toRow && col<toCol)
        {
            if(diagnolCheckerHelp2(piece, toRow, toCol, toRow))
            {
                return checkSpace(piece, toRow, toCol);
            }
            return false;

        }
        return false;

    }

    public default boolean castlingThreat(ChessPiece piece, int toRow, int toCol, int row, int col)
    {
        if(col<toCol)
        {
            for(int x = toCol;x>col;x--)
            {
                if(piece.getChessBoard().hasPiece(row,x))
                {
                    return false;
                }
                else if(piece.getChessBoard().squareThreatened(row,x,piece))
                {
                    return false;
                }
            }
            return checkSpace(piece, toRow, toCol);
        }

        else if(col>toCol)
        {
            for(int x = toCol;x<col;x++)
            {
                if(piece.getChessBoard().hasPiece(row,x))
                {
                    return false;
                }
                else if(piece.getChessBoard().squareThreatened(row,x,piece))
                {
                    return false;
                }
            }
            return checkSpace(piece, toRow, toCol);
        }
        return false;
    }
}