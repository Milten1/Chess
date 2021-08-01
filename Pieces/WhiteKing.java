
package Pieces;

public class WhiteKing extends Pieces{
    
    public WhiteKing() {
        this.piece = '♔';
    }

    @Override
    public boolean isMoveValid() {
        return true;
    }
    
}
