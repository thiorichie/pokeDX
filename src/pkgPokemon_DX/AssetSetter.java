/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkgPokemon_DX;

import object.OBJ_Boots;
import object.OBJ_Chest;
import object.OBJ_Door;
import object.OBJ_Key;

/**
 *
 * @author thior
 */
public class AssetSetter {
    
    GamePanel gp;
    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }
    
    public void setObject(){
        
        gp.obj[0] = new OBJ_Key();
        gp.obj[0].worldX = 6 * gp.tilesSize;
        gp.obj[0].worldY = 5 * gp.tilesSize;
        
        gp.obj[1] = new OBJ_Door();
        gp.obj[1].worldX = 7 * gp.tilesSize;
        gp.obj[1].worldY = 7 * gp.tilesSize;
    }
}
