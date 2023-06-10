/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poke;

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
public class Monster {
    private String nama;
    private int max_hp,hp,max_exp,curr_exp,lvl;
    private boolean alive;
    private BufferedImage character; 
    public ArrayList<Skill> skill = new ArrayList<>();

    public Monster(String nama, int max_hp, int hp, int lvl, String char_path) {
        this.nama = nama;
        this.max_hp = max_hp;
        this.hp = hp;
        this.curr_exp = 0;
        this.max_exp = lvl*10;
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
            Logger.getLogger(Monster.class.getName()).log(Level.SEVERE, null, ex);
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
        if (hp==0) {
            alive = false;
        }
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
    
    public void levelUp(){
        if (alive) {
            lvl+=1;
            max_hp+=50;
            hp = max_hp;
            curr_exp = 0;
            max_exp = lvl*10;
        }
        
    }

    public int getMax_exp() {
        return max_exp;
    }

    public void setMax_exp(int max_exp) {
        this.max_exp = max_exp;
    }

    public int getCurr_exp() {
        return curr_exp;
    }

    public void setCurr_exp(int curr_exp) {
        this.curr_exp = curr_exp;
    }
    
    

    @Override
    public String toString() {
        return "Pokemon " + nama + ", max_hp=" + max_hp + ", hp=" + hp + ", curr_exp=" + curr_exp + ", lvl=" + lvl + ". ";
    }
    
}
