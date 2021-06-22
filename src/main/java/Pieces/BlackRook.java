
package Pieces;

public class BlackRook extends Pieces{
    
    public BlackRook() {
        this.piece = '♜';
    }

    @Override
    public boolean isMoveValid() {
        return true;
    }
    
}
