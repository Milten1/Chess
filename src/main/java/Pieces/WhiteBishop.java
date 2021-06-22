
package Pieces;


public class WhiteBishop extends Pieces{

    public WhiteBishop() {
        this.piece = '♗';
    }

    @Override
    public boolean isMoveValid(int[] coordinates) {
        return true;
    }
    
}
