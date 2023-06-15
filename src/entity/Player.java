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
        
        worldX = gp.tilesSize * 2;
        worldY = gp.tilesSize * 4;
        speed = 3;
        direction = "down";
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
                    gp.obj[gp.currentMap][i] = null;
                    System.out.println("Boots : " + inventory.get("boots"));
                    if(inventory.containsKey("boots")) {
                        inventory.put("boots", inventory.get("boots") + 1);
                    } else {
                        inventory.put("boots", 1);
                    }
                    break;
                case "Key":
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
                        } else {
                            inventory.remove("key");
                        }
                    }
                    System.out.println("Key : " + inventory.get("key"));
                    break;
                case "Fem1":
                    if (gp.gameState == gp.playState && gp.currentMap == 0) {
                        gp.gameState = gp.dialogueState;
                        gp.currentNPC = gp.obj[gp.currentMap][i];
                        System.out.println("x = "+gp.currentNPC.worldX + ",y = "+gp.currentNPC.worldY);
                        gp.currentNPC.speak(gp);
                    }
                    break;
                case "Fem2":
                    //bool still speaking buat cek msh ngmg ta ga npc e
                    if ( gp.gameState == gp.playState  && gp.currentMap == 0) {
                        gp.gameState = gp.dialogueState;
                        gp.currentNPC = gp.obj[gp.currentMap][i];
                        gp.currentNPC.speak(gp);
                    }
                    break;
                case "Meja2":
                    //bool still speaking buat cek msh ngmg ta ga npc e
                    if ( gp.gameState == gp.playState  && gp.currentMap == 4) {
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
