/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

import java.awt.Graphics2D;
import java.io.IOException;
import javax.imageio.ImageIO;
import pkgPokemon_DX.GamePanel;

/**
 *
 * @author Ryu A.H
 */
public class NPC_f2 extends SuperObject{
    public NPC_f2(){
        name = "Fem2";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/NPC/f-2.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        
        collision = true;
        setDialogue();
    }
    
    private void setDialogue(){
        Dialogues[0] = "Nice to meet you are new here?\nI have never see you before...";
        Dialogues[1] = "I see";
        Dialogues[2] = "My uncle is harvesting rn, so..";
        Dialogues[3] = "We have excess bread";
        Dialogues[4] = "Do you want some?";
    }
    
    public void speak(GamePanel gp){
        if (Dialogues[dialogueIndex] ==null) {
            //klo udh selesai ngomong
            dialogueIndex=0;
            gp.gameState = gp.playState;
            gp.currentNPC=null;
        }
        
        gp.ui.CurrentDialogue = Dialogues[dialogueIndex];
        
    }
}
