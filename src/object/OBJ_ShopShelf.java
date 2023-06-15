/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author rici
 */
public class OBJ_ShopShelf extends SuperObject {
    public OBJ_ShopShelf(){
        name = "ShopShelf";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/shop_shelf.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        
        collision = true;
    }
}
