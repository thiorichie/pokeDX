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
public class Arceus extends SuperObject{
    public Arceus(){
        name = "arceus";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/poke/arceus.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        
        collision = true;
        sudahBattle = false;
        setDialogue();
    }
    
    private void setDialogue(){
        Dialogues[0] = "Heyy, you look so Easy!";
        Dialogues[1] = "Fuck You";
        Dialogues[2] = "!!!";
        
    }
    
    public void speak(GamePanel gp){
        if (Dialogues[dialogueIndex] == null) {
            //klo udh selesai ngomong
            dialogueIndex=0;
            if (sudahBattle == false) {
                gp.gameState = gp.battleState;
                gp.ui.poke1 = gp.ui.pokemon.Arceus;
                gp.ui.isBossBattle = true;
                gp.stopMusic();
                gp.playMusic(5);
                sudahBattle=true;
            }
            else{
                gp.gameState = gp.playState;
            }
            gp.currentNPC=null;
        }
        
        gp.ui.CurrentDialogue = Dialogues[dialogueIndex];
        
    }
}
