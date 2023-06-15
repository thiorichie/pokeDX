/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.IOException;
import javax.imageio.ImageIO;
import object.SuperObject;
import pkgPokemon_DX.GamePanel;

/**
 *
 * @author WILLIAM
 */
    public class shopShelf extends SuperObject{
    public shopShelf() {
        name = "shopShelf";
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
