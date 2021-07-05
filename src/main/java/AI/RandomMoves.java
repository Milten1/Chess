
package AI;

import Pieces.*;
import java.util.ArrayList;
import java.util.Random;


public class RandomMoves {
    
    
    
    public int[] nextRandomMove(Pieces[][] board, String enemy, String player){
        
        Pieces[][] tempBoard = board;
        
        ArrayList<int[]> array = new ArrayList<int[]>();
        
        for(int i = 0; i < 8; i++){
                for(int j = 0; j < 8; j++){
                    if(tempBoard[i][j].getClass().getSuperclass().getSimpleName().equals(player)){
                        int[] coor = new int[4];
                        
                        coor[2] = i;
                        coor[3] = j;
                        
                        for(int x = 0; x < 8; x++){
                            for(int y = 0; y < 8; y++){
                                coor[0] = x;
                                coor[1] = y;
                                
                                if(tempBoard[x][y].isMoveValid(coor, tempBoard, enemy, player)){
                                    array.add(coor);
                                }
                            }
                        }
                    }
                }
            }
        
        int index = (int)(Math.random() * array.size());
        
        return array.get(index);
    }
}