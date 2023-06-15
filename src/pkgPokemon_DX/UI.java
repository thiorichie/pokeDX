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
import java.util.Random;
import poke.Monster;
import poke.Pokemon;

/**
 *
 * @author thior
 */
public class UI {
    HashMap<String, BufferedImage> inventory_entity = new HashMap<>();
    BufferedImage btn_inventory, inventory_gui;
    BufferedImage input, bg, btn_start, btn_load, btn_exit;
    
    //buat cursor
    public int commandNum = 0;
    
    //buat story screen
    BufferedImage bg_intro, intro_choose,input_name;
    //buat battle screen
    BufferedImage bg_battle,hp_bar;
            
    GamePanel gp;
    Graphics2D g2;
    Font pokemonFont,PurisaBold;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinish = false;
    public boolean isTrainerBattle = false;
    public boolean isBossBattle = false;
    
    //dialog yg ditampilin
    public String CurrentDialogue = "";
    //input nama
    public JTextField input_nama;
    public String p_name="";
    
    //class pokemon
    public Pokemon pokemon = new Pokemon();
    public Monster poke1,poke2;
    Random rand = new Random();
    public boolean TextPopup = false;
    public boolean isBattleOver = false;
    public boolean lvlUp = false;
    public boolean flee = false;
    public boolean catchPokemon = false;
    
