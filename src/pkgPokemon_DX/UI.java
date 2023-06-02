/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkgPokemon_DX;

import java.awt.*;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import static java.lang.reflect.Array.get;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import object.OBJ_Key;
import javax.swing.*;
import static javax.swing.UIManager.get;

/**
 *
 * @author thior
 */
public class UI {
    BufferedImage input, bg, btn_start, btn_load, btn_exit;
    BufferedImage bg_intro, intro_choose, dialog_box,input_name;
    GamePanel gp;
    Graphics2D g2;
    Font pokemonFont;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinish = false;
    
    //dialog yg ditampilin
    public String CurrentDialogue = "";
    //input nama
    public JTextField input_nama;
    public String p_name="";
        
    public UI (GamePanel gp){
        this.gp = gp;
        
        try {
            InputStream cusFont = getClass().getResourceAsStream("/font/PKMN_RBYGSC.ttf");
            pokemonFont = Font.createFont(Font.TRUETYPE_FONT, cusFont);
        } catch (FontFormatException ex) {
            Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void showMessage (String text){
        message = text;
        messageOn = true;
    }
    public void draw (Graphics2D g2) throws FontFormatException{
        this.g2 = g2;
        g2.setFont(pokemonFont);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
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
        if (gp.gameState == gp.inputNameState) {
            drawInputNameScreen();
        }
        if (gp.gameState == gp.dialogueState) {
            drawDialogueScreen();
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
//            pokemonFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/font/PKMN_RBYGSC.ttf"));
//            pokemonFont = pokemonFont.deriveFont(Font.BOLD,18f);
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
//        nama_prof.setFont(pokemonFont);
//        
//        
//        
//        pokemonFont = pokemonFont.deriveFont(20f);
//        JLabel Desc = new JLabel("Hello there, please pick your first pokemon  ");
//        Desc.setBounds(40,posY2+75,1000,posY2-473);
//        Desc.setForeground(Color.white);
//        Desc.setFont(pokemonFont);
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
    
    public void drawInputNameScreen() throws FontFormatException{
        //pop up input_nama nama
        try{
            bg = ImageIO.read(getClass().getResourceAsStream("/story/bg_blank.png"));
            input_name = ImageIO.read(getClass().getResourceAsStream("/story/intro_input_nama.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
        g2.drawImage(bg, 0, 0, gp.screenWidth, gp.screenHeight, null);
        
        //buat draw input_nama e nde tengah
        int posX = gp.screenWidth/2 - 250;
        int posY = gp.screenHeight /2 - 250 ;
        g2.drawImage(input_name, posX, posY, 500, 500, null);
        
        input_nama = new JTextField(20);
        input_nama.setBounds(480,308,835-480,368-308);
        //buat ilangin border + bkin transparant
        input_nama.setOpaque(false);
        input_nama.setBorder(BorderFactory.createLineBorder(Color.white, 0));
        input_nama.setBackground(null);
        input_nama.setHorizontalAlignment(JTextField.CENTER);
        
        
        
        input_nama.setFont(g2.getFont().deriveFont(Font.BOLD,28f));
        
        gp.add(input_nama);
    }
    
    public void drawDialogueScreen(){
        //inisialisasi koordinat window dialognya
        int x = gp.tilesSize*2;
        int y = gp.screenHeight - gp.tilesSize*5;
        int width = gp.screenWidth - (x*2);
        int height = gp.tilesSize * 4;
        
        drawSubWindow(x, y, width, height);
        //buat nge set tulisan nya koornya mulai dr mana
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,32F));
        x += gp.tilesSize;
        y += gp.tilesSize;
        
        //buat cek apakah 1 kalimat ada /n nya? klo ada pindahin ke bwh bang
        for (String line : CurrentDialogue.split("\n")) {
            g2.drawString(line, x, y);
            y+=40;
        }
        
        
    }
    
    public void drawSubWindow(int x, int y,int width,int height){
        //set warna buat windows dialog param ke 4 opacity
        Color c = new Color(0,0,0,210);
        g2.setColor(c);
        //bkin kotak nya
        g2.fillRoundRect(x, y, width, height,35,35);
        
        c = new Color(255,255,255);
        g2.setColor(c);
        g2.drawRoundRect(x, y, width, height,25,25);
        
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
