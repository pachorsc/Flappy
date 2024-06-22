package objetos;

import java.awt.Color;

public class Tubo extends Objeto {
    public Tubo(){
        super((int) (Math.random() * 300) + 1, 50 , Color.green);
    }
    
}
