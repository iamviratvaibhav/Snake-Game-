//package snakegame;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//
//public class Board extends JPanel implements ActionListener {
//
//    private Image dot;
//    private Image head;
//    private Image apple;
//
//    private final int ALL_DOTS = 900;
//    private final int DOT_SIZE = 10;
//    private final int RANDOM_POSITION = 24;
//
//    private int apple_x;
//    private int apple_y;  //this is eat of the snake which we can declair variable 
//
//    private final int x[] = new int[ALL_DOTS];  //why I am use array becoz we have multiple dots;
//    private final int y[] = new int[ALL_DOTS];
//
//   
//    
//    private boolean leftDirection = false;
//    private boolean rightDirection = true;
//    private boolean upDirection = false;
//    private boolean downDirection = false;
//    
//    
//    private boolean inGame=true;
//    private Timer timer;
//    private int dots;
//
//    Board() {
//
//        addKeyListener(new TAdapter());
//        setBackground(Color.BLACK);
//        setPreferredSize(new Dimension (300,300));
//        // particularly when working with components like JFrame, JPanel, or similar Swing components.
//        setFocusable(true); //focusable is for when You click on the game framw so it can we runable;
//        
//        loadImages();
//        initGame(); //this is to start the game, this is function
//
//    }
//
//    public void loadImages() {
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("snakegame/icons/apple.png"));
//        apple = i1.getImage();
//        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("snakegame/icons/dot.png"));
//        dot = i2.getImage();
//        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("snakegame/icons/head.png"));
//        head = i3.getImage();
//
//    }
//
//    
//    public void initGame() {
//        dots = 3;
//        for (int i = 0; i < dots; i++) {
//            y[i] = 50;
//            x[i] = 50 - i * DOT_SIZE;
//        }
//        locateApple();
//
//        timer = new Timer(140, this);
//        timer.start();
//    }
//
//       
//    public void locateApple() {
//        int r = (int) (Math.random() * RANDOM_POSITION);
//        apple_x = r * DOT_SIZE;
//
//
//        r = (int) (Math.random() * RANDOM_POSITION);
//        apple_y = r * DOT_SIZE;
//
//    }
//   
//
//    public void paintComponent(Graphics g) {
//        super.paintComponents(g);
//        draw(g);
//    }
//
//    public void draw(Graphics g) {
//        if (inGame) {
//
//            g.drawImage(apple, apple_x, apple_y, this);
//            for (int i = 0; i < dots; i++) {
//                if (i == 0) {
//                    g.drawImage(head, x[i], y[i], this);
//                } else {
//                    g.drawImage(dot, x[i], y[i], this);
//                }
//            }
//            Toolkit.getDefaultToolkit().sync();
//        }else{
//            gameover(g);
//}
//    }  
//public void gameover(Graphics g){
//        String msg="Game Over";
//        Font font=new Font("Releway", Font.BOLD,25 );
//        FontMetrics metrices=getFontMetrics(font);
//        g.setColor(Color.WHITE);
//        g.setFont(font);
//        g.drawString(msg, (300-metrices.stringWidth(msg)/2), 300/2);
//}                      // 300 ke frame me se jitna bhe string ka size hoga wo 
//                // minus kr ke center mai game over ke string show kar denga
//
//        
//        
//        
//    
//    public void move() {
//        for (int i = dots; i > 0; i--) {
//            x[i] = x[i - 1];
//            y[i] = y[i - 1];
//        }
//
//        if (leftDirection) {
//            x[0] -= DOT_SIZE;
//        }
//        if (rightDirection) {
//            x[0] += DOT_SIZE;
//        }
//        if (downDirection) {
//            y[0] += DOT_SIZE;
//        }
//        if (upDirection) {
//            y[0] -= DOT_SIZE;
//        }
//    }
//
//    public void checkApple() {
//        // Check if the snake has eaten the apple
//        if ((x[0] == apple_x) && (y[0] == apple_y)) {
//            dots++;  
//            locateApple();  //snake ke apple khane(remove) ka koi code nehee h
////      //    code yha ye h jb bhe snake iss position pr payuchege to 
//////         wha se wo apple random place pr rakh denge....
//        
//        }
//    }
//
//    public void checkCollision() {
//        for (int i = dots; i > 0; i--) {
//            if ((i > 4) && (x[0] == x[i] && y[0] == y[i])) {
//                inGame = false;
//              
//            }
//        }
//
//        //if the snake touch the boundary of the game
//        if (y[0] >= 300) {
//            inGame = false;
//        }
//        if (x[0] >= 300) {
//            inGame = false;
//        }
//        if (y[0] < 0) {
//            inGame = false;
//        }
//        if (x[0] < 0) {
//            inGame = false;
//        }
//        if (!inGame) {
//            timer.stop();
//        }
//
//    }
//
//    public void actionPerformed(ActionEvent ae) {
//        if (inGame) {
//            checkApple();
//            checkCollision();
//            move();
//
//        }
//        repaint();
//    }
//
//    public class TAdapter extends KeyAdapter {
//
//        @Override
//        public void keyPressed(KeyEvent e) {
//            int key = e.getKeyCode();
//
//            if (key == KeyEvent.VK_LEFT && (!rightDirection)) { //right direction and left me se koi se bhe
//                // ek ture h to doosre ektum true na ho bss..
//                leftDirection = true;
//                upDirection = false;
//                downDirection = false;
//            }
//            if (key == KeyEvent.VK_RIGHT && (!leftDirection)) {
//                rightDirection = true;
//                upDirection = false;
//                downDirection = false;
//            }
//            if (key == KeyEvent.VK_DOWN && (!upDirection)) {
//                leftDirection = false;
//                rightDirection = false;
//                downDirection = true;
//            }
//            if (key == KeyEvent.VK_UP && (!downDirection)) {
//                leftDirection = false;
//                upDirection = true;
//                rightDirection = false;
//            }
//        }
//    }
//}
//






