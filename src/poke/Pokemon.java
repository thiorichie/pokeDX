/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poke;

import java.util.ArrayList;

/**
 *
 * @author Ryu A.H
 */
public class Pokemon {
    public ArrayList<Monster> listpokemon = new ArrayList<>();
    public Monster Charmander = new Monster("Charmander", 200, 200, 1, "/poke/charmander.png");
    public Monster Bulbasour = new Monster("Bulbasour", 200, 200, 1, "/poke/bulbasour.png");
    public Monster Squirtle = new Monster("Squirtle", 200, 200, 1, "/poke/squirtle.png");
    
    //mid mons
    public Monster Axew = new Monster("Axew", 150, 150, 1, "/poke/axew.png");
    public Monster Joltik = new Monster("Joltik", 210, 210, 1, "/poke/Joltik.png");
    public Monster Lairon = new Monster("Lairon", 230, 230, 1, "/poke/Lairon.png");
    public Monster Eve = new Monster("Eve", 220, 220, 1, "/poke/Eve.png");
    public Monster Misdreavus = new Monster("Misdreavus", 230, 230, 1, "/poke/Misdreavus.png");
    
    //high end
    
    public Monster Pikachu = new Monster("Pikachu", 180, 180, 1, "/poke/pikachu.png");
    public Monster Zekrom = new Monster("Zekrom", 310, 310, 1, "/poke/Zekrom.png");
    public Monster Zorua = new Monster("Zorua", 190, 190, 1, "/poke/Zorua.png");
    
    //boss
    public Monster Arceus = new Monster("Arceus", 350, 350, 10, "/poke/arceus.png");

    public Pokemon() {
        Charmander.addSkill(new Skill("Scratch", 40, 0));
        Charmander.addSkill(new Skill("Dragon Tail", 60, 0));
        //sementara
//        Charmander.setCurr_exp(5);
        
        Axew.addSkill(new Skill("Scratch", 40, 0));
        Axew.addSkill(new Skill("Bite", 60, 0));
        
        Joltik.addSkill(new Skill("Absorb", 20, 0));
        Joltik.addSkill(new Skill("Furry Cutter", 40, 0));
        
        Bulbasour.addSkill(new Skill("Tackle", 40, 0));
        Bulbasour.addSkill(new Skill("Vine Whip", 45, 0));
        
        Squirtle.addSkill(new Skill("Tackle", 40, 0));
        Squirtle.addSkill(new Skill("Water Gun", 45, 0));
        
        Lairon.addSkill(new Skill("Tackle", 40, 0));
        Lairon.addSkill(new Skill("Metal Claw", 50, 0));
        Lairon.addSkill(new Skill("Rock Tomb", 60, 0));
        
        Eve.addSkill(new Skill("Tackle", 40, 0));
        Eve.addSkill(new Skill("Covet", 60, 0));
        
        Misdreavus.addSkill(new Skill("Tackle", 40, 0));
        Misdreavus.addSkill(new Skill("Confusion", 50, 0));
        
        Pikachu.addSkill(new Skill("Quick Attack", 40, 0));
        Pikachu.addSkill(new Skill("Thunder Shock", 60, 0));
        
        Zekrom.addSkill(new Skill("Ancient Power", 60, 0));
        Zekrom.addSkill(new Skill("Dragon Breath", 60, 0));
        Zekrom.addSkill(new Skill("Thunder Fang", 65, 0));
        
        Zorua.addSkill(new Skill("Tackle", 40, 0));
        Zorua.addSkill(new Skill("Scratch", 60, 0));
        
        Arceus.addSkill(new Skill("	Earth Power", 90, 0));
        Arceus.addSkill(new Skill("Hyper Voice", 90, 0));
        Arceus.addSkill(new Skill("Extreme Speed", 80, 0));
        Arceus.addSkill(new Skill("Future Sight", 120, 0));
        
        listpokemon.add(Charmander);
        listpokemon.add(Bulbasour);
        listpokemon.add(Squirtle);
        listpokemon.add(Axew);
        listpokemon.add(Joltik);
        listpokemon.add(Lairon);
        listpokemon.add(Eve);
        listpokemon.add(Misdreavus);
        listpokemon.add(Pikachu);
        listpokemon.add(Zekrom);
        listpokemon.add(Zorua);
        listpokemon.add(Arceus);
    }
    
    
    
}
