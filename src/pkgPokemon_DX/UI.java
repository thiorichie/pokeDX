/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkgPokemon_DX;

import java.awt.*;
import java.awt.Font;
//import java.awt.FontFormatException;
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
    BufferedImage bg_intro, intro_choose, dialog_box;
    GamePanel gp;
    Graphics2D g2;
    Font arial_40, arial_80B;
    Font customFont;
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
    public void draw (Graphics2D g2) throws FontFormatException{
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
    
    public void drawStoryScreen() throws FontFormatException{
        // STORY BACKGROUND
        try{
            bg_intro = ImageIO.read(getClass().getResourceAsStream("/story/bg_intro_2.png"));
            intro_choose = ImageIO.read(getClass().getResourceAsStream("/story/intro_choose.png"));
            dialog_box = ImageIO.read(getClass().getResourceAsStream("/story/input.jpg"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
        
        // buat draw choose button di story
        g2.drawImage(bg_intro, 0, 0, gp.screenWidth, gp.screenHeight, null);
        int posX = gp.screenWidth/2 - 175;
        int posY = gp.screenHeight /4 + 150;
        
        g2.drawImage(intro_choose, 161, 190, 200, 120, null);
        int posY2 = posY + 100;
        g2.drawImage(intro_choose, 551, 190, 200, 120, null);
        posY2 += 100;
        g2.drawImage(intro_choose, 930, 190, 200, 120, null);
        
//        //draw dialog box
//        g2.drawImage(dialog_box, 20, 523, 200, posY2-473, null);
//        g2.drawImage(dialog_box, 0, posY2+50, 1100, 640-posY2, null);
//        //masukin font baru
//        
//        try{
//            customFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/font/PKMN_RBYGSC.ttf"));
//            customFont = customFont.deriveFont(Font.BOLD,18f);
//            
//        }
//        catch(IOException e){
//            e.printStackTrace();
//        }
//        
//        //settings gambar tulisan nama prof e
//        JLabel nama_prof = new JLabel("Prof. Samuel");
//        nama_prof.setBounds(35,523,200,posY2-473);
//        nama_prof.setForeground(Color.white);
//        nama_prof.setFont(customFont);
//        
//        
//        
//        customFont = customFont.deriveFont(20f);
//        JLabel Desc = new JLabel("Hello there, please pick your first pokemon  ");
//        Desc.setBounds(40,posY2+75,1000,posY2-473);
//        Desc.setForeground(Color.white);
//        Desc.setFont(customFont);
//        
//        // di add ke screen
//        gp.add(nama_prof);
//        gp.add(Desc);
//        
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
