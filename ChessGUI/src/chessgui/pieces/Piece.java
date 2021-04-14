package chessgui.pieces;

import chessgui.Board;

public class Piece {
	private int x;
	private int y;
	final private boolean white;
	private String file_path;
	public Board board;
	public boolean inCheck = false;

	public Piece(int x, int y, boolean white, String file_path, Board board)
	{
		this.white = white;
		this.x = x;
		this.y = y;
		this.file_path = file_path;
		this.board = board;
	}

	public String getFilePath()
	{
		return file_path;
	}

	public void setFilePath(String path)
	{
		this.file_path = path;
	}

	public boolean isWhite()
	{
		return white;
	}

	public boolean isBlack()
	{
		return !white;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	public boolean canMove(int destX, int destY)
	{
		return false;
	}

	public boolean inDanger(int x, int y) 
	{
		for(int i=x+1;i<8;i++)
		{
			if(board.getPiece(i, y)==null)
				continue;
			else if (board.getPiece(i, y).isWhite()==this.isWhite())
				if (board.getPiece(i, y) instanceof King)
					continue;
				else
					break;
			else
			{
				if ((board.getPiece(i, y) instanceof Rook) || (board.getPiece(i, y) instanceof Queen))
					return true;
				else
					break;
			}
		}
		for(int i=x-1;i>=0;i--)
		{
			if(board.getPiece(i, y)==null)
				continue;
			else if (board.getPiece(i, y).isWhite()==this.isWhite())
				if (board.getPiece(i, y) instanceof King)
					continue;
				else
					break;
			else
			{
				if ((board.getPiece(i, y) instanceof Rook) || (board.getPiece(i, y) instanceof Queen))
					return true;
				else
					break;
			}
		}
		for(int i=y+1;i<8;i++)
		{
			if(board.getPiece(x, i)==null)
				continue;
			else if (board.getPiece(x, i).isWhite()==this.isWhite())
				if (board.getPiece(x, i) instanceof King)
					continue;
				else 
					break;
			else
			{
				if ((board.getPiece(x, i) instanceof Rook) || (board.getPiece(x, i) instanceof Queen))
					return true;
				else
					break;
			}
		}
		for(int i=y-1;i>=0;i--)
		{
			if(board.getPiece(x, i)==null)
				continue;
			else if (board.getPiece(x, i).isWhite()==this.isWhite())
				if (board.getPiece(x, i) instanceof King)
					continue;
				else
					break;
			else
			{
				if ((board.getPiece(x, i) instanceof Rook) || (board.getPiece(x, i) instanceof Queen))
					return true;
				else
					break;
			}
		}
		return false;
	}









}
