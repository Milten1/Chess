
package Pieces;

public class WhiteKing extends White{
    
    public WhiteKing() {
        this.piece = '♔';
    }

    @Override
    public boolean isMoveValid(int[] coordinates, Pieces[][] board, String enemy, String player) {
        return true;
    }
    
    @Override
    public void beenMoved() {
    }
}
