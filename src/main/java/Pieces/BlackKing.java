
package Pieces;

public class BlackKing extends Black{
    
    public BlackKing() {
        this.piece = '♚';
    }

    @Override
    public boolean isMoveValid(int[] coordinates, Pieces[][] board, String enemy, String player) {
        return true;
    }
    
    @Override
    public void beenMoved() {
    }
    
}
