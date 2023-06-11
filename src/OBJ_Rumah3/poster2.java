/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OBJ_Rumah3;

import java.io.IOException;
import javax.imageio.ImageIO;
import object.SuperObject;

/**
 *
 * @author WILLIAM
 */
public class poster2 extends SuperObject{

    public poster2() {
        name = "poster2";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/indoor/23.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        
        collision = true;
    }
    
}
