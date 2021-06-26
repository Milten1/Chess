
package AI;

import Pieces.*;
import java.util.Random;


public class RandomMoves {
    
    
    
    public int[] nextRandomMove(){
        int[] coor = new int[4];
        
        Random random = new Random();
        
        coor[0] = random.nextInt(8);
        coor[1] = random.nextInt(8);
        coor[2] = random.nextInt(8);
        coor[3] = random.nextInt(8);
        
        return coor;
    }
}
