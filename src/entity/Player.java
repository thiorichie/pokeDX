/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import pkgPokemon_DX.GamePanel;
import pkgPokemon_DX.KeyHandler;
import java.util.HashMap;
import java.util.Random;
import poke.Monster;

/**
 *
 * @author thior
 */
public class Player extends Entity{
    
    GamePanel gp;
    KeyHandler keyH;
    
    public final int screenX;
    public final int screenY;
    
    //inventory
    public  HashMap<String, Integer> inventory = new HashMap<>();
    public Integer coin;
    public Integer partyIndex = 0;
    public ArrayList<Monster> party = new ArrayList<>();
    
    public Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;
        
        coin = 200;
        screenX = gp.screenWidth / 2 - (gp.tilesSize / 2);
        screenY = gp.screenHeight / 2 - (gp.tilesSize / 2);
        
        solidArea = new Rectangle(8, 16, 31, 31);
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        
//        this.inventory.put("red_poke_ball", 1);
//        this.inventory.put("great_ball", 1);
        this.inventory.put("ultra_ball", 2);
//        this.inventory.put("potion", 1);
        
        setDefaultValues();
        getPlayerImage();
    }
    
    public void setDefaultValues(){
        
        worldX = gp.tilesSize * 14;
        worldY = gp.tilesSize * 19;
        speed = 10;
        direction = "right";
    }
    
    public void getPlayerImage(){
        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/Ethan9.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/Ethan8.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/Ethan3.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/Ethan2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/Ethan4.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/Ethan5.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/Ethan10.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/Ethan11.png"));
            bg = ImageIO.read(getClass().getResourceAsStream("/bground/bg1.jpg"));
            
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void update(){
        
        if (keyH.upPressed == true || keyH.downPressed == true || 
                keyH.leftPressed == true || keyH.rightPressed == true){
            if (keyH.upPressed == true){
                direction = "up";
            }
            else if (keyH.downPressed == true){
                direction = "down";
            }
            else if (keyH.leftPressed == true){
                direction = "left";
            }
            else if (keyH.rightPressed == true){
                direction = "right";
            }
            
            //Check tile collision
            collisionOn = false;
            gp.cChecker.checkTile(this);
            
            //Check object collision
            int objIndex = gp.cChecker.checkObject(this, true);
            pickUpObj(objIndex);
            
            //Check event
            gp.eHandler.checkEvent();
            
            //If coll = false, then player can move
            if (collisionOn == false){
                switch(direction){
                    case "up":      worldY -= speed;
                        break;
                    case "down":    worldY += speed;
                        break;
                    case "left":    worldX -= speed;
                        break;
                    case "right":   worldX += speed;
                        break;
                }
            }

            spriteCounter++;
            if (spriteCounter > 10){
                if (spriteNum == 1){
                    spriteNum = 2;
                }
                else if (spriteNum == 2){
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
        
    }
    
    public void pickUpObj (int i){
        if (i != 999){
            
            String objectName = gp.obj[gp.currentMap][i].name;
            
            switch(objectName){
                case "Boots":
                    gp.playSE(2);
                    speed+= 1;
                    gp.obj[gp.currentMap][i] = null;
                    System.out.println("Boots : " + inventory.get("boots"));
                    if(inventory.containsKey("boots")) {
                        inventory.put("boots", inventory.get("boots") + 1);
                    } else {
                        inventory.put("boots", 1);
                    }
                    break;
                case "Key":
                    gp.playSE(1);
                    gp.obj[gp.currentMap][i] = null;
                    System.out.println("Key : " + inventory.get("key"));
                    if(inventory.containsKey("key")) {
                        inventory.put("key", inventory.get("key") + 1);
                    } else {
                        inventory.put("key", 1);
                    }
                    break;
                case "Door":
                    if (inventory.containsKey("key") ) {
                        gp.obj[gp.currentMap][i] = null;
                        if(inventory.get("key") - 1 >= 0) {
                            inventory.put("key", inventory.get("key") - 1);
                            gp.playSE(3);
                        } else {
                            inventory.remove("key");
                            gp.playSE(3);
                        }
                    }
                    System.out.println("Key : " + inventory.get("key"));
                    break;
                case "Key2":
                    gp.playSE(1);
                    gp.obj[gp.currentMap][i] = null;
                    System.out.println("Key2 : " + inventory.get("key2"));
                    if(inventory.containsKey("key2")) {
                        inventory.put("key2", inventory.get("key2") + 1);
                    } else {
                        inventory.put("key2", 1);
                    }
                    break;
                case "Key3":
                    gp.playSE(1);
                    gp.obj[gp.currentMap][i] = null;
                    System.out.println("Key3 : " + inventory.get("key3"));
                    if(inventory.containsKey("key3")) {
                        inventory.put("key3", inventory.get("key3") + 1);
                    } else {
                        inventory.put("key3", 1);
                    }
                    break;
                case "Door3":
                    if (inventory.containsKey("key3") ) {
                        gp.obj[gp.currentMap][i] = null;
                        if(inventory.get("key3") - 1 >= 0) {
                            inventory.put("key3", inventory.get("key3") - 1);
                            gp.playSE(3);
                        } else {
                            inventory.remove("key3");
                            gp.playSE(3);
                        }
                    }
                    System.out.println("Key2 : " + inventory.get("key2"));
                    break;
                case "Door2":
                    if (inventory.containsKey("key2") ) {
                        gp.obj[gp.currentMap][i] = null;
                        if(inventory.get("key2") - 1 >= 0) {
                            inventory.put("key2", inventory.get("key2") - 1);
                            gp.playSE(3);
                        } else {
                            inventory.remove("key2");
                            gp.playSE(3);
                        }
                    }
                    System.out.println("Key2 : " + inventory.get("key2"));
                    break;
                case "chest":
                    gp.playSE(3);
                    gp.obj[gp.currentMap][i] = null;
                    Random rand = new Random();
                    int random_item = rand.nextInt(1,10);
                    if (random_item <= 3) {
                        int random_rarity = rand.nextInt(1,11);
                        if (random_rarity <= 7) {
                            if (inventory.containsKey("red_poke_ball")) {
                                inventory.put("red_poke_ball", inventory.get("red_poke_ball") + 1);
                            } else {
                                inventory.put("red_poke_ball", 1);
                            }
                        }else if (random_rarity <= 9) {
                            if (inventory.containsKey("great_ball")) {
                                inventory.put("great_ball", inventory.get("great_ball") + 1);
                            } else {
                                inventory.put("great_ball", 1);
                            }
                        } else if (random_rarity == 10) {
                            if (inventory.containsKey("ultra_ball")) {
                                inventory.put("ultra_ball", inventory.get("ultra_ball") + 1);
                            } else {
                                inventory.put("ultra_ball", 1);
                            }
                        }
                    }else if (random_item <= 6) {
                        int random_rarity = rand.nextInt(1,11);
                        if (random_rarity <= 7) {
                            if (inventory.containsKey("potion")) {
                                inventory.put("potion", inventory.get("potion") + 1);
                            } else {
                                inventory.put("potion", 1);
                            }
                        }else if (random_rarity <= 9) {
                            if (inventory.containsKey("super_potion")) {
                                inventory.put("super_potion", inventory.get("super_potion") + 1);
                            } else {
                                inventory.put("super_potion", 1);
                            }
                        } else if (random_rarity == 10) {
                            if (inventory.containsKey("hyper_potion")) {
                                inventory.put("hyper_potion", inventory.get("hyper_potion") + 1);
                            } else {
                                inventory.put("hyper_potion", 1);
                            }
                        }
                    }else if (random_item <= 9) {
                        int random_rarity = rand.nextInt(1,11);
                        if (random_rarity <= 7) {
                            if (inventory.containsKey("colbur_berry")) {
                                inventory.put("colbur_berry", inventory.get("colbur_berry") + 1);
                            } else {
                                inventory.put("colbur_berry", 1);
                            }
                        }else if (random_rarity <= 9) {
                            if (inventory.containsKey("chilan_berry")) {
                                inventory.put("chilan_berry", inventory.get("chilan_berry") + 1);
                            } else {
                                inventory.put("chilan_berry", 1);
                            }
                        } else if (random_rarity == 10) {
                            if (inventory.containsKey("rowap_berry")) {
                                inventory.put("rowap_berry", inventory.get("rowap_berry") + 1);
                            } else {
                                inventory.put("rowap_berry", 1);
                            }
                        }
                    }
                    break;
                case "Fem1":
                    if (gp.gameState == gp.playState && gp.currentMap == 1) {
                        gp.gameState = gp.dialogueState;
                        gp.currentNPC = gp.obj[gp.currentMap][i];
                        System.out.println("x = "+gp.currentNPC.worldX + ",y = "+gp.currentNPC.worldY);
                        gp.currentNPC.speak(gp);
                    }
                    break;
                case "Fem2":
                    if ( gp.gameState == gp.playState  && gp.currentMap == 1) {
                        gp.gameState = gp.dialogueState;
                        gp.currentNPC = gp.obj[gp.currentMap][i];
                        gp.currentNPC.speak(gp);
                    }
                    break;
                    case "arceus":
                    //bool still speaking buat cek msh ngmg ta ga npc e
                    if ( gp.gameState == gp.playState  && gp.currentMap == 1) {
                        gp.gameState = gp.dialogueState;
                        gp.currentNPC = gp.obj[gp.currentMap][i];
                        gp.currentNPC.speak(gp);
                    }
                    break;
                case "Meja2":
                    if ( gp.gameState == gp.playState  && gp.currentMap == 4) {
                        gp.gameState = gp.dialogueState;
                        gp.currentNPC = gp.obj[gp.currentMap][i];
                        gp.currentNPC.speak(gp);
                    }
                break;
                case "rak3":
                    if ( gp.gameState == gp.playState  && gp.currentMap == 4) {
                        gp.gameState = gp.shopState;
                        gp.currentNPC = gp.obj[gp.currentMap][i];
                    }
                break;
                case "rak4":
                    if ( gp.gameState == gp.playState  && gp.currentMap == 4) {
                        gp.gameState = gp.shopState;
                        gp.currentNPC = gp.obj[gp.currentMap][i];
                    }
                break;
                case "vend3":
                    if ( gp.gameState == gp.playState  && gp.currentMap == 4) {
                        gp.gameState = gp.vendingShopState;
                        gp.currentNPC = gp.obj[gp.currentMap][i];
                    }
                break;
                case "vend4":
                    if ( gp.gameState == gp.playState  && gp.currentMap == 4) {
                        gp.gameState = gp.vendingShopState;
                        gp.currentNPC = gp.obj[gp.currentMap][i];
                    }
                break;
                case "rumah1":
                    //bool still speaking buat cek msh ngmg ta ga npc e
                    if ( gp.gameState == gp.playState  && gp.currentMap == 0) {
                        gp.gameState = gp.dialogueState;
                        gp.currentNPC = gp.obj[gp.currentMap][i];
                        gp.currentNPC.speak(gp);
                    }
                break;
                case "rumah2":
                    //bool still speaking buat cek msh ngmg ta ga npc e
                    if ( gp.gameState == gp.playState  && gp.currentMap == 0) {
                        gp.gameState = gp.dialogueState;
                        gp.currentNPC = gp.obj[gp.currentMap][i];
                        gp.currentNPC.speak(gp);
                    }
                break;
                case "rumah3":
                    //bool still speaking buat cek msh ngmg ta ga npc e
                    if ( gp.gameState == gp.playState  && gp.currentMap == 0) {
                        gp.gameState = gp.dialogueState;
                        gp.currentNPC = gp.obj[gp.currentMap][i];
                        gp.currentNPC.speak(gp);
                    }
                break;
                case "rumah4":
                    //bool still speaking buat cek msh ngmg ta ga npc e
                    if ( gp.gameState == gp.playState  && gp.currentMap == 0) {
                        gp.gameState = gp.dialogueState;
                        gp.currentNPC = gp.obj[gp.currentMap][i];
                        gp.currentNPC.speak(gp);
                    }
                break;
            }
        }
    }
    
    public void draw(Graphics2D g2){
//        g2.setColor(Color.white);
//        g2.fillRect(x, y, gp.tilesSize, gp.tilesSize);
        BufferedImage image = null;
        
        switch(direction){
            case "up":
                if(spriteNum == 1){
                    image = up1;
                }
                if(spriteNum == 2){
                    image = up2;
                }
                break;
            case "down":
                if(spriteNum == 1){
                    image = down1;
                }
                if(spriteNum == 2){
                    image = down2;
                }
                break;
            case "left":
                if(spriteNum == 1){
                    image = left1;
                }
                if(spriteNum == 2){
                    image = left2;
                }
                break;
            case "right":
                if(spriteNum == 1){
                    image = right1;
                }
                if(spriteNum == 2){
                    image = right2;
                }
                break;
        }
        g2.drawImage(image, screenX, screenY, gp.tilesSize, gp.tilesSize, null);
    }
}
