
package Pieces;

public class WhiteRook extends Pieces{
    
    public WhiteRook() {
        this.piece = '♖';
    }

    @Override
    public boolean isMoveValid(int[] coordinates) {
        return true;
    }
    
}
