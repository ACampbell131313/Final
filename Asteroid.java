import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Math;
import java.awt.event.KeyEvent; 
import java.awt.event.KeyListener;
@SuppressWarnings("serial")
public class asteroid extends JFrame   {

   
   private static final int CANVAS_WIDTH = 640;
   private static final int CANVAS_HEIGHT = 480;
   private static final int UPDATE_PERIOD = 50; 
  
   private DrawCanvas canvas;  
   boolean shoot=false;
   private int y1=0;
   private int y2=0;
   private int y3=0;
   private int y4=0;
   private int y5=0;
   private int x1=  (int)(Math.random()*640);
   private int x2=  (int)(Math.random()*640);
   private int x3=  (int)(Math.random()*640);
   private int x4=  (int)(Math.random()*640);
   private int x5=  (int)(Math.random()*640);
   private int ship_x=320;
   private int ship_y=450;
    int shipSpeed=0;
int bullet_y=450;
   int bullet_x=ship_x;
   private int size = 25;        
   private int half=size/2;
 int bulletSpeed=0;
   
   public asteroid()  {
      canvas = new DrawCanvas();
      canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
      this.setContentPane(canvas);
      this.setDefaultCloseOperation(EXIT_ON_CLOSE);
      this.pack();
      this.setTitle("Bouncing Ball");
      this.setVisible(true);
      addKeyListener(new KeyInput());
  
      ActionListener updateTask = new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent evt) {
               
            repaint();  
            update();
         }
      };
      
      new Timer(UPDATE_PERIOD, updateTask).start();
   }
 
 
   
  public void update(){
  	y1+=1;
  	y2+=1;
  	y3+=1;
  	y4+=1;
  	y5+=1;
  	ship_x+=shipSpeed;
  	bullet_y+=bulletSpeed;
  }
   
 
   
   private class DrawCanvas extends JPanel {
      @Override
      public void paintComponent(Graphics g) {
         super.paintComponent(g);
          
         setBackground(Color.BLACK);
         g.setColor(Color.BLUE);
         g.fillRect(0,420,1000,5);
         g.fillOval(x1, y1, size, size);
        g.fillOval(x2,y2,size,size);
        g.fillOval(x3,y3,size,size);
        g.fillOval(x4,y4,size,size);
        g.fillOval(x5,y5,size,size);
        g.fillRect(ship_x,ship_y,15,15);
         bullet_x=ship_x;
         
       if(y1>395&&y1<480)
       System.out.println("YOU LOST");
       if(y2>395&&y2<480)
    	   System.out.println("YOU LOST");
       if(y3>395&&y3<480)
    	   System.out.println("YOU LOST");
       if(y4>395&&y4<480)
    	   System.out.println("YOU LOST");
      if(y5>395&&y5<480)
    	  System.out.println("YOU LOST");
      
      if(shoot==true)
       	g.fillOval(bullet_x,bullet_y,10,10);
       	
      
      int bullet_x1=bullet_x-5;
      int bullet_x2=bullet_x+5;
      int bullet_y1=bullet_y-5;
      int bullet_y2=bullet_y+5;
      
      int ball1_x1=x1-size;
      int ball1_x2=x1+size;
      int ball1_y1=y1-size;
      int ball1_y2=y1+size;
      
      int ball2_x1=x2-size;
      int ball2_x2=x2+size;
      int ball2_y1=y2-size;
      int ball2_y2=y2+size;
      
      int ball3_x1=x3-size;
      int ball3_x2=x3+size;
      int ball3_y1=y3-size;
      int ball3_y2=y3+size;
      
      int ball4_x1=x4-size;
      int ball4_x2=x4+size;
      int ball4_y1=y4-size;
      int ball4_y2=y4+size;
      
      int ball5_x1=x5-size;
      int ball5_x2=x5+size;
      int ball5_y1=y5-size;
      int ball5_y2=y5+size;
      
      if(bullet_x<=ball1_x2&&bullet_x>=ball1_x1&&bullet_y>=ball1_y1&&bullet_y<=ball1_y2)
      {
    	  y1=10000;
      }
      if(bullet_x<=ball2_x2&&bullet_x>=ball2_x1&&bullet_y>=ball2_y1&&bullet_y<=ball2_y2)
      {
    	  y2=10000;
      }
      
      if(bullet_x<=ball3_x2&&bullet_x>=ball3_x1&&bullet_y>=ball3_y1&&bullet_y<=ball3_y2)
      {
    	  y3=10000;
      }
      
      if(bullet_x<=ball4_x2&&bullet_x>=ball4_x1&&bullet_y>=ball4_y1&&bullet_y<=ball4_y2)
      {
    	  y4=10000;
      }
      if(bullet_x<=ball5_x2&&bullet_x>=ball5_x1&&bullet_y>=ball5_y1&&bullet_y<=ball5_y2)
      {
    	  y5=10000;
      }
      
      
      if(y1>9999&&y2>9999&&y3>9999&&y4>9999&&y5>9999)
      System.out.println("YOU WON");
      
      
      
      
      
      
      }
   
 }

 public class KeyInput implements KeyListener{
 	  public void keyPressed(KeyEvent e)
 {
 	
 	  int key = e.getKeyCode();
  
        if (key == KeyEvent.VK_LEFT) {
        
            shipSpeed = -10;
        }

        if (key == KeyEvent.VK_RIGHT) {
        
            shipSpeed = 10;
            
        }
    if(key==KeyEvent.VK_SPACE)
 {
 	bulletSpeed=-10;
 	shoot=true;
 	
 }
 } 
  public void keyReleased(KeyEvent e)
 {
 	 int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
        
            shipSpeed = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
        
            shipSpeed = 0;
        }
        
        if(key==KeyEvent.VK_SPACE)
        {
        	shoot=false;
        	bullet_y=450;
        	bulletSpeed=0;
        }
 }
 
      
       public void keyTyped(KeyEvent e)
 {
 int key=e.getKeyCode();
 
 
 
 }
 
  
 }
   
   public static void main(String[] args) {
      
      SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            new asteroid(); 
         }
         
      });
     
   }
}
