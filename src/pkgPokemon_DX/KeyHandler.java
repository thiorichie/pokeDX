/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkgPokemon_DX;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import object.SuperObject;

/**
 *
 * @author thior
 */
public class KeyHandler implements KeyListener{
    GamePanel gp;
    public boolean upPressed, downPressed, leftPressed,rightPressed;    
    //DEBUG
    boolean checkDrawTime = false;
    
    public KeyHandler(GamePanel gp){
        this.gp = gp;
    }
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        
        //play state
        if (gp.gameState == gp.playState) {
            if (code == KeyEvent.VK_W) {
                upPressed = true;
            }

            if (code == KeyEvent.VK_A) {
                leftPressed = true;
            }

            if (code == KeyEvent.VK_S) {
                downPressed = true;
            }

            if (code == KeyEvent.VK_D) {
                rightPressed = true;
            }

            if (code == KeyEvent.VK_ESCAPE) {
                gp.gameState = gp.pauseState;
                
            }

            //DEBUG
            if (code == KeyEvent.VK_T) {
                if (checkDrawTime == false) {
                    checkDrawTime = true;
                } else if (checkDrawTime == true) {
                    checkDrawTime = false;
                }
            }
        }
        
        //pause state
        else if (gp.gameState == gp.pauseState) {
            if (code == KeyEvent.VK_ESCAPE) {
                gp.gameState = gp.playState;
                
            }
        }
        
        //dialogue state
        else if (gp.gameState == gp.dialogueState) {
            if (code == KeyEvent.VK_ENTER) {
                gp.currentNPC.dialogueIndex++;
                System.out.println("Index berhasil ditambah");
                gp.currentNPC.speak(gp);
            }
        }
        
        //battle state 
        else if (gp.gameState == gp.battleState) {
            //ini cuma sementara nanti diahpus
            if (code == KeyEvent.VK_ESCAPE) {
                gp.gameState = gp.playState;
            }
            
            //cursor move
            if (code == KeyEvent.VK_W ) {
                gp.ui.commandNum--;
                if (gp.ui.commandNum < 0) {
                    gp.ui.commandNum = 3;
                }
            }
            
            if (code == KeyEvent.VK_S ) {
                gp.ui.commandNum++;
                if (gp.ui.commandNum > 3) {
                    gp.ui.commandNum = 0;
                }
            }
            
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        
        if(code == KeyEvent.VK_W){
            upPressed = false;
        }
        
        if(code == KeyEvent.VK_A){
            leftPressed = false;
        }
        
        if(code == KeyEvent.VK_S){
            downPressed = false;
        }
        
        if(code == KeyEvent.VK_D){
            rightPressed = false;
        }
    }
    
}
