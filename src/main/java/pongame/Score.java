
package pongame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import static pongame.Gamepanel.Game_hight;
import static pongame.Gamepanel.Game_width;


public class Score extends Rectangle {
 static int Game_whidth;
        static int Game_height;
       int player1;
       int player2;
       
    Score(int Game_width,int Game_hight) {
       Score.Game_whidth= Game_whidth;
       Score.Game_height=Game_height;
    }
    
   

     public void Draw(Graphics e){
        e.setColor(Color.white);
        e.setFont(new Font ("Consolas" ,Font.PLAIN,60));
        e.drawLine(Game_width/2,0,Game_width/2,Game_hight);
        e.drawString(String.valueOf(player1/10)+String.valueOf(player1%10), (Game_width/2)-85 ,50);
       e.drawString(String.valueOf(player2/10)+String.valueOf(player2%10), (Game_width/2)+20 ,50);

    }
}
