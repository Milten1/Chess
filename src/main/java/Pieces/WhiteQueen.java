
package Pieces;

public class WhiteQueen extends Pieces{
    
    public WhiteQueen() {
        this.piece = '♕';
    }

    @Override
    public boolean isMoveValid() {
        return true;
    }
}
