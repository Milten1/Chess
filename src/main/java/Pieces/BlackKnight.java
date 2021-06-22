
package Pieces;

public class BlackKnight extends Pieces{

    public BlackKnight() {
        this.piece = '♞';
    }

    @Override
    public boolean isMoveValid() {
        return true;
    }
    
}
