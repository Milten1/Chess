
package Pieces;

public class Empty extends Pieces{//empty field on the board
    
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
