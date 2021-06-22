
package Pieces;

public class BlackRook extends Black{
    
    public BlackRook() {
        this.piece = '♜';
    }

    @Override
    public boolean isMoveValid(int[] coordinates, Pieces[][] board, String enemy, String player) {
        return true;
    }
    
    @Override
    public void beenMoved() {
    }
    
}
