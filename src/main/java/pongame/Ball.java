
package pongame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball  extends Rectangle {
    Random random;
    int yvelocity;
    int xvelocity;
    int initialspeed=2;

    public Ball(int x , int y  , int width , int hight) {
        super(x,y,width,hight);
        random=new Random();
        int randomXDirection = random.nextInt(2);
        if(randomXDirection==0)
            randomXDirection--;
        setXdiration(randomXDirection*initialspeed);
  int randomYDirection = random.nextInt(2);
   if(randomYDirection==0)
            randomYDirection--;
        setYdiration(randomYDirection*initialspeed);
        
    }
    
    public void setXdiration(int randomXDirection)
    {
        xvelocity=randomXDirection;
    }
      public void setYdiration(int randomYDirection)
    {
          yvelocity=randomYDirection;
    }
    public void move(){
        x+=xvelocity;
        y+=yvelocity;
        
    }
    public void draw(Graphics g){
        g.setColor(Color.white);
        g.fillOval(x,y,height,width);
    }
}
