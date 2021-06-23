
package Pieces;

public class WhiteKing extends White{
    
    public WhiteKing() {
        this.piece = '♔';
    }

    @Override
    public boolean isMoveValid(int[] coordinates, Pieces[][] board, String enemy, String player) {
        
        
        return (Math.abs(coordinates[0] - coordinates[2]) < 2 && Math.abs(coordinates[1] - coordinates[3]) < 2) &&
                !(board[coordinates[2]][coordinates[3]].getClass().getSuperclass().getSimpleName().equals(player));
    }
    
    @Override
    public void beenMoved() {
    }
    
}
