package chessgui.pieces;

import chessgui.Board;

public class Bishop extends Piece {

    public Bishop(int x, int y, boolean is_white, String file_path, Board board)
    {
        super(x,y,is_white,file_path, board);
    }
    
    @Override
    public boolean canMove(int destX, int destY)
    {
        // Remember: For attacking or just moving, a bishop is allowed to move 
        // as many squares diagonally as it wants without jumping over another 
        // piece. He cannot attack his own pieces.
        
                // WRITE CODE HERE
    	Piece destPiece = board.getPiece(destX, destY);

		if (destPiece != null) 
		{
			if ((destPiece.isWhite() && this.isWhite()) || (!destPiece.isWhite() && !this.isWhite()))
			{
				return false;
			}
		}

		if (Math.abs((this.getX() - destX)) != Math.abs((this.getY() - destY)))
		{
			return false;
		}

		if ((destY > this.getY()) && (destX > this.getX()))
		{
			int squaresMoved = Math.abs(destY - this.getY());
			for (int i = 1; i < squaresMoved; i++) 
			{
				Piece p = board.getPiece(this.getX() + i, this.getY() + i);
				if (p != null)
				{
					return false;
				}
			}
		}
		
		if ((destY > this.getY()) && (this.getX() > destX))
		{
			int squaresMoved = Math.abs(destY - this.getY());
			for (int i = 1; i < squaresMoved; i++) 
			{
				Piece p = board.getPiece(this.getX() - i, this.getY() + i);
				if (p != null)
				{
					return false;
				}
			}
		}
		
		if ((this.getY() > destY) && (destX > this.getX()))
		{
			int squaresMoved = Math.abs(destX - this.getX());
			for (int i = 1; i < squaresMoved; i++) 
			{
				Piece p = board.getPiece(this.getX() + i, this.getY() - i);
				if (p != null)
				{
					return false;
				}
			}
		}
		
		if ((this.getY() > destY) && (this.getX() > destX))
		{
			int squaresMoved = Math.abs(destX - this.getX());
			for (int i = 1; i < squaresMoved; i++) 
			{
				Piece p = board.getPiece(this.getX() - i, this.getY() - i);
				if (p != null)
				{
					return false;
				}
			}
		}
        
        return true;
    }
}