    //menu state
    public int menu_state = 0;
    //menu state 1 atk
    //menu state 2 backpack
    //menu state 3 party
    //menu state 4 run
    //menu state 99 clear box
    
        
    public UI (GamePanel gp){
        this.gp = gp;
        
        try {
            InputStream cusFont = getClass().getResourceAsStream("/font/PKMN_RBYGSC.ttf");
            pokemonFont = Font.createFont(Font.TRUETYPE_FONT, cusFont);
            cusFont = getClass().getResourceAsStream("/font/Purisa_Bold.ttf");
            PurisaBold = Font.createFont(Font.TRUETYPE_FONT, cusFont);
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
    
//    public void setMessage(String text){
//        message = text;
//    }
    
    public void draw (Graphics2D g2) throws FontFormatException {
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
        if (gp.gameState == gp.backpackState) {
            drawBackpackScreen();
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
    
    public void drawCursor(int x, int y){
//        g2.setFont(PurisaBold);
//        g2.setFont(PurisaBold.deriveFont(Font.PLAIN,26F));
        g2.drawString(">", x, y);
//        g2.setFont(pokemonFont);
    }
    
    public void enemy_action(){
        int index_skill = rand.nextInt(0,poke1.skill.size());
        int heal = poke1.skill.get(index_skill).getHeal();
        int atk = poke1.skill.get(index_skill).getDmg();
        
        if (heal == 0  && poke2.getHp() > 0) {
            poke2.setHp(poke2.getHp()-atk);
            if (poke2.getHp() <= 0) {
                poke2.setHp(0);
            }
            message = poke2.getNama() + " received "+ atk + " dmg!";
        }
        else if (heal > 0 && poke1.getHp() > 0) {
            poke1.setHp(poke1.getHp()+heal);
            message = poke1.getNama() + " heals "+ heal + " hp!";
        }
        TextPopup = true;
    }
    
    public void action(int atk, int heal, Monster p, Monster e){
        if (heal == 0  && e.getHp() > 0) {
            e.setHp(e.getHp()-atk);
            if (e.getHp() <= 0) {
                e.setHp(0);
            }
            message = e.getNama() + " received "+ atk + " dmg!";
        }
        else if (heal > 0 && p.getHp() > 0) {
            p.setHp(p.getHp()+heal);
            message = p.getNama() + " heals "+ heal + " hp!";
        }
    }
    
    public void clearText(int x,int y){
        g2.drawString("", x, y);
    }
    
    private void drawMainMenuBattle(int x, int y,int xtext,int ytext){
        
        //buat clear pesan / message
//        if (menu_state != 99) {
//            clearText(xtext, ytext);
//            clearText(xtext, ytext+ gp.tilesSize + gp.tilesSize / 4);
//        }
        
        // teks atk
        x += gp.tilesSize*3 + gp.tilesSize/2;
        y += gp.tilesSize + gp.tilesSize/8;
        
//        System.out.println(poke2.skill.get(0).getNama());
        try {
            if (menu_state == 0) {
                g2.drawString("Attack", x, y);
            } 
            if (menu_state == 1) {
                g2.drawString(poke2.skill.get(0).getNama(), x, y);
            }
            if (menu_state == 2) {
                g2.drawString("Poke ball", x, y);
            }
            if (menu_state == 21) {
                g2.drawString("Red poke ball", x, y);
            }
            if (menu_state == 22) {
                g2.drawString("Colbur berry", x, y);
            }
            if (menu_state == 23) {
                g2.drawString("Potion", x, y);
            }
             if (menu_state == 3) {
                 String pokemonName = gp.player.party.get(0).getNama();
                 if(gp.player.partyIndex == 0) pokemonName += " [Used]";
                g2.drawString(pokemonName, x, y);
            }
            if (menu_state == 99) {
//                clearText(x, y);
            } 

            if (commandNum == 0 && menu_state != 99) {
                x -= gp.tilesSize;
                drawCursor(x, y);
                //balikin ke posisi semula teks
                x += gp.tilesSize;

            }
        } catch (Exception e) {
            
        }
        
        
        //teks backpack
        y += gp.tilesSize + gp.tilesSize/16;
        
        try {
            if (menu_state == 0) {
                g2.drawString("Backpack", x, y);
            }
            else if (menu_state == 1) {
                g2.drawString(poke2.skill.get(1).getNama(), x, y);
            }
            if (menu_state == 2) {
                g2.drawString("Berries", x, y);
            }
            if (menu_state == 21) {
                g2.drawString("Great ball", x, y);
            }
            if (menu_state == 22) {
                g2.drawString("Chilan berry", x, y);
            }
            if (menu_state == 23) {
                g2.drawString("Super potion", x, y);
            }
            if (menu_state == 3) {
                String pokemonName = gp.player.party.get(1).getNama();
                 if(gp.player.partyIndex == 1) pokemonName += " [Used]";
                g2.drawString(pokemonName, x, y);
            }
            if (menu_state == 99) {
//                clearText(x, y);
            } 
            
            if (commandNum == 1 && menu_state != 99) {
                x -= gp.tilesSize;
                drawCursor(x, y);
                //balikin ke posisi semula teks
                x += gp.tilesSize;
            }
        } catch (Exception e) {
        }
        
        
        //teks party
        //reset balik atas
        y-= gp.tilesSize;
        x = gp.screenWidth - gp.tilesSize*10 + gp.tilesSize/2;
        
        try {
            if (menu_state == 0) {
                g2.drawString("Party", x, y);
            }
            else if (menu_state == 1) {
                g2.drawString(poke2.skill.get(2).getNama(), x, y);
            }
            if (menu_state == 2) {
                g2.drawString("Potion", x, y);
            }
            if (menu_state == 21) {
                g2.drawString("Ultra ball", x, y);
            }
            if (menu_state == 22) {
                g2.drawString("Rowap berry", x, y);
            }
            if (menu_state == 23) {
                g2.drawString("Hyper potion", x, y);
            }
            if (menu_state == 3) {
                String pokemonName = gp.player.party.get(2).getNama();
                if(gp.player.partyIndex == 2) pokemonName += " [Used]";
                g2.drawString(pokemonName, x, y);
            }
            if (menu_state == 99) {
//                clearText(x, y);
            } 
            
            if (commandNum == 2 && menu_state != 99) {
                x -= gp.tilesSize;
                drawCursor(x, y);
                //balikin ke posisi semula teks
                x += gp.tilesSize;
            }
        } catch (Exception e) {
        }
        
        
        //teks run
        y += gp.tilesSize + gp.tilesSize/16;
        
        try {
            if (menu_state == 0) {
                g2.drawString("Run", x, y);
            }
            else if (menu_state == 1) {
                g2.drawString(poke2.skill.get(3).getNama(), x, y);
            }
            if (menu_state == 3) {
                String pokemonName = gp.player.party.get(3).getNama();
                if(gp.player.partyIndex == 3) pokemonName += " [Used]";
                g2.drawString(pokemonName, x, y);
            }
            if (menu_state == 99) {
//                clearText(x, y);
            } 
            
            if (commandNum == 3 && menu_state != 99) {
                x -= gp.tilesSize;
                drawCursor(x, y);
                //balikin ke posisi semula teks
                x += gp.tilesSize;
            }
        } catch (Exception e) {
        }
        
        //tampilin message
        if (menu_state == 99) {
            int temp_ytext = ytext;
            for (String line : message.split("\n")) {
                g2.drawString(line, xtext, ytext);
                ytext += gp.tilesSize + gp.tilesSize / 4;
            }
            ytext = temp_ytext;
        }
    }
    
    public boolean cekPartyAlive(){
        boolean status = false;
        for (Monster party : gp.player.party) {
            if (party.getStatus()) {
               status = true; 
            }
        }
        return status;
    }
    
    public void drawBackpackScreen() {
        try{
            bg_battle = ImageIO.read(getClass().getResourceAsStream("/battle/bg_battle.png"));
            hp_bar = ImageIO.read(getClass().getResourceAsStream("/battle/hpbar.png"));
//            poke1 = ImageIO.read(getClass().getResourceAsStream("/battle/pikachu.png"));
            poke1 = pokemon.Axew;
            poke2 = pokemon.Charmander;
        }
        catch(IOException e){
            e.printStackTrace();
        }
        
        g2.drawImage(bg_battle, 0, 0, gp.screenWidth, gp.screenHeight, null);
    }
    
    public void drawBattleScreen(){
        //input battle bg
        try{
            bg_battle = ImageIO.read(getClass().getResourceAsStream("/battle/bg_battle.png"));
            hp_bar = ImageIO.read(getClass().getResourceAsStream("/battle/hpbar.png"));
//            poke1 = pokemon.Axew;
            poke2 = gp.player.party.get(gp.player.partyIndex);
        }
        catch(IOException e){
            e.printStackTrace();
        }
        
//        System.out.println("player party index : " + gp.player.partyIndex);
        
        // buat tampilin msg klo ada pokemon kita yg lvl up
        if (lvlUp && menu_state!=99) {
            poke2.levelUp();
            message = poke2.getNama() + " level up!,\n"+ poke2.getNama() + " is now lvl "+ poke2.getLvl() + ".";
            isBattleOver = true;
            menu_state = 99;
            TextPopup = true;
            //reset
            lvlUp = false;
        }
        
        if (flee && menu_state != 99) {
            //buat cek lg battle ama sapa klo selain wild pokemon ga isa lari
            if (isTrainerBattle == false && isBossBattle == false) {
                message = "Player got away safely!";
            }
            else {
                message = "You cannot run from this battle!";
                flee = false;
                TextPopup = true;
            }
            menu_state = 99;
        }
        
        int x_name=gp.tilesSize*2;
        int y_name=gp.tilesSize*3/2;
        int width;
        int height;
        
        //gmbr battle bg
        g2.drawImage(bg_battle, 0, 0, gp.screenWidth, gp.screenHeight, null);
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,30F));
        
        //draw nama poke 1
        drawPokeName(x_name, y_name, poke1.getNama(), poke1.getLvl());
        
        //draw hp bar poke 1
        y_name+= gp.tilesSize/2;
        drawHpBar(x_name, y_name, poke1.getMax_hp(), poke1.getHp());
        
        //draw poke 1
        //letak posisi awal
        x_name = gp.tilesSize*19 + gp.tilesSize/2;
        y_name = gp.tilesSize*3;
        width = gp.tilesSize*5;
        height = gp.tilesSize*5;
        g2.drawImage(poke1.getCharacter(), x_name, y_name, width, height, null);
        
        //draw poke 2
        //letak posisi awal
        x_name = gp.tilesSize*4;
        y_name = gp.screenHeight - gp.tilesSize*11;
        width = gp.tilesSize*9;
        height = gp.tilesSize*9;
        g2.drawImage(poke2.getCharacter(), x_name, y_name, width, height, null);
        
        //draw nama poke 2
        //update letak x y
        g2.setColor(Color.WHITE);
        x_name = gp.screenWidth - gp.tilesSize*11;
        y_name = gp.screenHeight - gp.tilesSize*5;
        drawPokeName(x_name, y_name, poke2.getNama(), poke2.getLvl());
        
        //draw hp bar poke 2
        y_name+= gp.tilesSize/2;
        drawHpBar(x_name, y_name, poke2.getMax_hp(), poke2.getHp());
        
        //inisialisasi koordinat window dialognya
        int x = gp.tilesSize*2;
        int y = gp.screenHeight - gp.tilesSize*3 - gp.tilesSize/2 ;
        width = gp.screenWidth - (x*2);
        height = gp.tilesSize * 3;
        
        drawSubWindow(x, y, width, height);
        //buat pas gambar tulisan di dialog windows
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,32F));
        
        
        drawMainMenuBattle(x, y, x+gp.tilesSize,y+gp.tilesSize);
        
        //taruh nde bwh draw main menu battle ini biar tulisannya ke clear
        // klo battle state udh selesai
        if (isBattleOver && menu_state!=99) {
            poke1.revive(poke1.getMax_hp());
            if (cekPartyAlive() == false) {
                gp.eHandler.teleport(4, 14, 19);
                for (Monster party : gp.player.party) {
                    party.revive(party.getMax_hp());
                }
                //reset index
                gp.player.partyIndex = 0;
            }
            gp.gameState = gp.playState;
            //debug
            System.out.println(poke2);
            
            //reset 
            isBattleOver =false;
            
        }
        
        if (poke1.getHp() <= 0 && isBattleOver == false) {
            message = "You recieved " + poke1.getMax_hp()/5 + " coin and " + poke1.getLvl()*5 +" exp.";
            gp.player.coin += poke1.getMax_hp()/5;
            if (poke2.getCurr_exp() + poke1.getLvl()*5 >= poke2.getMax_exp()) {
                lvlUp = true;
            }
            else{
                poke2.setCurr_exp(poke2.getCurr_exp()+poke1.getLvl()*5);
                isBattleOver = true;
            }
            
            if (isTrainerBattle) {
                message += "\n and also a key!";
                //tmbh key lek dr 0
                if (gp.player.inventory.containsKey("key")) {
                    gp.player.inventory.put("key", gp.player.inventory.get("key") + 1);
                } else {
                    gp.player.inventory.put("key", 1);
                }
                //reset
                isTrainerBattle =false;
            }
            
            //biar dialog tampil
            menu_state = 99;
            TextPopup = true;
        }
        else if (poke2.getHp() <= 0) {
            if (cekPartyAlive() == false) {
                message = "Your pokemon fainted! \nYou have no other pokemon left!";
                isBattleOver = true;
                menu_state = 99;
                TextPopup = true;
            }
            else{
                message = poke2.getNama() +" has fainted!";
                if (gp.player.partyIndex < gp.player.party.size()-1) {
                    gp.player.partyIndex++;
                }
                else{
                    gp.player.partyIndex=0;
                }
                poke2 = gp.player.party.get(gp.player.partyIndex);
                //tampilin msg
                menu_state = 99;
                TextPopup = true;
            }
            
        }
        
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
             inventory_entity.put("boots", ImageIO.read(getClass().getResourceAsStream("/objects/boots.png")));
             inventory_entity.put("red_poke_ball", ImageIO.read(getClass().getResourceAsStream("/objects/red_ball.png")));
             inventory_entity.put("great_ball", ImageIO.read(getClass().getResourceAsStream("/objects/great_ball.png")));
             inventory_entity.put("ultra_ball", ImageIO.read(getClass().getResourceAsStream("/objects/ultra_ball.png")));
             inventory_entity.put("potion", ImageIO.read(getClass().getResourceAsStream("/objects/potion.png")));
         }
         
         catch(IOException e){
            e.printStackTrace();
        }
         
         g2.drawImage(inventory_gui, 420, 140, 497, 493, null);
         for(String key : gp.player.inventory.keySet()) {
             if(gp.player.inventory.get(key) > 0) {
                g2.drawImage(inventory_entity.get(key), x_awal + 85 * (n_inventory % 5), y_awal + 85 * (n_inventory / 5), 48, 48, null);
                JLabel label = new JLabel(gp.player.inventory.get(key).toString() + "X");
                label.setBounds(x_awal_label + 85 * (n_inventory % 5), y_awal_label + 85 * (n_inventory / 5), 200, 30);
                label.setForeground(Color.white);
                gp.add(label);
                n_inventory++;
             }
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
        y += gp.tilesSize + gp.tilesSize/2;
        
        //buat cek apakah 1 kalimat ada /n nya? klo ada pindahin ke bwh bang
        for (String line : CurrentDialogue.split("\n")) {
            g2.drawString(line, x, y);
            y+=gp.tilesSize + gp.tilesSize/4;
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
    
    public int getXforAlignToRightText(String text, int tailX){
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = tailX - length;
        return x;
    }
}
