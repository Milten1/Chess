
package AI;
import Pieces.*;
import java.util.ArrayList;

public class RandomMoves {
    
    
    
    public int[] nextRandomMove(Pieces[][] board, String enemy, String player){
        
        Pieces[][] tempBoard = board;
        
        ArrayList<Integer> a = new ArrayList<Integer>();
        
        
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
                                
                                if(tempBoard[i][j].isMoveValid(coor, tempBoard, enemy, player)){
                                    
                                    a.add(coor[0]);
                                    a.add(coor[1]);
                                    a.add(coor[2]);
                                    a.add(coor[3]);
                                }
                            }
                        }
                    }
                }
            }
        
        while(true){
            int ind = (int)(Math.random() * a.size());
            
            if(ind % 4 == 0 || ind == 0) {
                int[] result = new int[4];
                
                result[0] = a.get(ind);
                result[1] = a.get(ind+1);
                result[2] = a.get(ind+2);
                result[3] = a.get(ind+3);
                
                return result;
            }
        }
    }
}