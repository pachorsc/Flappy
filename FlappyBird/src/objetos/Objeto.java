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

    public int getHeight() {
        return height;
    }

    public int getWith() {
        return with;
    }

    public Color getColor() {
        return color;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
}
