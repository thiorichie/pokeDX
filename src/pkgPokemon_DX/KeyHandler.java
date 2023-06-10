/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkgPokemon_DX;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import object.SuperObject;
import poke.Monster;

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
//            if (code == KeyEvent.VK_ESCAPE) {
//                gp.gameState = gp.playState;
//            }
            
            //cursor move
            if (code == KeyEvent.VK_UP ) {
                gp.ui.commandNum--;
                if (gp.ui.commandNum < 0 && gp.ui.menu_state == 1) {
                    gp.ui.commandNum = gp.ui.poke2.skill.size() -1;
                }
                else if (gp.ui.commandNum < 0) {
                    gp.ui.commandNum = 3;
                }
            }
            
            if (code == KeyEvent.VK_DOWN ) {
                gp.ui.commandNum++;
                if (gp.ui.commandNum >= gp.ui.poke2.skill.size() && gp.ui.menu_state == 1) {
                    gp.ui.commandNum = 0;
                }
                if (gp.ui.commandNum > 3) {
                    gp.ui.commandNum = 0;
                }
            }
            
            // untuk enter lnjtin dr pop up text
            if (code == KeyEvent.VK_ENTER && gp.ui.menu_state == 99) {
                // cek dlu enemy udh gerak lom
                if (gp.ui.TextPopup) {
                    gp.ui.menu_state = 0;
                    gp.ui.TextPopup = false;
                }
                else if (gp.ui.flee) {
                    gp.ui.menu_state = 0;
                    gp.ui.TextPopup = false;
                    gp.gameState = gp.playState;
                    //reset
                    gp.ui.flee =false;
                }
                else{
                    gp.ui.commandNum = 0;
                    gp.ui.enemy_action();
                }
                
                
            }
            
            //buat key action pas atk
            else if (code == KeyEvent.VK_ENTER && gp.ui.menu_state == 1) {
                Monster temp = gp.ui.poke2;
                if (gp.ui.commandNum == 0) {
                    gp.ui.action(temp.skill.get(0).getDmg(), temp.skill.get(0).getHeal(), temp, gp.ui.poke1);
                    gp.ui.menu_state = 99;
                }
                if (gp.ui.commandNum == 1) {
                    gp.ui.action(temp.skill.get(1).getDmg(), temp.skill.get(1).getHeal(), temp, gp.ui.poke1);
                    gp.ui.menu_state = 99;
                }
                if (gp.ui.commandNum == 2) {
                    gp.ui.action(temp.skill.get(2).getDmg(), temp.skill.get(2).getHeal(), temp, gp.ui.poke1);
                    gp.ui.menu_state = 99;
                }
                if (gp.ui.commandNum == 3) {
                    gp.ui.action(temp.skill.get(3).getDmg(), temp.skill.get(3).getHeal(), temp, gp.ui.poke1);
                    gp.ui.menu_state = 99;
                }
            }
            
            else if (code == KeyEvent.VK_ENTER && gp.ui.menu_state == 0) {
                if (gp.ui.commandNum == 0) {
                    gp.ui.menu_state = 1;
                    gp.ui.commandNum = 0;
                }
                if (gp.ui.commandNum == 1) {
                    gp.ui.menu_state = 2;
                    gp.ui.commandNum = 0;
                }
                if (gp.ui.commandNum == 2) {
                    gp.ui.menu_state = 3;
                    gp.ui.commandNum = 0;
                }
                if (gp.ui.commandNum == 3) {
                    gp.ui.commandNum = 0;
                    gp.ui.flee = true;
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
