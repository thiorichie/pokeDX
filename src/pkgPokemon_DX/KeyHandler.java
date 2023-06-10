/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkgPokemon_DX;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
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
                else if(gp.ui.commandNum < 0 && gp.ui.menu_state == 2) {
                    gp.ui.commandNum = 2;
                }
                else if(gp.ui.commandNum < 0 && gp.ui.menu_state >= 21 && gp.ui.menu_state >= 23) {
                    gp.ui.commandNum = 2;
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
                else if(gp.ui.commandNum > 2 && gp.ui.menu_state == 2) {
                    gp.ui.commandNum = 0;
                }
                else if(gp.ui.commandNum > 2 && gp.ui.menu_state >= 21 && gp.ui.menu_state >= 23) {
                    gp.ui.commandNum = 0;
                }
                else if (gp.ui.commandNum > 3) {
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
            
            else if (code == KeyEvent.VK_ENTER && gp.ui.menu_state == 23) {
                Monster playerPokemon = gp.player.party.get(0);
                if (gp.ui.commandNum == 0) {
                    if(gp.player.inventory.containsKey("potion")) {
                        if(gp.player.inventory.get("potion") - 1 >= 0) {
                            gp.ui.message = "Potion consumed to your pokemon !";
                            if(playerPokemon.getHp() + 20 > playerPokemon.getMax_hp()) playerPokemon.setHp(playerPokemon.getMax_hp());
                            else playerPokemon.setHp(playerPokemon.getHp() + 20);
                            gp.player.inventory.put("potion", gp.player.inventory.get("potion") - 1);
                        } else {
                            gp.ui.message = "Potion is empty !";
                        }
                    } else {
                         gp.ui.message = "You don't have any potion !";
                    }
                }
                if (gp.ui.commandNum == 1) {
                    if(gp.player.inventory.containsKey("super_potion")) {
                        if(gp.player.inventory.get("super_potion") - 1 >= 0) {
                            gp.ui.message = "Super potion consumed to your pokemon !";
                            if(playerPokemon.getHp() + 50 > playerPokemon.getMax_hp()) playerPokemon.setHp(playerPokemon.getMax_hp());
                            else playerPokemon.setHp(playerPokemon.getHp() + 50);
                            gp.player.inventory.put("super_potion", gp.player.inventory.get("super_potion") - 1);
                        } else {
                            gp.ui.message = "Super potion is empty !";
                        }
                    } else {
                         gp.ui.message = "You don't have any super potion !";
                    }
                }
                if (gp.ui.commandNum == 2) {
                    if(gp.player.inventory.containsKey("hyper_potion")) {
                        if(gp.player.inventory.get("hyper_potion") - 1 >= 0) {
                            gp.ui.message = "Hyper potion consumed to your pokemon !";
                            if(playerPokemon.getHp() + 200 > playerPokemon.getMax_hp()) playerPokemon.setHp(playerPokemon.getMax_hp());
                            else playerPokemon.setHp(playerPokemon.getHp() + 200);
                            gp.player.inventory.put("rowap_berry", gp.player.inventory.get("hyper_potion") - 1);
                        } else {
                            gp.ui.message = "Hyper potion is empty !";
                        }
                    } else {
                         gp.ui.message = "You don't have any hyper potion !";
                    }
                }
                gp.ui.TextPopup = true;
                gp.ui.menu_state = 99;
            }
            
            else if (code == KeyEvent.VK_ENTER && gp.ui.menu_state == 22) {
                Monster playerPokemon = gp.player.party.get(0);
                if (gp.ui.commandNum == 0) {
                    if(gp.player.inventory.containsKey("colbur_berry")) {
                        if(gp.player.inventory.get("colbur_berry") - 1 >= 0) {
                            gp.ui.message = "Colbur berry consumed to your pokemon !";
                            if(playerPokemon.getHp() + 25 > playerPokemon.getMax_hp()) playerPokemon.setHp(playerPokemon.getMax_hp());
                            else playerPokemon.setHp(playerPokemon.getHp() + 25);
                            gp.player.inventory.put("colbur_berry", gp.player.inventory.get("colbur_berry") - 1);
                        } else {
                            gp.ui.message = "Colbur berry is empty !";
                        }
                    } else {
                         gp.ui.message = "You don't have any colbur berry !";
                    }
                }
                if (gp.ui.commandNum == 1) {
                    if(gp.player.inventory.containsKey("chilan_berry")) {
                        if(gp.player.inventory.get("chilan_berry") - 1 >= 0) {
                            gp.ui.message = "Chilan berry consumed to your pokemon !";
                            if(playerPokemon.getHp() + 50 > playerPokemon.getMax_hp()) playerPokemon.setHp(playerPokemon.getMax_hp());
                            else playerPokemon.setHp(playerPokemon.getHp() + 50);
                            gp.player.inventory.put("chilan_berry", gp.player.inventory.get("chilan_berry") - 1);
                        } else {
                            gp.ui.message = "Chilan berry is empty !";
                        }
                    } else {
                         gp.ui.message = "You don't have any chilan berry !";
                    }
                }
                if (gp.ui.commandNum == 2) {
                    if(gp.player.inventory.containsKey("rowap_berry")) {
                        if(gp.player.inventory.get("rowap_berry") - 1 >= 0) {
                            gp.ui.message = "Rowap berry consumed to your pokemon !";
                            if(playerPokemon.getHp() + 75 > playerPokemon.getMax_hp()) playerPokemon.setHp(playerPokemon.getMax_hp());
                            else playerPokemon.setHp(playerPokemon.getHp() + 75);
                            gp.player.inventory.put("rowap_berry", gp.player.inventory.get("rowap_berry") - 1);
                        } else {
                            gp.ui.message = "Rowap berry is empty !";
                        }
                    } else {
                         gp.ui.message = "You don't have any rowap berry !";
                    }
                }
                gp.ui.TextPopup = true;
                gp.ui.menu_state = 99;
            }
            
            else if (code == KeyEvent.VK_ENTER && gp.ui.menu_state == 21) {
                int getIndex = (new Random()).nextInt(0, 101);
                if (gp.ui.commandNum == 0) {
                    if(gp.player.inventory.containsKey("red_poke_ball")) {
                        if(gp.player.inventory.get("red_poke_ball") - 1 >= 0) {
                            if(getIndex <= 50) {
                                gp.ui.message = "You successfully captured the " + gp.ui.poke2.getNama() + " !";
                                gp.player.party.add(gp.ui.poke2);
                            } 
                            else gp.ui.message ="The " + gp.ui.poke2.getNama() + " escaped the capture !";
                            gp.player.inventory.put("red_poke_ball", gp.player.inventory.get("red_poke_ball") - 1);
                        } else {
                            gp.ui.message = "Red poke ball is empty !";
                        }
                    } else {
                         gp.ui.message = "You don't have any red poke ball !";
                    }
                }
                if (gp.ui.commandNum == 1) {
                    if(gp.player.inventory.containsKey("great_ball")) {
                        if(gp.player.inventory.get("great_ball") - 1 >= 0) {
                            if(getIndex <= 75) {
                                gp.ui.message = "You successfully captured the " + gp.ui.poke2.getNama() + " !";
                                gp.player.party.add(gp.ui.poke2);
                            } 
                            else gp.ui.message ="The " + gp.ui.poke2.getNama() + " escaped the capture !";
                            gp.player.inventory.put("great_ball", gp.player.inventory.get("great_ball") - 1);
                        } else {
                            gp.ui.message = "Great ball is empty !";
                        }
                    } else {
                         gp.ui.message = "You don't have any great ball !";
                    }
                }
                if (gp.ui.commandNum == 2) {
                    if(gp.player.inventory.containsKey("ultra_ball")) {
                        if(gp.player.inventory.get("ultra_ball") - 1 >= 0) {
                            gp.ui.message = "You successfully captured the " + gp.ui.poke2.getNama() + " !";
                            gp.player.party.add(gp.ui.poke2);
                            gp.player.inventory.put("ultra_ball", gp.player.inventory.get("ultra_ball") - 1);
                        } else {
                            gp.ui.message = "Ultra ball is empty !";
                        }
                    } else {
                         gp.ui.message = "You don't have any ultra ball !";
                    }
                }
                gp.ui.TextPopup = true;
                gp.ui.menu_state = 99;
            }
            
            else if (code == KeyEvent.VK_ENTER && gp.ui.menu_state == 2) {;
                if (gp.ui.commandNum == 0) {
                    gp.ui.menu_state = 21;
                }
                if (gp.ui.commandNum == 1) {
                    gp.ui.menu_state = 22;
                }
                if (gp.ui.commandNum == 2) {
                    gp.ui.menu_state = 23;
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
            else if(code == KeyEvent.VK_ESCAPE) {
                if(gp.ui.menu_state == 1 || gp.ui.menu_state == 2 || gp.ui.menu_state == 3) gp.ui.menu_state = 0;
                if(gp.ui.menu_state == 21 || gp.ui.menu_state == 22 || gp.ui.menu_state == 23) gp.ui.menu_state = 2;
                gp.ui.commandNum = 0;
            }
             if (code == KeyEvent.VK_ENTER) gp.ui.commandNum = 0;
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
