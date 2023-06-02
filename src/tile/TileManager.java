/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;
import pkgPokemon_DX.GamePanel;

/**
 *
 * @author thior
 */
public class TileManager {
    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][][];
    
    public TileManager(GamePanel gp){
        this.gp = gp;
        
        tile = new Tile[200];
        mapTileNum = new int [gp.maksMap][gp.maksWorldCol][gp.maksWorldRow];
        getTileImage();
        loadMap("/maps/protomap001.txt",0);
        loadMap("/maps/protomap002.txt",1);
    }
    
    public void getTileImage(){
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
            
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
            tile[1].collision = true;
            
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water.png"));
            tile[2].collision = true;
            
            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/earth.png"));
            
            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tree.png"));
            tile[4].collision = true;
            
            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sand.png"));
            
            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/objects/door.png"));
            
            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/rumah/1.png"));
            
            tile[8] = new Tile();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("/rumah/2.png"));
            
            tile[9] = new Tile();
            tile[9].image = ImageIO.read(getClass().getResourceAsStream("/rumah/3.png"));
            
            tile[10] = new Tile();
            tile[10].image = ImageIO.read(getClass().getResourceAsStream("/rumah/4.png"));
            
            tile[11] = new Tile();
            tile[11].image = ImageIO.read(getClass().getResourceAsStream("/rumah/5.png"));
            
            tile[12] = new Tile();
            tile[12].image = ImageIO.read(getClass().getResourceAsStream("/rumah/6.png"));
            
            tile[13] = new Tile();
            tile[13].image = ImageIO.read(getClass().getResourceAsStream("/rumah/7.png"));
            
            tile[14] = new Tile();
            tile[14].image = ImageIO.read(getClass().getResourceAsStream("/rumah/8.png"));
            
            tile[15] = new Tile();
            tile[15].image = ImageIO.read(getClass().getResourceAsStream("/rumah/9.png"));
            
            tile[16] = new Tile();
            tile[16].image = ImageIO.read(getClass().getResourceAsStream("/indoor/1.png"));
            
            tile[17] = new Tile();
            tile[17].image = ImageIO.read(getClass().getResourceAsStream("/indoor/2.png"));
            
            tile[18] = new Tile();
            tile[18].image = ImageIO.read(getClass().getResourceAsStream("/indoor/3.png"));
            
            tile[19] = new Tile();
            tile[19].image = ImageIO.read(getClass().getResourceAsStream("/indoor/4.png"));
            
            tile[20] = new Tile();
            tile[20].image = ImageIO.read(getClass().getResourceAsStream("/indoor/5.png"));
            
            tile[21] = new Tile();
            tile[21].image = ImageIO.read(getClass().getResourceAsStream("/indoor/6.png"));
            
            tile[22] = new Tile();
            tile[22].image = ImageIO.read(getClass().getResourceAsStream("/indoor/7.png"));
            
            tile[23] = new Tile();
            tile[23].image = ImageIO.read(getClass().getResourceAsStream("/indoor/8.png"));
            
            tile[24] = new Tile();
            tile[24].image = ImageIO.read(getClass().getResourceAsStream("/indoor/9.png"));
            
            tile[25] = new Tile();
            tile[25].image = ImageIO.read(getClass().getResourceAsStream("/indoor/10.png"));
            
            tile[26] = new Tile();
            tile[26].image = ImageIO.read(getClass().getResourceAsStream("/indoor/11.png"));
            
            tile[27] = new Tile();
            tile[27].image = ImageIO.read(getClass().getResourceAsStream("/indoor/12.png"));
            
            tile[28] = new Tile();
            tile[28].image = ImageIO.read(getClass().getResourceAsStream("/indoor/13.png"));
            
            tile[29] = new Tile();
            tile[29].image = ImageIO.read(getClass().getResourceAsStream("/indoor/14.png"));
            
            tile[30] = new Tile();
            tile[30].image = ImageIO.read(getClass().getResourceAsStream("/indoor/15.png"));
            
            tile[31] = new Tile();
            tile[31].image = ImageIO.read(getClass().getResourceAsStream("/indoor/16.png"));
            
            tile[32] = new Tile();
            tile[32].image = ImageIO.read(getClass().getResourceAsStream("/indoor/17.png"));
            
            tile[33] = new Tile();
            tile[33].image = ImageIO.read(getClass().getResourceAsStream("/indoor/18.png"));
            
            tile[34] = new Tile();
            tile[34].image = ImageIO.read(getClass().getResourceAsStream("/indoor/19.png"));
            
            tile[35] = new Tile();
            tile[35].image = ImageIO.read(getClass().getResourceAsStream("/indoor/20.png"));
            
            tile[36] = new Tile();
            tile[36].image = ImageIO.read(getClass().getResourceAsStream("/indoor/21.png"));
            
            tile[37] = new Tile();
            tile[37].image = ImageIO.read(getClass().getResourceAsStream("/indoor/22.png"));
            
            tile[38] = new Tile();
            tile[38].image = ImageIO.read(getClass().getResourceAsStream("/indoor/23.png"));
            
            tile[39] = new Tile();
            tile[39].image = ImageIO.read(getClass().getResourceAsStream("/indoor/24.png"));
            
            tile[40] = new Tile();
            tile[40].image = ImageIO.read(getClass().getResourceAsStream("/indoor/25.png"));
            
            tile[41] = new Tile();
            tile[41].image = ImageIO.read(getClass().getResourceAsStream("/indoor/26.png"));
            
            tile[42] = new Tile();
            tile[42].image = ImageIO.read(getClass().getResourceAsStream("/indoor/27.png"));
            
            tile[43] = new Tile();
            tile[43].image = ImageIO.read(getClass().getResourceAsStream("/indoor/28.png"));
            
            tile[44] = new Tile();
            tile[44].image = ImageIO.read(getClass().getResourceAsStream("/indoor/29.png"));
            
            tile[45] = new Tile();
            tile[45].image = ImageIO.read(getClass().getResourceAsStream("/indoor/30.png"));
            
            tile[46] = new Tile();
            tile[46].image = ImageIO.read(getClass().getResourceAsStream("/indoor/31.png"));
            
            tile[47] = new Tile();
            tile[47].image = ImageIO.read(getClass().getResourceAsStream("/indoor/32.png"));
            
            tile[48] = new Tile();
            tile[48].image = ImageIO.read(getClass().getResourceAsStream("/indoor/33.png"));
            
            tile[49] = new Tile();
            tile[49].image = ImageIO.read(getClass().getResourceAsStream("/indoor/34.png"));
            
            tile[50] = new Tile();
            tile[50].image = ImageIO.read(getClass().getResourceAsStream("/indoor/35.png"));
            
            tile[51] = new Tile();
            tile[51].image = ImageIO.read(getClass().getResourceAsStream("/indoor/36.png"));
            
            tile[52] = new Tile();
            tile[52].image = ImageIO.read(getClass().getResourceAsStream("/indoor/37.png"));
            
            tile[53] = new Tile();
            tile[53].image = ImageIO.read(getClass().getResourceAsStream("/indoor/38.png"));
            
            tile[54] = new Tile();
            tile[54].image = ImageIO.read(getClass().getResourceAsStream("/indoor/39.png"));
            
            tile[55] = new Tile();
            tile[55].image = ImageIO.read(getClass().getResourceAsStream("/indoor/40.png"));
            
            tile[56] = new Tile();
            tile[56].image = ImageIO.read(getClass().getResourceAsStream("/indoor/41.png"));
            
            tile[57] = new Tile();
            tile[57].image = ImageIO.read(getClass().getResourceAsStream("/indoor/42.png"));
            
            tile[58] = new Tile();
            tile[58].image = ImageIO.read(getClass().getResourceAsStream("/indoor/43.png"));
            
            tile[59] = new Tile();
            tile[59].image = ImageIO.read(getClass().getResourceAsStream("/indoor/44.png"));
            
            tile[60] = new Tile();
            tile[60].image = ImageIO.read(getClass().getResourceAsStream("/indoor/45.png"));
            
            tile[61] = new Tile();
            tile[61].image = ImageIO.read(getClass().getResourceAsStream("/indoor/46.png"));
            
            tile[62] = new Tile();
            tile[62].image = ImageIO.read(getClass().getResourceAsStream("/indoor/47.png"));
            
            tile[63] = new Tile();
            tile[63].image = ImageIO.read(getClass().getResourceAsStream("/indoor/48.png"));
            
            tile[64] = new Tile();
            tile[64].image = ImageIO.read(getClass().getResourceAsStream("/indoor/49.png"));
            
            tile[65] = new Tile();
            tile[65].image = ImageIO.read(getClass().getResourceAsStream("/indoor/50.png"));
            
            tile[66] = new Tile();
            tile[66].image = ImageIO.read(getClass().getResourceAsStream("/indoor/51.png"));
            
            tile[67] = new Tile();
            tile[67].image = ImageIO.read(getClass().getResourceAsStream("/indoor/52.png"));
            
            tile[68] = new Tile();
            tile[68].image = ImageIO.read(getClass().getResourceAsStream("/indoor/53.png"));
            
            tile[69] = new Tile();
            tile[69].image = ImageIO.read(getClass().getResourceAsStream("/indoor/54.png"));
            
            tile[70] = new Tile();
            tile[70].image = ImageIO.read(getClass().getResourceAsStream("/indoor/55.png"));
            
            tile[71] = new Tile();
            tile[71].image = ImageIO.read(getClass().getResourceAsStream("/indoor/56.png"));
            
            tile[72] = new Tile();
            tile[72].image = ImageIO.read(getClass().getResourceAsStream("/indoor/57.png"));
            
            tile[73] = new Tile();
            tile[73].image = ImageIO.read(getClass().getResourceAsStream("/indoor/58.png"));
            
            tile[74] = new Tile();
            tile[74].image = ImageIO.read(getClass().getResourceAsStream("/indoor/59.png"));
            
            tile[75] = new Tile();
            tile[75].image = ImageIO.read(getClass().getResourceAsStream("/indoor/60.png"));
            
            tile[76] = new Tile();
            tile[76].image = ImageIO.read(getClass().getResourceAsStream("/indoor/61.png"));
            
            tile[77] = new Tile();
            tile[77].image = ImageIO.read(getClass().getResourceAsStream("/indoor/62.png"));
            
            tile[78] = new Tile();
            tile[78].image = ImageIO.read(getClass().getResourceAsStream("/indoor/63.png"));
            
            tile[79] = new Tile();
            tile[79].image = ImageIO.read(getClass().getResourceAsStream("/indoor/64.png"));
            
            tile[80] = new Tile();
            tile[80].image = ImageIO.read(getClass().getResourceAsStream("/indoor/65.png"));
            
            tile[81] = new Tile();
            tile[81].image = ImageIO.read(getClass().getResourceAsStream("/indoor/66.png"));
            
            tile[82] = new Tile();
            tile[82].image = ImageIO.read(getClass().getResourceAsStream("/indoor/67.png"));
            
            tile[83] = new Tile();
            tile[83].image = ImageIO.read(getClass().getResourceAsStream("/indoor/68.png"));
            
            tile[84] = new Tile();
            tile[84].image = ImageIO.read(getClass().getResourceAsStream("/indoor/69.png"));
            
            tile[85] = new Tile();
            tile[85].image = ImageIO.read(getClass().getResourceAsStream("/indoor/70.png"));
            
            tile[86] = new Tile();
            tile[86].image = ImageIO.read(getClass().getResourceAsStream("/indoor/71.png"));
            
            tile[87] = new Tile();
            tile[87].image = ImageIO.read(getClass().getResourceAsStream("/indoor/72.png"));
            
            tile[88] = new Tile();
            tile[88].image = ImageIO.read(getClass().getResourceAsStream("/indoor/73.png"));
            
            tile[89] = new Tile();
            tile[89].image = ImageIO.read(getClass().getResourceAsStream("/indoor/74.png"));
            
            tile[90] = new Tile();
            tile[90].image = ImageIO.read(getClass().getResourceAsStream("/indoor/75.png"));
            
            tile[91] = new Tile();
            tile[91].image = ImageIO.read(getClass().getResourceAsStream("/indoor/76.png"));
            
            tile[92] = new Tile();
            tile[92].image = ImageIO.read(getClass().getResourceAsStream("/indoor/77.png"));
            
            tile[93] = new Tile();
            tile[93].image = ImageIO.read(getClass().getResourceAsStream("/indoor/78.png"));
            
            tile[94] = new Tile();
            tile[94].image = ImageIO.read(getClass().getResourceAsStream("/indoor/79.png"));
            
            tile[95] = new Tile();
            tile[95].image = ImageIO.read(getClass().getResourceAsStream("/indoor/80.png"));
            
            
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public void loadMap(String filePath,int map){
        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            
            int col = 0;
            int row = 0;
            
            while (col < gp.maksWorldCol && row < gp.maksWorldRow){
                String line = br.readLine();
                
                while (col < gp.maksWorldCol){
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[map][col][row] = num;
                    col++;
                }
                if (col == gp.maksWorldCol){
                    col = 0;
                    row++;
                }
            }
            br.close();
        }
        catch (Exception e) {
            
        }
    }
    
    public void draw(Graphics2D g2){
        int worldCol = 0;
        int worldRow = 0;
        
        while (worldCol < gp.maksWorldCol && worldRow < gp.maksWorldRow){
            int tileNum = mapTileNum[gp.currentMap][worldCol][worldRow];
            
            int worldX = worldCol * gp.tilesSize;
            int worldY = worldRow * gp.tilesSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;
            
            if (worldX + gp.tilesSize > gp.player.worldX - gp.player.screenX &&
                worldX - gp.tilesSize < gp.player.worldX + gp.player.screenX &&
                worldY + gp.tilesSize > gp.player.worldY - gp.player.screenY &&
                worldY - gp.tilesSize < gp.player.worldY + gp.player.screenY){
                g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tilesSize, gp.tilesSize, null);
            }
            worldCol++;
            
            if (worldCol == gp.maksWorldCol){
                worldCol = 0;
                worldRow++;
            }
        }
    }
}
