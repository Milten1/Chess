
package Pieces;

public class WhiteKnight extends Pieces{

    public WhiteKnight() {
        this.piece = '♘';
    }

    @Override
    public boolean isMoveValid() {
        return true;
    }
    
}
