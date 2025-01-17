package chessgui.pieces;

import chessgui.Board;

public class Knight extends Piece {

    public Knight(int x, int y, boolean is_white, String file_path, Board board)
    {
        super(x,y,is_white,file_path, board);
    }
    
    @Override
    public boolean canMove(int destX, int destY)
    {
        // Remember: a knight can move in any L shape and can jump over anyone
        // in order to do so. He cannot attack his own pieces.
        // By an L shape, I mean it can move to a square that is 2 squares away
        // horizontally and 1 square away vertically, or 1 square away horizontally
        // and 2 squares away vertically.
        // some examples:
        //
        //  * *       * * *           *       *
        //  *             *       * * *       *
        //  *                                 * *
            
                // WRITE CODE HERE
    	Piece destPiece = board.getPiece(destX, destY);

		if (destPiece != null) 
		{
			if ((destPiece.isWhite() && this.isWhite()) || (!destPiece.isWhite() && !this.isWhite()))
			{
				return false;
			}
		}
		
		int x = Math.abs(destX - this.getX());
		int y = Math.abs(destY - this.getY());
		
		if ((x * y) != 2)
		{
			return false;
		}
        
        return true;
    }
}
