
package MazeCollection;


public class MazeCol {
    
    public int[][] mazeselect(int n){
        
        int mazematrix[][][]={
        {
        {1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,0,1,0,1,0,1,0,0,0,0,0,1},
        {1,0,1,0,0,0,1,0,1,1,1,0,1},
        {1,0,0,0,1,1,1,0,0,0,1,0,1},
        {1,0,1,0,0,0,0,0,1,1,1,0,1},
        {1,0,1,0,1,1,1,0,1,0,0,0,1},
        {1,0,1,0,1,0,0,0,1,1,1,0,1},
        {1,0,1,0,1,1,1,0,1,0,1,0,1},
        {1,0,0,0,0,0,0,0,0,0,1,0,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1}
        },
        
        {
        {1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,0,1,0,1,0,1,0,0,0,0,0,1},
        {1,0,1,0,1,0,1,0,1,0,1,0,1},
        {1,0,0,0,0,1,1,0,0,0,1,0,1},
        {1,0,1,0,0,0,0,0,1,1,1,0,1},
        {1,0,1,0,1,0,1,0,1,0,0,0,1},
        {1,0,1,0,1,0,0,0,1,0,1,0,1},
        {1,0,1,0,1,1,1,0,1,0,1,0,1},
        {1,0,0,0,0,0,0,0,0,0,1,0,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1}
        }
    };
    
    return mazematrix[n];
        
    }
    
    
    public static void main(String[] args){
        int n=1;
        MazeCol obj=new MazeCol();
        int maze1[][]=obj.mazeselect(n);
        
        for(int i=0;i<maze1.length;i++){
            for(int j=0;j<maze1[0].length;j++){
                System.out.print(maze1[i][j]);
            }
            System.out.println();
        }
    }
}
