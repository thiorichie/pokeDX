/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poke;

/**
 *
 * @author Ryu A.H
 */
public class Pokemon {
    public Monster Charmander = new Monster("Charmander", 200, 200, 20, 1, "/poke/charmander.png");
    public Monster Bulbasour = new Monster("Bulbasour", 200, 200, 20, 1, "/poke/bulbasour.png");
    public Monster Squirtle = new Monster("Squirtle", 200, 200, 20, 1, "/poke/squirtle.png");
    
    //mid mons
    public Monster Axew = new Monster("Axew", 150, 150, 30, 1, "/poke/axew.png");
    public Monster Joltik = new Monster("Joltik", 150, 150, 30, 1, "/poke/Joltik.png");
    public Monster Lairon = new Monster("Lairon", 150, 150, 30, 1, "/poke/Lairon.png");
    public Monster Eve = new Monster("Eve", 175, 175, 30, 1, "/poke/Eve.png");
    public Monster Misdreavus = new Monster("Misdreavus", 150, 150, 30, 1, "/poke/Misdreavus.png");
    
    //high end
    
    public Monster Pikachu = new Monster("Pikachu", 500, 500, 75, 1, "/poke/pikachu.png");
    public Monster Zekrom = new Monster("Zekrom", 1000, 1000, 100, 1, "/poke/Zekrom.png");
    public Monster Zorua = new Monster("Zorua", 650, 650, 65, 1, "/poke/Zorua.png");
    
    //boss
    public Monster Arceus = new Monster("Arceus", 3000, 3000, 500, 10, "/poke/arceus.png");

    public Pokemon() {
        Charmander.addSkill(new Skill("Scratch", 40, 0));
        Charmander.addSkill(new Skill("Dragon Tail", 60, 0));
        
        Axew.addSkill(new Skill("Scratch", 40, 0));
        Axew.addSkill(new Skill("Bite", 60, 0));
        
    }
    
    
    
}
