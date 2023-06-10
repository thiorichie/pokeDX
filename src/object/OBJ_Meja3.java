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
public class OBJ_Meja3 extends SuperObject{
    public OBJ_Meja3(){
        name = "Meja3";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/indoor/meja3.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        
        collision = true;
    }
}
