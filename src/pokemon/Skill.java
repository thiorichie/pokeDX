/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokemon;

/**
 *
 * @author Ryu A.H
 */
public class Skill {
    private String nama;
    private int dmg,heal;

    public Skill(String nama, int dmg, int heal) {
        //nanti waktu isi pas new skill tentuin skill nya buat apa dmg ato heal
        // trs diisi salah satu aja yg dipake yg lainnya diisi 0
        //semisal ini skill buat dmg berarti nanti pas isi constructornya ("Poke1",100,0)
        //berlaku kebalikan nya
        this.nama = nama;
        this.dmg = dmg;
        this.heal = heal;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getDmg() {
        return dmg;
    }

    public int getHeal() {
        return heal;
    }

    @Override
    public String toString() {
        //buat tampung string hasil
        String hasil = nama + " ";
        //buat cek ini skill buat heal ato dmg
        if (dmg > 0) {
            hasil+= dmg +" dmg";
        }
        else{
            hasil+= heal + " hp";
        }
        return hasil ;
    }
}
