
package pongame;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.JPanel;
import java.awt.event.KeyListener;


public class Gamepanel extends JPanel implements Runnable {
       static final int Game_width=1200;
      static final int Game_hight=(int)(Game_width*(0.5555));
      static final Dimension SCREEN_SIZE = new Dimension(Game_width,Game_hight);
     static final int balldiameter = 20;
     static final int paddelwidth=25;
    static final int paddelhight=100;
  Thread gamethread;
  Image image;
  Graphics graphic;
  Random random;
  paddel paddle;
  Ball ball;
  Score score;
     paddel paddle1;
     paddel paddle2;
  
  
             
    public Gamepanel() {
        newpaddels();
        newBall();
        
        score=new Score(Game_width,Game_hight); 
        this.setFocusable(true);
        
        this.addKeyListener(new AL( ));
        this.setPreferredSize(SCREEN_SIZE);
        
        gamethread =new Thread(this);
        gamethread .start();    
        
    }
    public void newBall(){
        random= new Random();
        ball=new Ball((Game_width/2)-(balldiameter/2),random.nextInt(Game_hight-balldiameter),balldiameter,balldiameter);
        
    }
    public void newpaddels(){
        paddle1 =new paddel(0,(Game_hight/2)-(paddelhight/2),paddelwidth,paddelhight,1);
        paddle2 =new paddel(Game_width-paddelwidth,(Game_hight/2)-(paddelhight/2),paddelwidth,paddelhight,2);
           
    }
    
    public void paint(Graphics g){
        image=createImage(getWidth(),getHeight());
        graphic = image.getGraphics();
        draw(graphic);
        g.drawImage(image,0,0,this);
        
    }
    public void draw (Graphics g){
       paddle1.draw(g);
       paddle2.draw(g);
       ball.draw(g);
     score.Draw(g);
     

    }
    public void move(){
        paddle1.move();
        paddle2.move();
        ball.move();
    }
    public void checkcollision(){
        // bounce ball
        if (ball.y<=0)
            ball.setYdiration(-ball.yvelocity);
        if (ball.y>=Game_hight-balldiameter)
            ball.setYdiration(-ball.yvelocity); 
        // bounce ball of paddles
        if(ball.intersects(paddle1)){
            ball.xvelocity=Math.abs(ball.xvelocity);
               ball.xvelocity++;
               if(ball.yvelocity>0)
                   ball.yvelocity++;
               else
                   ball.yvelocity--;
               ball.setXdiration(ball.xvelocity);
                ball.setYdiration(ball.yvelocity);
            // score for player 1 and new ball&paddles
           
            }
       if(ball.intersects(paddle2)){
            ball.xvelocity=Math.abs(ball.xvelocity);
               ball.xvelocity++;
               if( ball.yvelocity>0)
                   ball.yvelocity++;
               else
                   ball.yvelocity--;
               ball.setXdiration(-ball.xvelocity);
                ball.setYdiration(ball.yvelocity);
            }
       
        if(ball.x<=0)
            {
                score.player2++;
                newpaddels();
                newBall();
                System.out.println("player1 : " + score.player2);
                
            }
              // player 2 
              if(ball.x>=Game_width-balldiameter)
            {
                score.player1++;
                newpaddels();
                newBall();
                System.out.println("player2 : " + score.player1);
                
            }
          
    

    }
    public void run(){
        long lastTime=System.nanoTime();
        double amountOfTicks=60.0;
        double ns=1000000000/amountOfTicks;
        double delta=0;
        while(true){
            long now=System.nanoTime();
            delta += (now-lastTime)/ns;
            lastTime=now;
            if(delta>=1)
            {
                move();
                checkcollision();
                repaint();
                delta--;
                }
        }
        
    }
    public class AL extends KeyAdapter{
        public void keyPressed(KeyEvent e){
            paddle1.keyPressed(e);
            paddle2.keyPressed(e);
        }
        public void keyReleased(KeyEvent e){
            paddle1.keyReleased(e);
            paddle2.keyReleased(e);

        }
    }
}
