package chessgui.pieces;

import chessgui.Board;

public class Pawn extends Piece {

	private boolean has_moved;

	public Pawn(int x, int y, boolean is_white, String file_path, Board board)
	{
		super(x,y,is_white,file_path, board);
		has_moved = false;
	}

	public void setHasMoved(boolean has_moved)
	{
		this.has_moved = has_moved;
	}

	public boolean getHasMoved()
	{
		return has_moved;
	}

	@Override
	public boolean canMove(int destX, int destY)
	{
		// Remember: A pawn may only move towards the oponent's side of the board.
		// If the pawn has not moved yet in the game, for its first move it can 
		// move two spaces forward. Otherwise, it may only move one space. 
		// When not attacking it may only move straight ahead.
		// When attacking it may only move space diagonally forward

		// WRITE CODE HERE
		Piece destPiece = board.getPiece(destX, destY);

		if (destPiece != null) 
		{
			if ((destPiece.isWhite() && this.isWhite()) || (!destPiece.isWhite() && !this.isWhite()))
			{
				return false;
			}

			if (this.isWhite())
			{
				if ((destY - this.getY()) != 1)
					return false;
			}

			if (!this.isWhite())
			{
				if ((this.getY() - destY) != 1)
					return false;
			}
			
			if (Math.abs(destX - this.getX()) != 1)
			{
				return false;
			}
		}
		
		if (destPiece == null) 
		{
			if (Math.abs(destX - this.getX()) != 0)
				return false;
		}

		if (this.isWhite())
		{
			if (this.getY() == 1)
			{
				if ((destY - this.getY()) > 2)
					return false;
			}
			else 
				if ((destY - this.getY()) > 1)
					return false;
		}

		if (!this.isWhite())
		{
			if (this.getY() == 6) 
			{
				if ((this.getY() - destY) > 2)
					return false;
			}
			else 
				if ((this.getY() - destY) > 1)
					return false;
		}


		return true;
	}
}
