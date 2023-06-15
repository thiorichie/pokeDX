/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkgPokemon_DX;

import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author WILLIAM
 */
public class EventHandler {

    GamePanel gp;
    eventRect eventrect[][][];

    int previousEventX, previousEventY;
    Random rand = new Random();
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
            //tele map village
            if (hit(0, 17, 10, "any") == true) {
                teleport(1, 7, 13);
            } else if (hit(1, 19, 17, "up") == true) {
                teleport(3, 7, 13);
            } else if (hit(1, 14, 25, "up") == true) {
                teleport(4, 14, 23);
            } else if (hit(4, 14, 23, "down") == true) {
                teleport(1, 14, 25);
            } else if (hit(1, 9, 31, "up") == true) {
                teleport(5, 7, 13);
            } else if (hit(1, 19, 31, "up") == true) {
                teleport(6, 7, 13);
            } else if (hit(1, 19, 31, "up") == true) {
                teleport(6, 7, 13);
            } else if (hit(0, 8, 8, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 8, 9, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 8, 10, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 9, 8, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 9, 9, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 9, 10, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 10, 8, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 10, 9, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 10, 10, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            }  else if (hit(0, 11, 8, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 11, 9, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 11, 10, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            }  else if (hit(0, 12, 8, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 12, 9, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 12, 10, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            }  else if (hit(0, 13, 8, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 13, 9, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 13, 10, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            }  else if (hit(0, 14, 8, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 14, 9, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 14, 10, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            }  else if (hit(0, 15, 8, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 15, 9, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 15, 10, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            }  else if (hit(0, 16, 8, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 16, 9, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 16, 10, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            }  else if (hit(0, 17, 8, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 17, 9, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 17, 10, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            }  else if (hit(0, 18, 8, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 18, 9, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 18, 10, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            }  else if (hit(0, 19, 8, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 19, 9, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 19, 10, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            }  else if (hit(0,20, 8, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 20, 9, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 20, 10, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            }  else if (hit(0, 21, 8, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 21, 9, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 21, 10, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            }  else if (hit(0, 22, 8, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 22, 9, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 22, 10, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            }   else if (hit(0, 24, 22, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 23, 22, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 22, 22, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            }  else if (hit(0, 21, 22, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 20, 22, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 19, 22, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 18, 22, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            }  else if (hit(0, 17, 22, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 16, 22, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 15, 22, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 14, 22, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            }  else if (hit(0, 13, 22, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 12, 22, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 11, 22, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 10, 22, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            }  else if (hit(0, 9, 22, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 8, 22, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 7, 22, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 6, 22, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            }  else if (hit(0, 5, 22, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 4, 22, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 3, 22, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 3, 24, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 3, 25, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 4, 25, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 5, 25, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 6, 25, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 7, 25, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 8, 25, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            }  else if (hit(0, 9, 25, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 10, 25, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 11, 25, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 12, 25, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 13, 25, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 14, 25, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 15, 25, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 16, 25, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 17, 25, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 18, 25, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 19, 25, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 19, 26, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 20, 26, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 21, 26, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 22, 26, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 23, 26, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 24, 26, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 25, 26, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 25, 27, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 25, 28, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 25, 29, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 24, 30, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 25, 30, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 26, 30, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 24, 31, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 25, 31, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 26, 31, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 24, 32, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 25, 32, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 26, 32, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            }  else if (hit(0, 24, 33, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 25, 33, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 26, 33, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 24, 34, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 25, 34, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 26, 34, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 24, 35, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 25, 35, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 26, 35, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 24, 36, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 25, 36, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 26, 36, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 24, 37, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 25, 37, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 26, 37, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 24, 38, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 25, 38, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(0, 26, 38, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
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

//        System.out.println("hit ");
        
        return hit;
    }
    // rusak
//    public int getIndexTile(int map) {
//        if (map == gp.currentMap) {
//            for(int x = 0; x != gp.maksWorldCol; x++) {
//                for(int y = 0; y != gp.maksWorldRow; y++) {
//                    gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
//                    gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
//                    //ngambil solid area eventrect
//                    eventrect[map][x][y].x = x * gp.tilesSize + eventrect[map][x][y].x;
//                    eventrect[map][x][y].y = y * gp.tilesSize + eventrect[map][x][y].y;
//
//                    if (gp.player.solidArea.intersects(eventrect[map][x][y])) {
////                        System.out.println("x : " + x);
////                        System.out.println("y : " + y);
////                        System.out.println("Posisi player di index tile : " + gp.tileManager.mapTileNum[map][x][y]);
//                        System.out.println(gp.tileManager.mapTileNum[map][x][y]);
//                        return gp.tileManager.mapTileNum[map][x][y];
//                    }
//
//                    gp.player.solidArea.x = gp.player.solidAreaDefaultX;
//                    gp.player.solidArea.y = gp.player.solidAreaDefaultY;
//                    eventrect[map][x][y].x = eventrect[map][x][y].eventRectDefaultX;
//                    eventrect[map][x][y].y = eventrect[map][x][y].eventRectDefaultY;
//                }
//            }
//        }
//        return -1;
//    }

    public void teleport(int map, int col, int row) {
        gp.currentMap = map;
        gp.player.worldX = gp.tilesSize * col;
        gp.player.worldY = gp.tilesSize * row;
        previousEventX = gp.player.worldX;
        previousEventY = gp.player.worldY;
        canTouchEvent = false;
    }

    public void battle() {
        gp.gameState = gp.battleState;
        int random_monster_chance = rand.nextInt(1, 10);
        int random_monster_rare = rand.nextInt(8, 11);
        int random_monster_normal = rand.nextInt(3, 6);
        if (random_monster_chance <= 8) {
            gp.ui.poke1 = gp.ui.pokemon.listpokemon.get(random_monster_normal);
        } else if (random_monster_chance >= 9) {
            gp.ui.poke1 = gp.ui.pokemon.listpokemon.get(random_monster_rare);
        }
    }

}
