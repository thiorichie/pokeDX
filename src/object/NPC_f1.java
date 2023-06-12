/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

import java.io.IOException;
import javax.imageio.ImageIO;
import pkgPokemon_DX.GamePanel;

/**
 *
 * @author Ryu A.H
 */
public class NPC_f1 extends SuperObject{
    public NPC_f1(){
        name = "Fem1";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/NPC/f-1.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        
        collision = true;
        sudahBattle = false;
        setDialogue();
    }
    
    private void setDialogue(){
        Dialogues[0] = "Heyy, you look so tough!";
        Dialogues[1] = "Are u looking for battle partner?";
        Dialogues[2] = "Okay then lets do it!";
        
    }
    
    public void speak(GamePanel gp){
        if (Dialogues[dialogueIndex] ==null) {
            //klo udh selesai ngomong
            dialogueIndex=0;
            if (sudahBattle == false) {
                gp.gameState = gp.battleState;
                gp.ui.poke1 = gp.ui.pokemon.catchMonster("misdreavus");
//                sudahBattle=true;
            }
            else{
                gp.gameState = gp.playState;
            }
            gp.currentNPC=null;
        }
        
        gp.ui.CurrentDialogue = Dialogues[dialogueIndex];
        
    }
}
