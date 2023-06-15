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
 * @author WILLIAM
 */
public class rumah3 extends SuperObject {
    public rumah3(){
        name = "rumah3";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/rumah3/8.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        
        collision = true;
        setDialogue();
        
    }
    
    private void setDialogue(){
        Dialogues[0] = "Coming Soon...";
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
