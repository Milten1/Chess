
package Pieces;

public class BlackRook extends Pieces{
    
    public BlackRook() {
        this.piece = '♜';
    }

    @Override
    public boolean isMoveValid(int[] coordinates) {
        return true;
    }
    
}
