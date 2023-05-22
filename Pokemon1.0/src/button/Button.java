/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package button;
import java.awt.Font;
import java.awt.event.MouseEvent;

/**
 *
 * @author thior
 */
public abstract class Button {
    protected int x, y, width, height;
    protected boolean enabled, pressed;
    
    protected String text;
    final Font font = new Font("Vedana", Font.PLAIN, 14);
    ActionListener listener;
    
    public Button(ActionListener listener, String text, int x, int y, int width, int height){
        this.listener = listener;
    }
}
