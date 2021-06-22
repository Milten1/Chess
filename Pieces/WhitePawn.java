
package Pieces;

public class WhitePawn extends Pieces{
    private boolean hasBeenMoved;

    public WhitePawn() {
        this.piece = '♙';
        this.hasBeenMoved = false;
    }

    @Override
    public boolean isMoveValid() {
        return true;
    }
    
}
