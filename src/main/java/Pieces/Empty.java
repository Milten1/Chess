
package Pieces;

public class Empty extends Pieces{
    
    public Empty() {
        this.piece = ' ';
    }

    @Override
    public boolean isMoveValid(int[] coordinates) {
        return false;
    }
    
    
}
