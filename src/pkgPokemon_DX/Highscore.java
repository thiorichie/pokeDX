/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkgPokemon_DX;

/**
 *
 * @author rici
 */
public class Highscore<T> {
    T highScoreValue;

    public T getHighScoreValue() {
        return highScoreValue;
    }

    public void setHighScoreValue(T highScoreValue) {
        this.highScoreValue = highScoreValue;
    }
    
    public void printHighScore() {
        if(highScoreValue instanceof Integer) {
//            KETIKA ANGKA
        } else {
//            KETIKA WAKTU
        }
    }
}
