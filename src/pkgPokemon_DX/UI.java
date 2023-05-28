/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkgPokemon_DX;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.DecimalFormat;
import javax.imageio.ImageIO;
import object.OBJ_Key;
import javax.swing.*;

/**
 *
 * @author thior
 */
public class UI {
    BufferedImage input, bg, btn_start, btn_load, btn_exit;
    BufferedImage bg_intro, intro_choose;
    GamePanel gp;
    Graphics2D g2;
    Font arial_40, arial_80B;
//    BufferedImage keyImage;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinish = false;
    double playTime;
    DecimalFormat dFormat = new DecimalFormat("#0.00");
    
    public UI (GamePanel gp){
        this.gp = gp;
        arial_40 = new Font("Arial", Font.PLAIN, 40);
        arial_80B = new Font("Arial", Font.BOLD, 80);
//        OBJ_Key key = new OBJ_Key();
//        keyImage = key.image;
    }
    
    public void showMessage (String text){
        message = text;
        messageOn = true;
    }
    public void draw (Graphics2D g2){
        this.g2 = g2;
        g2.setFont(arial_40);
        g2.setColor(Color.white);
        
        if(gp.gameState == gp.playState){
            
        }
        if(gp.gameState == gp.pauseState){
            drawPauseScreen();
        }
        if(gp.gameState == gp.titleState){
            drawTitleScreen();
        }
        if (gp.gameState == gp.storyState) {
            drawStoryScreen();
        }
    }
    
    public void drawStoryScreen(){
        // STORY BACKGROUND
        try{
            bg_intro = ImageIO.read(getClass().getResourceAsStream("/story/bg_intro.png"));
            intro_choose = ImageIO.read(getClass().getResourceAsStream("/story/intro_choose.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
        g2.drawImage(bg_intro, 0, 0, gp.screenWidth, gp.screenHeight, null);
        int posX = gp.screenWidth/2 - 175;
        int posY = gp.screenHeight /4 + 150;
        g2.drawImage(input, posX, posY, 300, 95, null);
        g2.drawImage(intro_choose, 161, 190, 200, 120, null);
        int posY2 = posY + 100;
        g2.drawImage(intro_choose, 551, 190, 200, 120, null);
        posY2 += 100;
        g2.drawImage(intro_choose, 930, 190, 200, 120, null);
    }
    
    public void drawTitleScreen(){
        //TITLE BACKGROUND
        try{
            bg = ImageIO.read(getClass().getResourceAsStream("/bground/Main_Menu.png"));
            btn_start = ImageIO.read(getClass().getResourceAsStream("/button/start.png"));
            btn_load = ImageIO.read(getClass().getResourceAsStream("/button/load.png"));
            btn_exit = ImageIO.read(getClass().getResourceAsStream("/button/exit.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
        g2.drawImage(bg, 0, 0, gp.screenWidth, gp.screenHeight, null);
        int posX = gp.screenWidth/2 - 175;
        int posY = gp.screenHeight /4 + 150;
        g2.drawImage(btn_start, posX, posY, 300, 95, null);
        int posY2 = posY + 100;
        g2.drawImage(btn_load, posX, posY2, 300, 95, null);
        posY2 += 100;
        g2.drawImage(btn_exit, posX, posY2, 300, 95, null);
    }
    
    public void drawPauseScreen(){
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,80F));
        String text = "PAUSED";
        int x = getXforCenteredText(text);
        int y = gp.screenHeight/2;
        
        g2.drawString(text, x, y);
    }
    
    public int getXforCenteredText(String text){
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth/2 - length/2;
        return x;
    }
}
