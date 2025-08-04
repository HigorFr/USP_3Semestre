package background;

import entidades.Movel;
import controle.Contexto;
import gamelib.GameLib;

import java.awt.*;

public class EstrelaTras extends Movel{

    private  static double count = 0.0;


    public EstrelaTras(){
        cord_x = Math.random() * GameLib.WIDTH;
        cord_y = Math.random() * GameLib.HEIGHT;
        velocity_X = 0.0045;
    }


    public void update(Contexto ctx){
        GameLib.setColor(Color.DARK_GRAY);
        long delta = ctx.getDelta();
        count += velocity_X * delta;
        GameLib.fillRect(cord_x, (cord_y + count) % ctx.getHEIGHT(), 2, 2);

    }
}