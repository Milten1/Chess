
package Pieces;

public class WhiteQueen extends White{
    
    public WhiteQueen() {
        this.piece = '♕';
    }

    @Override
    public boolean isMoveValid(int[] coordinates, Pieces[][] board, String enemy, String player) {
        return true;
    }
    
    @Override
    public void beenMoved() {
    }
}
