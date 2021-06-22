
package Pieces;


public class WhiteBishop extends White{

    public WhiteBishop() {
        this.piece = '♗';
    }

    @Override
    public boolean isMoveValid(int[] coordinates, Pieces[][] board, String enemy, String player) {
        return true;
    }
    
    @Override
    public void beenMoved() {
    }
    
}
