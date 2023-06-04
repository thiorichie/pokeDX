/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkgPokemon_DX;

import java.awt.Rectangle;

/**
 *
 * @author WILLIAM
 */
public class EventHandler {

    GamePanel gp;
    eventRect eventrect[][][];

    int previousEventX, previousEventY;
    boolean canTouchEvent = true;

    public EventHandler(GamePanel gp) {
        this.gp = gp;

        eventrect = new eventRect[gp.maksMap][gp.maksWorldCol][gp.maksWorldRow];

        int map = 0;
        int col = 0;
        int row = 0;

        while (map < gp.maksMap && col < gp.maksWorldCol && row < gp.maksWorldRow) {
            eventrect[map][col][row] = new eventRect();
            eventrect[map][col][row].x = 23;
            eventrect[map][col][row].y = 23;
            eventrect[map][col][row].width = 2;
            eventrect[map][col][row].height = 2;
            eventrect[map][col][row].eventRectDefaultX = eventrect[map][col][row].x;
            eventrect[map][col][row].eventRectDefaultY = eventrect[map][col][row].y;

            col++;
            if (col == gp.maksWorldCol) {
                col = 0;
                row++;

                if (row == gp.maksWorldRow) {
                    row = 0;
                    map++;
                }
            }
        }

    }

    public void checkEvent() {
        // cek apabila player sudah lewat 1 tile di event sebelumnya
        int xDistance = Math.abs(gp.player.worldX - previousEventX);
        int yDistance = Math.abs(gp.player.worldY - previousEventY);
        int distance = Math.max(xDistance, yDistance);
        if (distance > gp.tilesSize) {
            canTouchEvent = true;
        }

        if (canTouchEvent == true) {
            //event
            if (hit(0,17,10,"any") == true) {
                teleport(2,7,14);
            }
            else if (hit(1,20,10,"any") == true) {
                teleport(2,7, 14);
            }else if (hit(2,11,17,"up") == true) {
                teleport(0,17,10);
            }
        }
    }

    public boolean hit(int map, int col, int row, String reqDirection) {

        boolean hit = false;

        if (map == gp.currentMap) {
            gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
            gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
            //ngambil solid area eventrect
            eventrect[map][col][row].x = col * gp.tilesSize + eventrect[map][col][row].x;
            eventrect[map][col][row].y = row * gp.tilesSize + eventrect[map][col][row].y;

            if (gp.player.solidArea.intersects(eventrect[map][col][row]) && eventrect[map][col][row].eventDone == false) {
                if (gp.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any")) {
                    hit = true;

                    previousEventX = gp.player.worldX;
                    previousEventY = gp.player.worldY;
                }
            }

            gp.player.solidArea.x = gp.player.solidAreaDefaultX;
            gp.player.solidArea.y = gp.player.solidAreaDefaultY;
            eventrect[map][col][row].x = eventrect[map][col][row].eventRectDefaultX;
            eventrect[map][col][row].y = eventrect[map][col][row].eventRectDefaultY;
        }

        return hit;
    }

    public void teleport(int map,int col,int row) {
        gp.currentMap = map;
        gp.player.worldX = gp.tilesSize * col;
        gp.player.worldY = gp.tilesSize * row;
        previousEventX = gp.player.worldX;
        previousEventY = gp.player.worldY;
        canTouchEvent = false;
    }

}
