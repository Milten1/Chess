
package Pieces;


public class BlackBishop extends Black{

    public BlackBishop() {
        this.piece = '♝';
    }

    @Override
    public boolean isMoveValid(int[] coordinates, Pieces[][] board, String enemy, String player) {
        
        if(coordinates[0] == coordinates[2] && coordinates[1] == coordinates[3]) return false;
        
        return true;
    }

    @Override
    public void beenMoved() {
    }
    
}
