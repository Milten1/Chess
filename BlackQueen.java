
package Pieces;

public class BlackQueen extends Black{
    
    public BlackQueen() {
        this.piece = '♛';
    }

    @Override
    public boolean isMoveValid(int[] coordinates, Pieces[][] board, String enemy, String player) {
        return true;
    }
    
    @Override
    public void beenMoved() {
    }
    
}
