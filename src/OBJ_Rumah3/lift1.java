/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OBJ_Rumah3;

import object.*;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author WILLIAM
 */
public class lift1 extends SuperObject{

    public lift1() {
        name = "lift1";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/indoor/9.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        
        collision = true;
    }
    
}
