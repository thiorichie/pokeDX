/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OBJ_Rumah3;

import java.io.IOException;
import javax.imageio.ImageIO;
import object.SuperObject;
import pkgPokemon_DX.GamePanel;

/**
 *
 * @author WILLIAM
 */
    public class vend3 extends SuperObject{

    public vend3() {
        name = "vend3";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/indoor/29.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        
        collision = true;
    }
    
    public void speak(GamePanel gp){
        if (Dialogues[dialogueIndex] == null) {
            dialogueIndex=0;
            gp.currentNPC=null;
            gp.gameState = gp.playState;
        }
        gp.ui.CurrentDialogue = Dialogues[dialogueIndex];
    }
}
