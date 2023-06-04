/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkgPokemon_DX;

import object.NPC_f1;
import object.NPC_f2;
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
        
        gp.obj[0][0] = new OBJ_Key();
        gp.obj[0][0].worldX = 6 * gp.tilesSize;
        gp.obj[0][0].worldY = 5 * gp.tilesSize;
        
        gp.obj[0][1] = new OBJ_Door();
        gp.obj[0][1].worldX = 7 * gp.tilesSize;
        gp.obj[0][1].worldY = 7 * gp.tilesSize;
        
        gp.obj[0][2] = new NPC_f1();
        gp.obj[0][2].worldX = 15 * gp.tilesSize;
        gp.obj[0][2].worldY = 17 * gp.tilesSize;
        
        gp.obj[0][3] = new NPC_f2();
        gp.obj[0][3].worldX = 24 * gp.tilesSize;
        gp.obj[0][3].worldY = 8 * gp.tilesSize;
        
        gp.obj[0][4] = new OBJ_Boots();
        gp.obj[0][4].worldX = 7 * gp.tilesSize;
        gp.obj[0][4].worldY = 5 * gp.tilesSize;
    }
}
