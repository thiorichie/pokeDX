/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokemon1.pkg0;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;

/**
 *
 * @author thior
 */
public class UI {
    BufferedImage bg, bg2;
    GamePanel gp;
    Graphics2D g2;
    
    public UI(GamePanel gp){
        this.gp = gp;
    }
    
    public void draw (Graphics2D g2){
        this.g2 = g2;
        if(gp.gameState == gp.playState){
            
        }
        if(gp.gameState == gp.pauseState){
            
        }
        if(gp.gameState == gp.titleState){
            drawTitleScreen();
        }
    }
    
    public void drawTitleScreen(){
        //TITLE BG
        try{
            bg = ImageIO.read(getClass().getResourceAsStream("/assets/background/Main_Menu.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
        g2.drawImage(bg, 0, 0, gp.screenWidth, gp.screenHeight, null);
    }
    
    
}
