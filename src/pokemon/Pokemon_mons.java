/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokemon;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Ryu A.H
 */
public class Pokemon_mons {
    private String nama;
    private int max_hp,hp,atk,lvl;
    private boolean alive;
    private BufferedImage character; 
    private ArrayList<Skill> skill = new ArrayList<>();

    public Pokemon_mons(String nama, int max_hp, int hp, int atk, int lvl, String char_path) {
        this.nama = nama;
        this.max_hp = max_hp;
        this.hp = hp;
        this.atk = atk;
        this.lvl = lvl;
        alive = true;
        setCharacter(char_path);
    }

    public BufferedImage getCharacter() {
        return character;
    }

    private void setCharacter(String path) {
        try {
            this.character = ImageIO.read(getClass().getResourceAsStream(path));
        } catch (IOException ex) {
            Logger.getLogger(Pokemon_mons.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addSkill(Skill newSkill){
        skill.add(newSkill);
    }
    
    public void printSkill(){
        for (Skill s : skill) {
            System.out.println(s);
        }
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getMax_hp() {
        return max_hp;
    }

    public void setMax_hp(int max_hp) {
        this.max_hp = max_hp;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }
    
    public boolean getStatus(){
        return alive;
    }
    
    public void revive(int hp){
        if (!alive) {
            this.hp = hp;
            alive = true;
            System.out.println("Revive success!");
        }
        else{
            System.out.println("You cannot revive");
        }
    }

    @Override
    public String toString() {
        return "Pokemon{" + "nama=" + nama + ", max_hp=" + max_hp + ", hp=" + hp + ", atk=" + atk + ", lvl=" + lvl + " ";
    }
    
}
