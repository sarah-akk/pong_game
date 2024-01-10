
package pongame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class paddel extends Rectangle {
    
    int id ;
    int yvelocity;
    int speed =10;

    paddel(int x, int y, int paddelwidth, int paddelhight, int id) {
 super(x,y,paddelwidth,paddelhight);
        this.id=id;
    }

   
  public void keyPressed(KeyEvent e){
switch(id)
{
    case 1 :
        if(e.getKeyCode()==KeyEvent.VK_W)
        {
            setYdirection(-speed);
            move();
        }
            if(e.getKeyCode()==KeyEvent.VK_S)
        {
            setYdirection(speed);
            move();
        }
        break;
     case 2 :
        if(e.getKeyCode()==KeyEvent.VK_UP)
        {
            setYdirection(-speed);
            move();
        }
            if(e.getKeyCode()==KeyEvent.VK_DOWN)
        {
            setYdirection(speed);
            move();
        }
      break;

}
}
  public void keyReleased(KeyEvent e){
   switch(id)
{
        case 1 :
        if(e.getKeyCode()==KeyEvent.VK_W)
        {
            setYdirection(0);
            move();
        }
            if(e.getKeyCode()==KeyEvent.VK_S)
        {
            setYdirection(0);
            move();
        }
            break;
        case 2 :
        if(e.getKeyCode()==KeyEvent.VK_UP)
        {
            setYdirection(0);
            move();
        }
            if(e.getKeyCode()==KeyEvent.VK_DOWN)
        {
            setYdirection(0);
            move();
        }
     
      break;
          }
     }
          public void setYdirection(int yDirection)
          {
                    yvelocity = yDirection;

          }
          
          public void move(){
              y = y + yvelocity ;
          }
          
          public void draw(Graphics g){
          if(id==1)
            g.setColor(Color.blue);
        else
            g.setColor(Color.red);
                
           g.fillRect(x,y,width,height);
       
              
          }

   }