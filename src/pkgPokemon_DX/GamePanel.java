/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkgPokemon_DX;

import entity.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import object.SuperObject;
import tile.TileManager;

/**
 *
 * @author thior
 */
public class GamePanel extends JPanel implements Runnable{
    
    //Screen settings
    final int originalTileSize = 16; // 16x16 tiles
    final int scale = 3;
    
    public final int tilesSize = originalTileSize * scale;
    public final int maxScreenCol = 27;
    public final int maxScreenRow = 15;
    public final int screenWidth = tilesSize * maxScreenCol; // 768px
    public final int screenHeight = tilesSize * maxScreenRow; // 576px
    
    //WORLD SETTING
    public final int maksWorldCol = 30;
    public final int maksWorldRow = 100;
    public final int maksMap = 10;
    public int currentMap = 0;
    
    //FPS
    int FPS = 60;
     
    //SYSTEM
    TileManager tileManager = new TileManager(this);
    KeyHandler keyH = new KeyHandler(this);
    MouseHandler mouseH = new MouseHandler(this);
    Sound music = new Sound();
    Sound se = new Sound();
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public UI ui = new UI (this);
    public EventHandler eHandler = new EventHandler(this);
    Thread gameThread;
    
    //ENTITY AND OBJECT
    public Player player = new Player(this, keyH);
    public SuperObject obj[][] = new SuperObject[maksMap][10]; 
    public SuperObject currentNPC;
    
    //GAME STATE
    public int gameState;
    public final int titleState = 0;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int storyState = 3;
    public final int dialogueState = 4;
    public final int inventoryState = 5;
    public final int battleState = 6;
    
    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.addMouseListener(mouseH);
        this.setFocusable(true);
    }
    
    public void setupGame(){
        aSetter.setObject();
//        playMusic (5);
        gameState = titleState;
    }
    
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    public void run(){
        
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;
        
        while(gameThread != null){
            
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            
            if (delta >= 1){
                update();
                repaint();
                delta--;
                drawCount++;
            }
        }
    }
    
    public void update(){
        if(gameState == playState){
            player.update();
        }
        if(gameState == pauseState){
            //NOT YET
        }
    }
    
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        
        //DEBUG
        long drawStart = 0;
        if (keyH.checkDrawTime == true){
            
            drawStart = System.nanoTime();
        }
        
        //TITLE SCREEN
        if(gameState == titleState){
            try {
                ui.draw(g2);
            } catch (FontFormatException ex) {
                Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            //Tile Draw
            tileManager.draw(g2);
            //Object Draw
            for(int i = 0; i < obj.length; i++){
                if (obj[currentMap][i] != null){
                    obj[currentMap][i].draw(g2, this);
                }
            }
            //Player Draw
            player.draw(g2);
            try {
                //UI Draw
                ui.draw(g2);
            } catch (FontFormatException ex) {
                Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //DEBUG
//        if (keyH.checkDrawTime == true){
//            long drawEnd = System.nanoTime();
//            long passed = drawEnd - drawStart;
//            g2.setColor(Color.white);
//            g2.drawString("Draw Time: " + passed, 10, 400);
//            System.out.println("Draw Time: " + passed);
//        }
//        long drawEnd = System.nanoTime();
//        long passed = drawEnd - drawStart;
//        g2.setColor(Color.white);
//        g2.drawString("Draw Time: " + passed, 10, 400);
//        System.out.println("Draw Time: " + passed);
//        
//        g2.dispose();
    }
    
    public void playMusic (int i){
//        music.setFile(i);
//        music.play();
//        music.loop();
    }
    
    public void stopMusic (){
//        music.stop();
    }
    
    public void playSE (int i){
        se.setFile(i);
        se.play();
    }
}


//    public void run(){
//        
//        double drawInterval = Math.pow(10, 9) / FPS; //1 bil nanosecs = 1 sec;
//        double nextDrawTime = System.nanoTime() + drawInterval;
//        while (gameThread != null){
//            
//            update();
//            
//            repaint();
//            
//            try {
//                double remainingTime = nextDrawTime - System.nanoTime();
//                remainingTime /= 1000000;
//                
//                if (remainingTime < 0){
//                    remainingTime = 0;
//                }
//                
//                Thread.sleep((long)remainingTime);
//                
//                nextDrawTime += drawInterval;
//            }
//            catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            
//            
//            
//            //todo
//            //1. Update information such as character's position
//            //2. Draw the screen with the updated information
//        }
//    }



//            if (timer >= 1000000000){
//                System.out.println("FPS : " + drawCount);
//                drawCount = 0;
//                timer = 0;
//            }