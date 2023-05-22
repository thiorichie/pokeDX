/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokemon1.pkg0;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
/**
 *
 * @author thior
 */
public class GamePanel extends JPanel implements Runnable{
    //screen setting
    final int oriTileSize = 16; // 16 x 16px tiles
    final int scale = 3;
    
    //fps
    int fps = 60;
    
    //tile setting
    public final int tileSize = oriTileSize * scale; //48px
    public final int maxScreenCol = 27;
    public final int maxScreenRow = 15;
    public final int screenWidth = tileSize * maxScreenCol; //768px
    public final int screenHeight = tileSize * maxScreenRow; //576px
    
    //system
    public UI ui = new UI (this);
    KeyHandler keyHandler = new KeyHandler();
    Thread gameThread;
    
    //game state
    public int gameState;
    public final int titleState = 0;
    public final int playState = 1;
    public final int pauseState = 2;
    
    //set player's default position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 3;
    
    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    public void setupGame(){
        gameState = titleState;
    }
    
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    @Override
    public void run() {
        
        double drawInterval = 1000000000/fps; //0.01666 SECONDS
        double nextDrawTime = System.nanoTime() + drawInterval;
        
        while(gameThread != null){
            //UPDATE(INFORMATION ABOUT THE GAME) & RUN(OUTPUT ALL THE UPDATED INFORMATION)
            long currentTime = System.nanoTime();
            
            //UPDATE
            update();
            //RUN
            repaint();
            
            try{
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime /= 1000000;
                if(remainingTime < 0){
                    remainingTime = 0;
                }
                Thread.sleep((long) remainingTime);
                nextDrawTime += drawInterval;
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    
    public void update(){
//        if(keyHandler.upPressed){
//            playerY -= playerSpeed;
//        }
//        if(keyHandler.downPressed){
//            playerY += playerSpeed;
//        }
//        if(keyHandler.leftPressed){
//            playerX -= playerSpeed;
//        }
//        if(keyHandler.rightPressed){
//            playerX += playerSpeed;
//        }
        if(gameState == playState){
            
        }
        if(gameState == pauseState){
            
        }
    }
    
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        
        //title screen
        if(gameState == titleState){
            ui.draw(g2);
        }
        else{
            //tile draw
            
            //object draw
            
            //player draw
            
            //ui draw
        }
    }
}
