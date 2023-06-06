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
        loadMap("/maps/Village.txt",1);
        loadMap("/maps/Rumah1.txt",2);
        loadMap("/maps/Rumah2.txt",3);
<<<<<<< Updated upstream
=======
        loadMap("/maps/protomap002.txt",1);
        loadMap("/maps/Village.txt", 2);
>>>>>>> Stashed changes
    }
    
    public void getTileImage(){
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
            
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tanah.png"));
            
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
            tile[7].collision = true;
            
            tile[8] = new Tile();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("/rumah/2.png"));
            tile[8].collision = true;
            
            tile[9] = new Tile();
            tile[9].image = ImageIO.read(getClass().getResourceAsStream("/rumah/3.png"));
            tile[9].collision = true;
            
            tile[10] = new Tile();
            tile[10].image = ImageIO.read(getClass().getResourceAsStream("/rumah/4.png"));
            tile[10].collision = true;
            
            tile[11] = new Tile();
            tile[11].image = ImageIO.read(getClass().getResourceAsStream("/rumah/5.png"));
            tile[11].collision = true;
            
            tile[12] = new Tile();
            tile[12].image = ImageIO.read(getClass().getResourceAsStream("/rumah/6.png"));
            tile[12].collision = true;
            
            tile[13] = new Tile();
            tile[13].image = ImageIO.read(getClass().getResourceAsStream("/rumah/7.png"));
            tile[13].collision = true;
            
            tile[14] = new Tile();
            tile[14].image = ImageIO.read(getClass().getResourceAsStream("/rumah/8.png"));
            
            tile[15] = new Tile();
            tile[15].image = ImageIO.read(getClass().getResourceAsStream("/rumah/9.png"));
            tile[15].collision = true;
            
            tile[16] = new Tile();
            tile[16].image = ImageIO.read(getClass().getResourceAsStream("/rumah1/1.png"));
            tile[16].collision = true;
            
            tile[17] = new Tile();
            tile[17].image = ImageIO.read(getClass().getResourceAsStream("/rumah1/2.png"));
            tile[17].collision = true;
            
            tile[18] = new Tile();
            tile[18].image = ImageIO.read(getClass().getResourceAsStream("/rumah1/3.png"));
            tile[18].collision = true;
            
            tile[19] = new Tile();
            tile[19].image = ImageIO.read(getClass().getResourceAsStream("/rumah1/4.png"));
            tile[19].collision = true;
            
            tile[20] = new Tile();
            tile[20].image = ImageIO.read(getClass().getResourceAsStream("/rumah1/5.png"));
            tile[20].collision = true;
            
            tile[21] = new Tile();
            tile[21].image = ImageIO.read(getClass().getResourceAsStream("/rumah1/6.png"));
            tile[21].collision = true;
            
            tile[22] = new Tile();
            tile[22].image = ImageIO.read(getClass().getResourceAsStream("/rumah1/7.png"));
            tile[22].collision = true;
            
            tile[23] = new Tile();
            tile[23].image = ImageIO.read(getClass().getResourceAsStream("/rumah1/8.png"));
            
            tile[24] = new Tile();
            tile[24].image = ImageIO.read(getClass().getResourceAsStream("/rumah1/9.png"));
            tile[24].collision = true;
<<<<<<< Updated upstream
=======

            
>>>>>>> Stashed changes
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
