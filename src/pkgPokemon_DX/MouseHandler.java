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

