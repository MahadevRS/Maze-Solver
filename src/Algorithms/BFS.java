
package Algorithms;

import java.util.ArrayList;
import java.util.List;

public class BFS {
    
    public List<Integer> searchpath(int[][] maze,int x, int y,List<Integer> path){
        List<Integer> ans=new ArrayList<>();
        
        
        return ans;
    }
    
    
    public static void main(String[] args){
        BFS obj=new BFS();
        List<Integer> path=new ArrayList<>();
        int maze[][]={{0,0,1},
                      {0,1,9},
                      {0,0,0}};
        
        obj.searchpath(maze, 0, 0, path);
    }
}
