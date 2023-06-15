/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkgPokemon_DX;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author thior
 */
public class Sound {
    Clip clip;
    URL soundURL[] = new URL[30];
    
    public Sound (){
        soundURL[6] = getClass().getResource("/sound/battle.wav");
        soundURL[5] = getClass().getResource("/sound/final.wav");
        soundURL[0] = getClass().getResource("/sound/main.wav");
        soundURL[1] = getClass().getResource("/sound/coin.wav");
        soundURL[2] = getClass().getResource("/sound/powerup.wav");
        soundURL[3] = getClass().getResource("/sound/unlock.wav");
        soundURL[4] = getClass().getResource("/sound/fanfare.wav");
    }
    
    public void setFile (int i){
        try{
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        }
        catch (Exception e){
            
        }
    }
    
    public void play (){
        clip.start();
    }
    
    public void loop (){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    
    public void stop (){
        clip.stop();
    }
}
