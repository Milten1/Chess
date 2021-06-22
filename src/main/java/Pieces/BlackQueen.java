
package Pieces;

public class BlackQueen extends Pieces{
    
    public BlackQueen() {
        this.piece = '♛';
    }

    @Override
    public boolean isMoveValid(int[] coordinates) {
        return true;
    }
    
}
