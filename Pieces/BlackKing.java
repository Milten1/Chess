
package Pieces;

public class BlackKing extends Pieces{
    
    public BlackKing() {
        this.piece = '♚';
    }

    @Override
    public boolean isMoveValid() {
        return true;
    }
    
}
