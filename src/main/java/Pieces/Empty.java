
package Pieces;

public class Empty extends Pieces{
    
    public Empty() {
        this.piece = ' ';
    }

    @Override
    public boolean isMoveValid(int[] coordinates, Pieces[][] board, String enemy, String player) {
        return false;
    }
    
    @Override
    public void beenMoved() {
    }
    
    
}
