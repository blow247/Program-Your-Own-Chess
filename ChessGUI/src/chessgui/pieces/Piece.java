package chessgui.pieces;

import chessgui.Board;

public class Piece {
    private int x;
    private int y;
    final private boolean white;
    private String file_path;
    public Board board;
    
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
    
    public boolean canMove(int destination_x, int destination_y)
    {
        return false;
    }
}
