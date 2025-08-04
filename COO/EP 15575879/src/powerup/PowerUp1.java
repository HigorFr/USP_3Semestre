package powerup;

import entidades.Player;
import java.awt.*;

public class PowerUp1 extends  PowerUp{


    public PowerUp1(double x,double y){
        duracao = 5000;
        angle = (3 * Math.PI) / 2;
        cord_x = x;
        cord_y = y;
        velocity_X = 0.1;
        state = ACTIVE;

    }

    @Override
    public double getRadius() {
        return radius;
    }

    public void aplicar(Player p, long tempoAtual) {
        if (!aplicado) {
            inicio = tempoAtual;
            aplicado = true;


            p.setVelocity_Y(p.getVelocity_Y()*2);
            p.setVelocity_X(p.getVelocity_X()*2);
       }
    }


    public void remover(Player p) {
        p.setVelocity_Y(p.getVelocity_Y()/2);
        p.setVelocity_X(p.getVelocity_X()/2);
        state = INACTIVE;
    }
}
