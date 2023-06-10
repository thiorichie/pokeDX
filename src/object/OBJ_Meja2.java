/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

import java.io.IOException;
import javax.imageio.ImageIO;

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
    }
}
