
package Pieces;

public abstract class Pieces {
    protected char piece;
    
    public abstract boolean isMoveValid(int[] coordinates);
    
    @Override
    public String toString() {
        return piece + "";
    }
    
}
