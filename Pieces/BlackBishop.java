
package Pieces;


public class BlackBishop extends Black{

    public BlackBishop() {
        this.piece = '♝';
    }

    @Override
    public boolean isMoveValid(int[] coordinates, Pieces[][] board, String enemy, String player) {
        return true;
    }

    @Override
    public void beenMoved() {
    }
    
}
