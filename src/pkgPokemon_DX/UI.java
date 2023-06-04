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
import java.util.HashMap;

/**
 *
 * @author thior
 */
public class UI {
    HashMap<String, BufferedImage> inventory_entity = new HashMap<>();
    BufferedImage btn_inventory, inventory_gui;
    BufferedImage input, bg, btn_start, btn_load, btn_exit;
    //buat story screen
    BufferedImage bg_intro, intro_choose,input_name;
    //buat battle screen
    BufferedImage bg_battle,poke1,poke2,hp_bar;
            
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
        gp.removeAll();
        this.g2 = g2;
        g2.setFont(pokemonFont);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.setColor(Color.white);
        
        if(gp.gameState == gp.playState){
            drawGameUI();
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
        if (gp.gameState == gp.dialogueState) {
            drawDialogueScreen();
        }
        if (gp.gameState == gp.inventoryState) {
            drawInventoryScreen();
        }
        if (gp.gameState == gp.battleState) {
            drawBattleScreen();
        }
    }
    
    private void drawPokeName(int x,int y,String nama, int lvl){
        int jarak;
        g2.drawString(nama, x, y);
        jarak = x + gp.tilesSize*7;
        g2.drawString("Lvl "+lvl+"", jarak, y);
    }
    
    private void drawHpBar(int x,int y,int maxHp, int currHp){
        Color c;
        int hpLength;
        int widthBar = gp.tilesSize*9; 
        int heightBar = gp.tilesSize/2;
        if (currHp > (7 * maxHp / 10)) {
            c = Color.GREEN;
        }
        else if (currHp > (3 * maxHp /10)) {
            c = Color.YELLOW;
        }
        else{
            c = Color.RED;
        }
        //draw hp bar
        g2.drawImage(hp_bar, x, y, widthBar, heightBar, null);
        
        //draw hp color
        g2.setColor(c);
        
        //set panjang darah
        
        hpLength = currHp * widthBar / maxHp;
        //buat debug
//        System.out.println("Hp length : "+hpLength +"");
        
        //buat set biar ada jarak disisi kanan ma kirinya
        x+=5;
        y+=2;
        hpLength-=10;
        heightBar-=4;
        
        g2.fillRoundRect(x, y, hpLength, heightBar, 25, 25);
        
    }
    
    public void drawBattleScreen(){
        //input battle bg
        try{
            bg_battle = ImageIO.read(getClass().getResourceAsStream("/battle/bg_battle.png"));
            hp_bar = ImageIO.read(getClass().getResourceAsStream("/battle/hpbar.png"));
            poke1 = ImageIO.read(getClass().getResourceAsStream("/battle/pikachu.png"));
            poke2 = ImageIO.read(getClass().getResourceAsStream("/battle/arceus.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
        
        int x_name=gp.tilesSize*2;
        int y_name=gp.tilesSize*3/2;
        int width;
        int height;
        
        //gmbr battle bg
        g2.drawImage(bg_battle, 0, 0, gp.screenWidth, gp.screenHeight, null);
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,30F));
        
        //draw nama poke 1
        drawPokeName(x_name, y_name, "Pikachu", 1);
        
        //draw hp bar poke 1
        y_name+= gp.tilesSize/2;
        drawHpBar(x_name, y_name, 100, 60);
        
        //draw poke 1
        //letak posisi awal
        x_name = gp.tilesSize*19 + gp.tilesSize/2;
        y_name = gp.tilesSize*3;
        width = gp.tilesSize*5;
        height = gp.tilesSize*5;
        g2.drawImage(poke1, x_name, y_name, width, height, null);
        
        //draw poke 2
        //letak posisi awal
        x_name = gp.tilesSize*4;
        y_name = gp.screenHeight - gp.tilesSize*11;
        width = gp.tilesSize*9;
        height = gp.tilesSize*9;
        g2.drawImage(poke2, x_name, y_name, width, height, null);
        
        //draw nama poke 2
        //update letak x y
        g2.setColor(Color.WHITE);
        x_name = gp.screenWidth - gp.tilesSize*11;
        y_name = gp.screenHeight - gp.tilesSize*5;
        drawPokeName(x_name, y_name, "Arceus", 1);
        
        //draw hp bar poke 2
        y_name+= gp.tilesSize/2;
        drawHpBar(x_name, y_name, 100, 30);
        
        //inisialisasi koordinat window dialognya
        int x = gp.tilesSize*2;
        int y = gp.screenHeight - gp.tilesSize*3 - gp.tilesSize/2 ;
        width = gp.screenWidth - (x*2);
        height = gp.tilesSize * 3;
        
        drawSubWindow(x, y, width, height);
        //buat pas gambar tulisan di dialog windows
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,30F));
        x += gp.tilesSize;
        y += gp.tilesSize;
        g2.drawString("Battle has start", x, y);
    }
    
    private void removeLabel(JLabel label) {
        Timer timer = new Timer(5000, e -> {
            gp.remove(label); // Remove the label from the frame
            gp.revalidate(); // Re-validate the frame to reflect the changes
            gp.repaint(); // Repaint the frame to reflect the changes
        });
        
        timer.setRepeats(false); // Only execute once
        timer.start();
    }
    
    public void drawInventoryScreen() throws FontFormatException {
        final int x_awal = 478;
        final int y_awal = 264;
        final int x_awal_label = 515;
        final int y_awal_label = 296;
        int n_inventory = 0;
         // INVENTORY SCREEN
         try {
             inventory_gui = ImageIO.read(getClass().getResourceAsStream("/game_gui/inventory_gui.png"));
             inventory_entity.put("key", ImageIO.read(getClass().getResourceAsStream("/objects/key.png")));
         }
         
         catch(IOException e){
            e.printStackTrace();
        }
         
         g2.drawImage(inventory_gui, 420, 140, 497, 493, null);
         for(String key : gp.player.inventory.keySet()) {
             if(gp.player.inventory.get(key) > 0) g2.drawImage(inventory_entity.get(key), x_awal, y_awal, 48, 48, null);
                JLabel label = new JLabel(gp.player.inventory.get(key).toString() + "X");
                label.setBounds(x_awal_label, y_awal_label, 200, 30);
                label.setForeground(Color.white);
                gp.add(label);
                n_inventory++;
         }
     }
    
    public void drawGameUI() throws FontFormatException {
         // GAME UI
         try {
             btn_inventory = ImageIO.read(getClass().getResourceAsStream("/button/inventory.png"));
         }
         
         catch(IOException e){
            e.printStackTrace();
        }
         
         g2.drawImage(btn_inventory, 15, 15, 87, 80, null);
     }
    
    public void drawStoryScreen() throws FontFormatException{
        // STORY BACKGROUND
        try{
            bg_intro = ImageIO.read(getClass().getResourceAsStream("/story/bg_intro_2.png"));
            intro_choose = ImageIO.read(getClass().getResourceAsStream("/story/intro_choose.png"));
            
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
