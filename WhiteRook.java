
package Pieces;

public class WhiteRook extends White{
    
    public WhiteRook() {
        this.piece = '♖';
    }

    @Override
    public boolean isMoveValid(int[] coordinates, Pieces[][] board, String enemy, String player) {
        return true;
    }
    
    @Override
    public void beenMoved() {
    }
    
}
