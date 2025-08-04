package powerup;

import entidades.Player;
import java.awt.*;

public class PowerUp2 extends  PowerUp{

    public PowerUp2(double x,double y){
        duracao = 8000;
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

            p.setCor(Color.cyan);
            p.setShootcooldown(10);
        }
    }


    public void remover(Player p) {
        p.setShootcooldown(100);
        state = INACTIVE;
    }

}
