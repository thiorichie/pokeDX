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
public class lift9 extends SuperObject{

    public lift9() {
        name = "lift9";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/indoor/17.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
    
}