package snakegame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Board extends JPanel implements ActionListener {
    
    private Image apple;
    private Image dot;
    private Image head;
    
    private final int ALL_DOTS = 900;
    private final int DOT_SIZE = 10;
    private final int RANDOM_POSITION = 29;
    
    private int apple_x;
    private int apple_y;
    
    private final int x[] = new int[ALL_DOTS];
    private final int y[] = new int[ALL_DOTS];
    
    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;
    
    private boolean inGame = true;
    
    private int dots;
    private Timer timer;
    
    Board() {
        addKeyListener(new TAdapter());
        
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(300, 300));
        setFocusable(true);
        
        loadImages();
        initGame();
    }
    
    public void loadImages() {
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("snakegame/icons/apple.png"));
        apple = i1.getImage();
        
        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("snakegame/icons/dot.png"));
        dot = i2.getImage();
        
        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("snakegame/icons/head.png"));
        head = i3.getImage();
    }
    
    public void initGame() {
        dots = 3;
        
        for (int i = 0; i < dots; i++) {
            y[i] = 50;
            x[i] = 50 - i * DOT_SIZE;
        }
        
        locateApple();
        
        timer = new Timer(140, this);
        timer.start();
    }
    
    public void locateApple() {
        int r = (int)(Math.random() * RANDOM_POSITION);
        apple_x = r * DOT_SIZE;
                
        r = (int)(Math.random() * RANDOM_POSITION);
        apple_y = r * DOT_SIZE;
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        draw(g);
    }
    
    public void draw(Graphics g) {
        if (inGame) {
            g.drawImage(apple, apple_x, apple_y, this);

            for (int i = 0 ; i < dots; i++) {
                if (i == 0) {
                    g.drawImage(head, x[i], y[i], this);
                } else {
                    g.drawImage(dot, x[i], y[i], this);
                }
            }

            Toolkit.getDefaultToolkit().sync();
        } else {
            gameOver(g);
        }
    }
    
    public void gameOver(Graphics g) {
        String msg = "Game Over!";
        Font font = new Font("SAN_SERIF", Font.BOLD, 14);
        FontMetrics metrices = getFontMetrics(font);
        
        g.setColor(Color.WHITE);
        g.setFont(font);
        g.drawString(msg, (300 - metrices.stringWidth(msg)) / 2, 300/2);
    }
    
    public void move() {
        for (int i = dots ; i > 0 ; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }
        
        if (leftDirection) {
            x[0] = x[0] - DOT_SIZE;
        }
        if (rightDirection) {
            x[0] = x[0] + DOT_SIZE;
        }
        if (upDirection) {
            y[0] = y[0] - DOT_SIZE;
        }
        if (downDirection) {
            y[0] = y[0] + DOT_SIZE;
        }
    }
    
    public void checkApple() {
        if ((x[0] == apple_x) && (y[0] == apple_y)) {
            dots++;
            locateApple();
        }
    }
    
    public void checkCollision() {
        for(int i = dots; i > 0; i--) {
            if (( i > 4) && (x[0] == x[i]) && (y[0] == y[i])) {
                inGame = false;
            }
        }
        
        if (y[0] >= 300) {
            inGame = false;
        }
        if (x[0] >= 300) {
            inGame = false;
        }
        if (y[0] < 0) {
            inGame = false;
        }
        if (x[0] < 0) {
            inGame = false;
        }
        
        if (!inGame) {
            timer.stop();
        }
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (inGame) {
            checkApple();
            checkCollision();
            move();
        }
        
        repaint();
    }
    
    public class TAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            
            if (key == KeyEvent.VK_LEFT && (!rightDirection)) {
                leftDirection = true;
                upDirection = false;
                downDirection = false;
            }
            
            if (key == KeyEvent.VK_RIGHT && (!leftDirection)) {
                rightDirection = true;
                upDirection = false;
                downDirection = false;
            }
            
            if (key == KeyEvent.VK_UP && (!downDirection)) {
                upDirection = true;
                leftDirection = false;
                rightDirection = false;
            }
            
            if (key == KeyEvent.VK_DOWN && (!upDirection)) {
                downDirection = true;
                leftDirection = false;
                rightDirection = false;
            }
        }
    }
    
}