/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokemon1.pkg0;
import javax.swing.JFrame;
/**
 *
 * @author thior
 */
public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setSize(1280, 720);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("PokeDX - Pokemon Black & White: The Legend of Arceus");
        
        GamePanel gpanel = new GamePanel();
        window.add(gpanel);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        gpanel.startGameThread();
    }
}
