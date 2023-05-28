/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import pkgPokemon_DX.GamePanel;

/**
 *
 * @author thior
 */
public class SuperObject {
    
    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int worldX, worldY;
    public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;
    
    public void draw(Graphics2D g2, GamePanel gp){
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;
            
        if (worldX + gp.tilesSize > gp.player.worldX - gp.player.screenX &&
            worldX - gp.tilesSize < gp.player.worldX + gp.player.screenX &&
            worldY + gp.tilesSize > gp.player.worldY - gp.player.screenY &&
            worldY - gp.tilesSize < gp.player.worldY + gp.player.screenY){
            g2.drawImage(image, screenX, screenY, gp.tilesSize, gp.tilesSize, null);
        }
    }
}
