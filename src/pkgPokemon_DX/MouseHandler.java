/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkgPokemon_DX;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author thior
 */
public class MouseHandler implements MouseListener{
    GamePanel gp;
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
            if((x >= 478 && x <= 768) && (y <= 415 && y >= 344 && gp.gameState == gp.titleState)){
                gp.gameState = gp.storyState;
                gp.stopMusic();
                gp.playMusic(y);
                System.out.println("Masuk bosku");
            }
            if((x >= 163 && x <= 356) && (y <= 264 && y >= 233 && gp.gameState == gp.storyState)){
                gp.gameState = gp.playState;
                gp.stopMusic();
                gp.playMusic(y);
            }
            if((x >= 552 && x <= 747) && (y <= 264 && y >= 233 && gp.gameState == gp.storyState)){
                gp.gameState = gp.playState;
                gp.stopMusic();
                gp.playMusic(y);
            }
            if((x >= 932 && x <= 1127) && (y <= 264 && y >= 233 && gp.gameState == gp.storyState)){
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
    
}

