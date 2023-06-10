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
public class rumah1 extends SuperObject {
    public rumah1(){
        name = "Door";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/rumah/10.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        
        collision = true;
    }
}
