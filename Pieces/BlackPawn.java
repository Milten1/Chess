
package Pieces;

public class BlackPawn extends Pieces{
    private boolean hasBeenMoved;

    public BlackPawn() {
        this.piece = '♟';
        this.hasBeenMoved = false;
    }
    
    

    @Override
    public boolean isMoveValid() {
        return true;
    }
    
}
