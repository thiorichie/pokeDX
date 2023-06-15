/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkgPokemon_DX;

import OBJ_Rumah3.bed1;
import OBJ_Rumah3.bed2;
import OBJ_Rumah3.chair;
import OBJ_Rumah3.lift1;
import object.NPC_f1;
import object.NPC_f2;
import object.OBJ_Boots;
import object.OBJ_Chest;
import object.OBJ_Door;
import object.OBJ_Key;
import object.OBJ_Meja1;
import OBJ_Rumah3.OBJ_Meja2;
import object.OBJ_Meja3;
import object.OBJ_Meja4;
import object.OBJ_Meja5;
import OBJ_Rumah3.lift2;
import OBJ_Rumah3.lift3;
import OBJ_Rumah3.lift4;
import OBJ_Rumah3.lift5;
import OBJ_Rumah3.lift6;
import OBJ_Rumah3.lift7;
import OBJ_Rumah3.lift8;
import OBJ_Rumah3.lift9;
import OBJ_Rumah3.pc;
import OBJ_Rumah3.poster1;
import OBJ_Rumah3.poster2;
import OBJ_Rumah3.poster3;
import OBJ_Rumah3.rak1;
import OBJ_Rumah3.rak2;
import OBJ_Rumah3.rak3;
import OBJ_Rumah3.rak4;
import OBJ_Rumah3.rak5;
import OBJ_Rumah3.rak6;
import OBJ_Rumah3.tanaman1;
import OBJ_Rumah3.tanaman2;
import OBJ_Rumah3.vend1;
import OBJ_Rumah3.vend2;
import OBJ_Rumah3.vend3;
import OBJ_Rumah3.vend4;
import object.rumah1;
import object.rumah2;
import object.rumah3;
import object.rumah4;

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
        
        gp.obj[1][0] = new OBJ_Key();
        gp.obj[1][0].worldX = 6 * gp.tilesSize;
        gp.obj[1][0].worldY = 5 * gp.tilesSize;
        
        gp.obj[1][1] = new OBJ_Door();
        gp.obj[1][1].worldX = 7 * gp.tilesSize;
        gp.obj[1][1].worldY = 7 * gp.tilesSize;
        
        gp.obj[1][2] = new NPC_f1();
        gp.obj[1][2].worldX = 15 * gp.tilesSize;
        gp.obj[1][2].worldY = 17 * gp.tilesSize;
        
        gp.obj[1][3] = new NPC_f2();
        gp.obj[1][3].worldX = 24 * gp.tilesSize;
        gp.obj[1][3].worldY = 8 * gp.tilesSize;
        
        gp.obj[1][4] = new OBJ_Boots();
        gp.obj[1][4].worldX = 7 * gp.tilesSize;
        gp.obj[1][4].worldY = 5 * gp.tilesSize;
        
        gp.obj[0][0] = new rumah1();
        gp.obj[0][0].worldX = 9 * gp.tilesSize;
        gp.obj[0][0].worldY = 17 * gp.tilesSize;
         
        gp.obj[0][1] = new rumah2();
        gp.obj[0][1].worldX = 19 * gp.tilesSize;
        gp.obj[0][1].worldY = 17 * gp.tilesSize;
         
        gp.obj[0][2] = new rumah3();
        gp.obj[0][2].worldX = 9 * gp.tilesSize;
        gp.obj[0][2].worldY = 31 * gp.tilesSize;
         
        gp.obj[0][3] = new rumah4();
        gp.obj[0][3].worldX = 19 * gp.tilesSize;
        gp.obj[0][3].worldY = 31 * gp.tilesSize;
         
        gp.obj[4][5] = new NPC_f1();
        gp.obj[4][5].worldX = 14 * gp.tilesSize;
        gp.obj[4][5].worldY = 16 * gp.tilesSize;
        
        gp.obj[4][7] = new lift1();
        gp.obj[4][7].worldX = 7 * gp.tilesSize;
        gp.obj[4][7].worldY = 20 * gp.tilesSize;
        
        gp.obj[4][8] = new lift2();
        gp.obj[4][8].worldX = 8 * gp.tilesSize;
        gp.obj[4][8].worldY = 20 * gp.tilesSize;
        
        gp.obj[4][9] = new lift3();
        gp.obj[4][9].worldX = 9 * gp.tilesSize;
        gp.obj[4][9].worldY = 20 * gp.tilesSize;
        
        gp.obj[4][10] = new lift4();
        gp.obj[4][10].worldX = 7 * gp.tilesSize;
        gp.obj[4][10].worldY = 21 * gp.tilesSize;
        
        gp.obj[4][11] = new lift5();
        gp.obj[4][11].worldX = 8 * gp.tilesSize;
        gp.obj[4][11].worldY = 21 * gp.tilesSize;
        
        gp.obj[4][12] = new lift6();
        gp.obj[4][12].worldX = 9 * gp.tilesSize;
        gp.obj[4][12].worldY = 21 * gp.tilesSize;
        
        gp.obj[4][13] = new lift7();
        gp.obj[4][13].worldX = 7 * gp.tilesSize;
        gp.obj[4][13].worldY = 22 * gp.tilesSize;
        
        gp.obj[4][14] = new lift8();
        gp.obj[4][14].worldX = 8 * gp.tilesSize;
        gp.obj[4][14].worldY = 22 * gp.tilesSize;
        
        gp.obj[4][15] = new lift9();
        gp.obj[4][15].worldX = 9 * gp.tilesSize;
        gp.obj[4][15].worldY = 22 * gp.tilesSize;

        gp.obj[4][19] = new rak1();
        gp.obj[4][19].worldX = 10 * gp.tilesSize;
        gp.obj[4][19].worldY = 14 * gp.tilesSize;
        
        gp.obj[4][20] = new rak2();
        gp.obj[4][20].worldX = 11 * gp.tilesSize;
        gp.obj[4][20].worldY = 14 * gp.tilesSize;
        
        gp.obj[4][21] = new rak3();
        gp.obj[4][21].worldX = 10 * gp.tilesSize;
        gp.obj[4][21].worldY = 15 * gp.tilesSize;
        
        gp.obj[4][22] = new rak4();
        gp.obj[4][22].worldX = 11 * gp.tilesSize;
        gp.obj[4][22].worldY = 15 * gp.tilesSize;
        
        gp.obj[4][23] = new poster1();
        gp.obj[4][23].worldX = 13 * gp.tilesSize;
        gp.obj[4][23].worldY = 14 * gp.tilesSize;
        
        gp.obj[4][24] = new poster2();
        gp.obj[4][24].worldX = 14 * gp.tilesSize;
        gp.obj[4][24].worldY = 14 * gp.tilesSize;
        
        gp.obj[4][25] = new poster3();
        gp.obj[4][25].worldX = 15 * gp.tilesSize;
        gp.obj[4][25].worldY = 14 * gp.tilesSize;
        
        gp.obj[4][26] = new tanaman1();
        gp.obj[4][26].worldX = 9 * gp.tilesSize;
        gp.obj[4][26].worldY = 14 * gp.tilesSize;
        
        gp.obj[4][27] = new tanaman2();
        gp.obj[4][27].worldX = 9 * gp.tilesSize;
        gp.obj[4][27].worldY = 15 * gp.tilesSize;
        
        gp.obj[4][28] = new vend1();
        gp.obj[4][28].worldX = 18 * gp.tilesSize;
        gp.obj[4][28].worldY = 14 * gp.tilesSize;
        
        gp.obj[4][29] = new vend2();
        gp.obj[4][29].worldX = 19 * gp.tilesSize;
        gp.obj[4][29].worldY = 14 * gp.tilesSize;
        
        gp.obj[4][30] = new vend3();
        gp.obj[4][30].worldX = 18 * gp.tilesSize;
        gp.obj[4][30].worldY = 15 * gp.tilesSize;
        
        gp.obj[4][31] = new vend4();
        gp.obj[4][31].worldX = 19 * gp.tilesSize;
        gp.obj[4][31].worldY = 15 * gp.tilesSize;
        
        gp.obj[4][32] = new bed1();
        gp.obj[4][32].worldX = 13 * gp.tilesSize;
        gp.obj[4][32].worldY = 15 * gp.tilesSize;
        
        gp.obj[4][33] = new bed2();
        gp.obj[4][33].worldX = 13 * gp.tilesSize;
        gp.obj[4][33].worldY = 16 * gp.tilesSize;
        
        gp.obj[4][34] = new pc();
        gp.obj[4][34].worldX = 15 * gp.tilesSize;
        gp.obj[4][34].worldY = 15 * gp.tilesSize;
        
        gp.obj[4][35] = new tanaman1();
        gp.obj[4][35].worldX = 20 * gp.tilesSize;
        gp.obj[4][35].worldY = 14 * gp.tilesSize;
        
        gp.obj[4][36] = new tanaman2();
        gp.obj[4][36].worldX = 20 * gp.tilesSize;
        gp.obj[4][36].worldY = 15 * gp.tilesSize;
        
        gp.obj[4][37] = new chair();
        gp.obj[4][37].worldX = 21 * gp.tilesSize;
        gp.obj[4][37].worldY = 18 * gp.tilesSize;
        
        gp.obj[4][38] = new chair();
        gp.obj[4][38].worldX = 21 * gp.tilesSize;
        gp.obj[4][38].worldY = 19 * gp.tilesSize;
        
        gp.obj[4][39] = new chair();
        gp.obj[4][39].worldX = 21 * gp.tilesSize;
        gp.obj[4][39].worldY = 20 * gp.tilesSize;
        
        gp.obj[4][40] = new chair();
        gp.obj[4][40].worldX = 21 * gp.tilesSize;
        gp.obj[4][40].worldY = 21 * gp.tilesSize;
        
        gp.obj[4][41] = new OBJ_Meja2();
        gp.obj[4][41].worldX = 14 * gp.tilesSize;
        gp.obj[4][41].worldY = 17 * gp.tilesSize;
    }
}
