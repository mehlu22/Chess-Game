interface PerpendicularMovement extends SpaceCheck
{
    public default boolean perpendicularMove(ChessPiece piece, int toRow, int toCol, int row, int col)
    {
        System.out.println(toCol);
        System.out.println(col);
        if(toCol == col && verticalChecker(piece, toRow, toCol))
        {
            return true;
        }
        if(toRow == row && horizontalChecker(piece, toRow, toCol))
        return true;
        return false;
    }
}