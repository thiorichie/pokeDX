/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OBJ_Rumah3;

import java.io.IOException;
import javax.imageio.ImageIO;
import object.SuperObject;
import object.SuperObject;
import pkgPokemon_DX.GamePanel;
import poke.Monster;

/**
 *
 * @author WILLIAM
 */
public class OBJ_Meja2 extends SuperObject{
    public OBJ_Meja2(){
        name = "Meja2";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/indoor/meja2.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        
        collision = true;
        sudahBattle = true;
        setDialogue();
    }
    
    private void setDialogue(){
        Dialogues[0] = "Hello, and welcome to the pokemon Center.";
        Dialogues[1] = "We restore your tired Pokemon to full health.";
        Dialogues[2] = "I'll take your Pokemon for a few seconds.";
        Dialogues[3] = "Please wait patiently...";
        Dialogues[4] = "Healing...";
        Dialogues[5] = "Thank you for waiting.";
        Dialogues[6] = "We've restore your Pokemon to full health.";
        Dialogues[7] = "We hope to see you again!";
        
    }
    
    public void speak(GamePanel gp){
        if (Dialogues[dialogueIndex] ==null) {
            //klo udh selesai ngomong
            dialogueIndex=0;
            gp.gameState = gp.playState;
            gp.currentNPC=null;
            for (Monster party : gp.player.party) {
                if (party.getStatus() == true) {
                    party.restoreHP();
                }
                else{
                    party.revive(party.getMax_hp());
                }
                System.out.println(party);
            }
        }
        
        gp.ui.CurrentDialogue = Dialogues[dialogueIndex];
        
    }
}
