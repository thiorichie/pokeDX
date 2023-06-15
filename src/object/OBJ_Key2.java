/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author thior
 */
public class OBJ_Key2 extends SuperObject{
    public OBJ_Key2(){
        name = "Key2";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/key2.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        
    }
}

