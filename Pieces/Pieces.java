
package Pieces;

public abstract class Pieces {
    protected char piece;
    
    public abstract boolean isMoveValid();
    
    @Override
    public String toString() {
        return piece + "";
    }
    
}
