
package snakegame;

import javax.swing.*;
public class Snakegame extends JFrame {

    Snakegame(){
        super("Snake Game");
        add(new Board()); //now board has changed into panel || panel is like a div in css 
        pack();
        //pack fn is for immidiately changes apply on the java Frame;
        
        setResizable(false); //this fn is prevent to resize the frame by custom.
        setLocationRelativeTo(null);
        
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        new Snakegame().setVisible(true);
    }
    
}
