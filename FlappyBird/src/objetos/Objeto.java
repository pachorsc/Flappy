package objetos;

import java.awt.Color;

public class Objeto {
    int height;
    int with;
    Color color;
    
    public Objeto(int alt, int anch, Color col){
        this.height = alt;
        this.with = anch;
        this.color = col;
    }
}
