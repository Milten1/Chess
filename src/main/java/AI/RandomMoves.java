
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
                        
                        coor[0] = i;
                        coor[1] = j;
                        
                        for(int x = 0; x < 8; x++){
                            for(int y = 0; y < 8; y++){
                                coor[2] = x;
                                coor[3] = y;
                                
//                                System.out.println(coor[0] + "" + coor[1] + "-" + coor[2] + "" + coor[3]);
                                
                                if(tempBoard[i][j].isMoveValid(coor, tempBoard, enemy, player)){
                                    array.add(coor);
//                                    System.out.print("added ");
                                    
//                                    System.out.println(coor[0] + "" + coor[1] + "-" + coor[2] + "" + coor[3]);
                                }
                            }
                        }
                    }
                }
            }
        
        int index = (int)(Math.random() * array.size());
        
        for(int[] coor: array){
            System.out.println(coor[0] + "" + coor[1] + "-" + coor[2] + "" + coor[3]);
        }

        return array.get(index);
    }
}