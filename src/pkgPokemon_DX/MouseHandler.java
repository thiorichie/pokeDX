/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkgPokemon_DX;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import poke.Pokemon;

/**
 *
 * @author thior
 */
public class MouseHandler implements MouseListener{
    GamePanel gp;
    Pokemon poke = new Pokemon();
    boolean clicked = false;
    
    
    public MouseHandler(GamePanel gp){
        this.gp = gp;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int button = e.getButton();
        if(button == MouseEvent.BUTTON1){
            int x = e.getX();
            int y = e.getY();
            System.out.println("pos X = " + x + ", pos Y = " + y);
            
            clicked =false;
            
            // buy colbur berry
            if(((x >= 420 && x <= 909) && (y <= 510 && y >= 438)) && gp.gameState == gp.buyBerriesState) {
                gp.removeAll();
                if(gp.player.coin - 25 >= 0) {
                    gp.player.coin -= 25;
                    if(gp.player.inventory.containsKey("colbur_berry")) {
                        gp.player.inventory.put("colbur_berry", gp.player.inventory.get("colbur_berry") + 1);
                    } else gp.player.inventory.put("colbur_berry", 1);
                    gp.ui.CurrentDialogue = "You've purchased colbur berry for 25G !";
                } else gp.ui.CurrentDialogue = "You don't have enough gold !";
                gp.gameState = gp.dialogueState;
                gp.stopMusic();
                gp.playMusic(y);
            }
            
            // buy chilan berry
            if(((x >= 415 && x <= 906) && (y <= 398 && y >= 327)) && gp.gameState == gp.buyBerriesState) {
                gp.removeAll();
                if(gp.player.coin - 50 >= 0) {
                    gp.player.coin -= 50;
                    if(gp.player.inventory.containsKey("chilan_berry")) {
                        gp.player.inventory.put("chilan_berry", gp.player.inventory.get("chilan_berry") + 1);
                    } else gp.player.inventory.put("chilan_berry", 1);
                    gp.ui.CurrentDialogue = "You've purchased chilan berry for 50G !";
                } else gp.ui.CurrentDialogue = "You don't have enough gold !";
                gp.gameState = gp.dialogueState;
                gp.stopMusic();
                gp.playMusic(y);
            }
            
            // buy rowap berry
            if(((x >= 418 && x <= 903) && (y <= 277 && y >= 214)) && gp.gameState == gp.buyBerriesState) {
                gp.removeAll();
                if(gp.player.coin - 75 >= 0) {
                    gp.player.coin -= 75;
                    if(gp.player.inventory.containsKey("rowap_berry")) {
                        gp.player.inventory.put("rowap_berry", gp.player.inventory.get("rowap_berry") + 1);
                    } else gp.player.inventory.put("rowap_berry", 1);
                    gp.ui.CurrentDialogue = "You've purchased rowap berry for 75G !";
                } else gp.ui.CurrentDialogue = "You don't have enough gold !";
                gp.gameState = gp.dialogueState;
                gp.stopMusic();
                gp.playMusic(y);
            }
            
            // close berries shop menu
            if(((x <= 355  || x >= 936) || (y <= 196 || y >= 526)) || ((x >= 913 && x <= 943) && (y <= 223 && y >= 186)) && gp.gameState == gp.buyBerriesState) {
                gp.removeAll();
                gp.gameState = gp.playState;
                gp.stopMusic();
                gp.playMusic(y);
            }
            
            // buy red poke ball
            if(((x >= 421 && x <= 905) && (y <= 520 && y >= 441)) && gp.gameState == gp.buyPokeState) {
                gp.removeAll();
                if(gp.player.coin - 50 >= 0) {
                    gp.player.coin -= 50;
                    if(gp.player.inventory.containsKey("red_poke_ball")) {
                        gp.player.inventory.put("red_poke_ball", gp.player.inventory.get("red_poke_ball") + 1);
                    } else gp.player.inventory.put("red_poke_ball", 1);
                    gp.ui.CurrentDialogue = "You've purchased poke ball for 50G !";
                } else gp.ui.CurrentDialogue = "You don't have enough gold !";
                gp.gameState = gp.dialogueState;
                gp.stopMusic();
                gp.playMusic(y);
            }
            
            // buy great ball
            if(((x >= 419 && x <= 907) && (y <= 407 && y >= 324)) && gp.gameState == gp.buyPokeState) {
                gp.removeAll();
                if(gp.player.coin - 150 >= 0) {
                    gp.player.coin -= 150;
                    if(gp.player.inventory.containsKey("great_ball")) {
                        gp.player.inventory.put("great_ball", gp.player.inventory.get("great_ball") + 1);
                    } else gp.player.inventory.put("great_ball", 1);
                    gp.ui.CurrentDialogue = "You've purchased great ball for 150G !";
                } else gp.ui.CurrentDialogue = "You don't have enough gold !";
                gp.gameState = gp.dialogueState;
                gp.stopMusic();
                gp.playMusic(y);
            }
            
            // buy ultra ball
            if(((x >= 410 && x <= 907) && (y <= 298 && y >= 218)) && gp.gameState == gp.buyPokeState) {
                gp.removeAll();
                if(gp.player.coin - 300 >= 0) {
                    gp.player.coin -= 300;
                    if(gp.player.inventory.containsKey("ultra_ball")) {
                        gp.player.inventory.put("ultra_ball", gp.player.inventory.get("ultra_ball") + 1);
                    } else gp.player.inventory.put("ultra_ball", 1);
                    gp.ui.CurrentDialogue = "You've purchased ultra ball for 300G !";
                } else gp.ui.CurrentDialogue = "You don't have enough gold !";
                gp.gameState = gp.dialogueState;
                gp.stopMusic();
                gp.playMusic(y);
            }
            
            // close poke shop menu
            if(((x <= 363  || x >= 947) || (y <= 196 || y >= 532)) || ((x >= 911 && x <= 944) && (y <= 222 && y >= 180)) && gp.gameState == gp.buyPokeState) {
                gp.removeAll();
                gp.gameState = gp.playState;
                gp.stopMusic();
                gp.playMusic(y);
            }
            
            // buy berries shop menu
            if(((x >= 514 && x <= 780) && (y <= 434 && y >= 372)) && gp.gameState == gp.shopState) {
                gp.removeAll();
                gp.gameState = gp.buyBerriesState;
                gp.stopMusic();
                gp.playMusic(y);
            }
            
            // buy poke shop menu
            if(((x >= 514 && x <= 780) && (y <= 347 && y >= 281)) && gp.gameState == gp.shopState) {
                gp.removeAll();
                gp.gameState = gp.buyPokeState;
                gp.stopMusic();
                gp.playMusic(y);
            }
            
            // close shop menu
            if(((x <= 511  || x >= 782) || (y <= 276 || y >= 443)) && gp.gameState == gp.shopState) {
                gp.removeAll();
                gp.gameState = gp.playState;
                gp.stopMusic();
                gp.playMusic(y);
            }
            
            // buy potion
            if(((x >= 409 && x <= 907) && (y <= 517 && y >= 441)) && gp.gameState == gp.vendingShopState) {
                gp.removeAll();
                if(gp.player.coin - 20 >= 0) {
                    gp.player.coin -= 20;
                    if(gp.player.inventory.containsKey("potion")) {
                        gp.player.inventory.put("potion", gp.player.inventory.get("potion") + 1);
                    } else gp.player.inventory.put("potion", 1);
                    gp.ui.CurrentDialogue = "You've purchased potion for 20G !";
                } else gp.ui.CurrentDialogue = "You don't have enough gold !";
                gp.gameState = gp.dialogueState;
                gp.stopMusic();
                gp.playMusic(y);
            }
            
            // buy super potion
            if(((x >= 409 && x <= 907) && (y <= 400 && y >= 332)) && gp.gameState == gp.vendingShopState) {
                gp.removeAll();
                if(gp.player.coin - 50 >= 0) {
                    gp.player.coin -= 50;
                    if(gp.player.inventory.containsKey("hyper_potion")) {
                        gp.player.inventory.put("hyper_potion", gp.player.inventory.get("hyper_potion") + 1);
                    } else gp.player.inventory.put("hyper_potion", 1);
                    gp.ui.CurrentDialogue = "You've purchased hyper potion for 50G !";
                } else gp.ui.CurrentDialogue = "You don't have enough gold !";
                gp.gameState = gp.dialogueState;
                gp.stopMusic();
                gp.playMusic(y);
            }
            
            // buy hyper potion
            if(((x >= 409 && x <= 907) && (y <= 297 && y >= 212)) && gp.gameState == gp.vendingShopState) {
                gp.removeAll();
                if(gp.player.coin - 200 >= 0) {
                    gp.player.coin -= 200;
                    if(gp.player.inventory.containsKey("hyper_potion")) {
                        gp.player.inventory.put("hyper_potion", gp.player.inventory.get("hyper_potion") + 1);
                    } else gp.player.inventory.put("hyper_potion", 1);
                    gp.ui.CurrentDialogue = "You've purchased hyper potion for 200G !";
                } else gp.ui.CurrentDialogue = "You don't have enough gold !";
                gp.gameState = gp.dialogueState;
                gp.stopMusic();
                gp.playMusic(y);
            }
            
            // close vending shop
            if(((x <= 356  || x >= 936) || (y <= 182 || y >= 535) && (y <= 221 && y >= 188)) && gp.gameState == gp.vendingShopState) {
                gp.removeAll();
                gp.gameState = gp.playState;
                gp.stopMusic();
                gp.playMusic(y);
            }
            
            // close inventory
            if(((x >= 846 && x <= 876) && (y >= 176 && y <= 206) || ((x <= 436 || x >= 899) || (y <= 164 || y >= 603))) && gp.gameState == gp.inventoryState) {
                gp.removeAll();
                gp.gameState = gp.playState;
                gp.stopMusic();
                gp.playMusic(y);
            }
            
            // open inventory
            if((x >= 23 && x <= 91) && (y >= 20 && y <= 87) && gp.gameState == gp.playState) {
                gp.gameState = gp.inventoryState;
                gp.stopMusic();
                gp.playMusic(y);
            }
            
            //cek klo start game ditekan
            if((x >= 478 && x <= 768) && (y <= 415 && y >= 344 && gp.gameState == gp.titleState)){
                gp.gameState = gp.storyState;
                gp.stopMusic();
                gp.playMusic(y);
                System.out.println("Masuk bosku");
            }
            
            //cek klo salah satu dari choose monster button ditekan
            if((x >= 163 && x <= 356) && (y <= 264 && y >= 233 && gp.gameState == gp.storyState)){
                gp.player.party.add(poke.Bulbasour);
                gp.gameState = gp.playState;
                gp.stopMusic();
                gp.playMusic(y);
                
            }
            if((x >= 552 && x <= 747) && (y <= 264 && y >= 233 && gp.gameState == gp.storyState)){
                gp.player.party.add(poke.Squirtle);
                gp.gameState = gp.playState;
                gp.stopMusic();
                gp.playMusic(y);
            }
            if((x >= 932 && x <= 1127) && (y <= 264 && y >= 233 && gp.gameState == gp.storyState)){
                gp.player.party.add(poke.Charmander);
                gp.gameState = gp.playState;
                gp.stopMusic();
                gp.playMusic(y);
            }
            
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
    public boolean getClickedStatus(){
        return clicked;
    }
    
}

