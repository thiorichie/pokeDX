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
            if (hit(0, 14, 13, "any") == true) {
                teleport(1, 2, 4);
            }else if (hit(1, 2, 4, "any") == true) {
                teleport(0, 14, 13);
            } else if (hit(0, 14, 25, "up") == true) {
                teleport(4, 14, 23);
            } else if (hit(4, 14, 23, "any") == true) {
                teleport(0, 14, 25);
            } else if (hit(1, 8, 8, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 8, 9, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 8, 10, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 9, 8, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 9, 9, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 9, 10, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 10, 8, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 10, 9, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 10, 10, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            }  else if (hit(1, 11, 8, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 11, 9, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 11, 10, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            }  else if (hit(1, 12, 8, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 12, 9, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 12, 10, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            }  else if (hit(1, 13, 8, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 13, 9, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 13, 10, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            }  else if (hit(1, 14, 8, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 14, 9, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 14, 10, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            }  else if (hit(1, 15, 8, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 15, 9, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 15, 10, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            }  else if (hit(1, 16, 8, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 16, 9, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 16, 10, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            }  else if (hit(1, 17, 8, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 17, 9, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 17, 10, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            }  else if (hit(1, 18, 8, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 18, 9, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 18, 10, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            }  else if (hit(1, 19, 8, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 19, 9, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 19, 10, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            }  else if (hit(1,20, 8, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 20, 9, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 20, 10, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            }  else if (hit(1, 21, 8, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 21, 9, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 21, 10, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            }  else if (hit(1, 22, 8, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 22, 9, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 22, 10, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            }   else if (hit(1, 24, 22, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 23, 22, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 22, 22, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            }  else if (hit(1, 21, 22, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 20, 22, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 19, 22, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 18, 22, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            }  else if (hit(1, 17, 22, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 16, 22, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 15, 22, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 14, 22, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            }  else if (hit(1, 13, 22, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 12, 22, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 11, 22, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 10, 22, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            }  else if (hit(1, 9, 22, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 8, 22, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 7, 22, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 6, 22, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            }  else if (hit(1, 5, 22, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 4, 22, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 3, 22, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 3, 24, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 3, 25, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 4, 25, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 5, 25, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 6, 25, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 7, 25, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 8, 25, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            }  else if (hit(1, 9, 25, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 10, 25, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 11, 25, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 12, 25, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 13, 25, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 14, 25, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 15, 25, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 16, 25, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 17, 25, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1,18, 25, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 19, 25, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 19, 26, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 20, 26, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 21, 26, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 22, 26, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 23, 26, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 24, 26, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 25, 26, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 25, 27, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 25, 28, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1,25, 29, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 24, 30, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 25, 30, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1,26, 30, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 24, 31, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 25, 31, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 26, 31, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 24, 32, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 25, 32, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 26, 32, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            }  else if (hit(1, 24, 33, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1,25, 33, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 26, 33, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 24, 34, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 25, 34, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 26, 34, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 24, 35, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 25, 35, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 26, 35, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 24, 36, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 25, 36, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 26, 36, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 24, 37, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 25, 37, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 26, 37, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 26, 38, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 16, 33, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            }  else if (hit(1, 17, 33, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 18, 33, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 16, 34, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 16, 33, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 16, 32, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 16, 31, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 10, 38, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 10, 37, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 10, 36, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 10, 35, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 10, 34, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 9, 34, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 8, 34, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 7, 34, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 6, 34, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 5, 34, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 4, 34, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 13, 48, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 14, 48, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 15, 48, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 16, 48, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 17, 48, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 18, 48, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 19, 48, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 20, 48, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 21, 48, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 22, 48, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 23, 48, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 24, 48, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 25, 48, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 25, 49, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 25, 50, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 25, 51, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 25, 52, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 25, 53, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 25, 54, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 13, 49, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 13, 50, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 13, 51, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 13, 52, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 13, 53, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 13, 54, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 13, 54, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 14, 54, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 15, 54, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 16, 54, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 17, 54, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 18, 54, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 19, 54, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 20, 54, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 21, 54, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 22, 54, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 23, 54, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 24, 54, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 17, 56, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 19, 56, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 20, 56, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 18, 56, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 21, 56, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 17, 57, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 19, 57, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 20, 57, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 18, 57, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 21, 57, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 17, 58, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 19, 58, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 20, 58, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 18, 58, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 21, 58, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 17, 59, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 19, 59, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 20, 59, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 18, 59, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 21, 59, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 17, 60, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 19, 60, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 20, 60, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 18, 60, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 21, 60, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 17, 61, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 19, 61, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 20, 61, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 18, 61, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 21, 61, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 12, 64, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1,13, 64, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 14, 64, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 15, 64, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 16, 64, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 12, 65, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1,13, 65, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 14, 65, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 15, 65, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 16, 65, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 12, 66, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 13, 66, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 14, 66, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 15, 66, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 16, 66, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 12, 67, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 13, 67, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 14, 67, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 15, 67, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 16, 67, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 12, 68, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 13, 68, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 14, 68, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 15, 68, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 16, 68, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 12, 69, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 13, 69, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 14, 69, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 15, 69, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 16, 69, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 23, 74, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 24, 74, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 25, 74, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 26, 74, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 27, 74, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 23, 75, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 24, 75, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 25, 75, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 26, 75, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 27, 75, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 23, 76, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 24, 76, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 25, 76, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 26, 76, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 27, 76, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 23, 77, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 24, 77, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 25, 77, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 26, 77, "any") == true) {
                int random_battle = rand.nextInt(1,101);
                if (random_battle == 69) {
                    battle();
                }
            } else if (hit(1, 27, 77, "any") == true) {
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
            canTouchEvent = false;
        } else if (random_monster_chance >= 9) {
            gp.ui.poke1 = gp.ui.pokemon.listpokemon.get(random_monster_rare);
            canTouchEvent = false;
        }
    }

}
