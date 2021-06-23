
package Pieces;

public class WhiteKnight extends White{

    public WhiteKnight() {
        this.piece = '♘';
    }

    @Override
    public boolean isMoveValid(int[] coordinates, Pieces[][] board, String enemy, String player) {
        
        if((Math.abs(coordinates[0] - coordinates[2]) == 2 && Math.abs(coordinates[1] - coordinates[3]) == 1) &&
                !(board[coordinates[2]][coordinates[3]].getClass().getSuperclass().getSimpleName().equals(player))) return true;
        
        if((Math.abs(coordinates[0] - coordinates[2]) == 1 && Math.abs(coordinates[1] - coordinates[3]) == 2) &&
                !(board[coordinates[2]][coordinates[3]].getClass().getSuperclass().getSimpleName().equals(player))) return true;
        
        return false;
    }
    
    @Override
    public void beenMoved() {
    }
    
}