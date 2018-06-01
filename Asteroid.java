import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Math;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

@SuppressWarnings("serial")
public class Asteroid extends JFrame implements KeyListener {
   
   private static final int CANVAS_WIDTH = 640;
   private static final int CANVAS_HEIGHT = 480;
   private static final int UPDATE_PERIOD = 50; 
 
   private DrawCanvas canvas;  
   
   private int x =(int)(Math.random()*640);
   private int y=0;
   private int x2=  (int)(Math.random()*640);
   private int y2=0;
   private int y3=0;
   private int y4=0;
   private int y5=0;
   private int x3=  (int)(Math.random()*640);
   private int x4=  (int)(Math.random()*640);
   private int x5=  (int)(Math.random()*640);
   private int ship_x=320;
   private int ship_y=450;
    int shipSpeed=0;

   
   private int size = 25;        
   private int xSpeed = 200, ySpeed = 0; 
 
   
   public Asteroid() {
      canvas = new DrawCanvas();
      canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
      this.setContentPane(canvas);
      this.setDefaultCloseOperation(EXIT_ON_CLOSE);
      this.pack();
      this.setTitle("Bouncing Ball");
      this.setVisible(true);
 		
      
      ActionListener updateTask = new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent evt) {
               
            repaint();  
            update();
         }
      };
      
      new Timer(UPDATE_PERIOD, updateTask).start();
   }
 
 
 public void keyTyped(KeyEvent e)
 {
 	
 }
 
 
 
 public void keyPressed(KeyEvent e)
 {
 	  int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
        
            shipSpeed = -3;
        }

        if (key == KeyEvent.VK_RIGHT) {
        
            shipSpeed = 3;
        }
        System.out.println(e.getKeyChar());
        
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
 }
 
 
 /*you must use the key listener in order for this to work*/
 
 
 
 
   
  public void update(){
  	y+=3;
  	y2+=3;
  	y3+=3;
  	y4+=3;
  	y5+=3;
  	ship_x+=shipSpeed;
  }
   
 
   
   private class DrawCanvas extends JPanel {
      @Override
      public void paintComponent(Graphics g) {
         super.paintComponent(g);
          
         setBackground(Color.BLACK);
         g.setColor(Color.BLUE);
         g.fillRect(0,420,1000,5);
         g.fillOval(x, y, size, size);
        g.fillOval(x2,y2,size,size);
        g.fillOval(x3,y3,size,size);
        g.fillOval(x4,y4,size,size);
        g.fillOval(x5,y5,size,size);
        g.fillRect(ship_x,ship_y,15,15);
       if(y2>395)
       y2=10000;
       if(y>395)
       y=10000;
       if(y3>395)
       y3=10000;
       if(y4>395)
       y4=10000;
      if(y5>395)
       y5=10000; 
      }
   
 }

 
   
   public static void main(String[] args) {
      
      SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            new Asteroid(); 
         }
         
      });
     
   }
}
