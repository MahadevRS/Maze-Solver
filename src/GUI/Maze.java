package GUI;

import Algorithms.DFS;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Maze extends JFrame implements ActionListener,MouseListener{
    //Maze matrix 
    // 1 is blocked wall
    // 0 not visited
    // 2 visited
    // 9 target cell
    private int[][] maze = 
        {    
        {1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,0,1,0,1,0,1,0,0,0,0,0,1},
        {1,0,1,0,0,0,1,0,1,1,1,0,1},
        {1,0,0,0,1,1,1,0,0,0,1,0,1},
        {1,0,1,0,0,0,0,0,1,1,1,0,1},
        {1,0,1,0,1,1,1,0,1,0,0,0,1},
        {1,0,1,0,1,0,0,0,1,1,1,0,1},
        {1,0,1,0,1,1,1,0,1,0,1,0,1},
        {1,0,0,0,0,0,0,0,0,0,1,9,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1}
    };

       
    private int[] start={1,1};
    private int[] target ={8,11};
    
    private List<Integer> path = new ArrayList<>();
    
    JButton submitbutton;
    JButton cancelbutton;
    JButton clearbutton;
    
   public Maze(){
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setTitle("Maze Solver");
       this.setSize(520,500);
       this.setLayout(null);
       this.setLocationRelativeTo(null);
       submitbutton = new JButton("Submit");
       submitbutton.setBounds(70,400,80,30);
       submitbutton.addActionListener(this);
       
       cancelbutton = new JButton("Cancel");
       cancelbutton.setBounds(330,400,80,30);
       cancelbutton.addActionListener(this);
       
       clearbutton = new JButton("Clear");
       clearbutton.setBounds(200,400,80,30);
       clearbutton.addActionListener(this);
       
       this.add(submitbutton);
       this.add(clearbutton);
       this.add(cancelbutton);
       
       this.addMouseListener(this);
       
   } 
   
   @Override
   public void paint(Graphics g){
       super.paint(g);
       for(int i=0;i<maze.length;i++){
           for(int j=0;j<maze[0].length;j++){
               Color color;
               switch (maze[i][j]){
                   case 1: color= Color.BLACK; break;
                   case 9: color=Color.RED; break;
                   default: color=Color.WHITE; break;
               }
               g.setColor(color);
               g.fillRect(40*j, 20+40*i, 40, 40);
               g.setColor(Color.BLACK);
               g.drawRect(40*j, 20+40*i, 40, 40);
           }
           
           g.setColor(Color.BLUE);
           g.fillRect(40*start[1], 40*start[0]+20, 40, 40);
           g.setColor(Color.black);
           g.drawRect(40*start[1], 40*start[0]+20, 40, 40);
           
           for(int p=0;p<path.size()-2;p+=2){
               int pathx=path.get(p);
               int pathy=path.get(p+1);
               g.setColor(Color.GREEN);
               g.fillRect(40*pathy, 40*pathx+20, 40, 40);
           }
       }
   }
   @Override
   public void actionPerformed(ActionEvent e){
       if(e.getSource()==submitbutton){
           try{
               DFS.searchpath(maze,start[0],start[1],path);
               this.repaint();
           }
           catch(Exception excp){
               JOptionPane.showMessageDialog(null, excp.toString());
           }
       }
       if(e.getSource()==cancelbutton){
           int flag=JOptionPane.showConfirmDialog(null, "Are you Sure?");
           if(flag==0){
               System.exit(0);
           }
       }
       if(e.getSource()==clearbutton){
           path.clear();
           for(int i=0;i<maze.length;i++){
               for(int j=0;j<maze[0].length;j++){
                   if(maze[i][j]==2){
                       maze[i][j]=0;
                   }
               }
           }
           this.repaint();
       }
   }
  
    @Override
   public void mouseClicked(MouseEvent e){

       if(e.getX()>=0 && e.getX()<=maze[0].length*40 && e.getY()>=20 && e.getY()<=maze.length*40+20){
           int row=(e.getY()-20)/40;
           int col=e.getX()/40;
           
           if(maze[row][col]==1) return;
           
           Graphics g=getGraphics();
           g.setColor(Color.WHITE);
           g.fillRect(40*start[1], 40*start[0]+20, 40, 40);
           g.setColor(Color.black);
           g.drawRect(40*start[1], 40*start[0]+20, 40, 40);
                    
           g.setColor(Color.BLUE);
           g.fillRect(40*target[1], 40*target[0]+20, 40, 40);
           g.setColor(Color.black);
           g.drawRect(40*target[1], 40*target[0]+20, 40, 40);
           start[0]=target[0];
           start[1]=target[1];
           
           g.setColor(Color.red);
           g.fillRect(col*40, row*40+20, 40, 40);
           maze[target[0]][target[1]]=0;
           maze[row][col]=9;
           
           target[0]=row;
           target[1]=col;
       }
       
   }
  
   
   public static void main(String[] args){
       Maze gui=new Maze();
       gui.setVisible(true);
       
   }

    @Override
    public void mousePressed(MouseEvent e) {
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
