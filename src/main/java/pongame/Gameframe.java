
package pongame;

import java.awt.Color;
import javax.swing.JFrame;


public  class Gameframe extends JFrame {
   Gamepanel panel ;
    public Gameframe() {
        panel = new Gamepanel();
        this.add(panel);
        this.setTitle("pong game");
        this.setResizable(false);
        this.setBackground(Color.black);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.pack();
this.setVisible(true);
    }

  
}
