
package Pieces;


public class BlackBishop extends Pieces{

    public BlackBishop() {
        this.piece = '♝';
    }

    @Override
    public boolean isMoveValid(int[] coordinates) {
        return true;
    }
    
}
