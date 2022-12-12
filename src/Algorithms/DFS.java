
package Algorithms;

import java.util.ArrayList;
import java.util.List;

public class DFS {
   
    public static boolean searchpath(int[][] maze, int x, int y, List<Integer> path){
        
        if(maze[x][y]==9) {
            return true;
        }
        
        if(maze[x][y]==0){
            maze[x][y]=2;
            
            int[] dx={1,0,-1,0};
            int[] dy={0,-1,0,1};
            
            for(int d=0;d<4;d++){
                int newx=x+dx[d];
                int newy=y+dy[d];
              
                if(newx>=0 && newy>=0 && newx<maze.length && newy<maze[0].length && searchpath(maze,newx,newy,path)){
                    path.add(x);
                    path.add(y);
                    System.out.println(newx+" "+newy);
                    return true;
                }
            }
        }
        
        return false;
    }
    
    
    public static void main(String[] args){
        DFS obj=new DFS();
        List<Integer> path=new ArrayList<>();
        int maze[][]={{0,0,1},
                      {0,1,9},
                      {0,0,0}};
        
        obj.searchpath(maze, 0, 0, path);
    }
}
