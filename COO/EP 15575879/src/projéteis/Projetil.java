package projéteis;
import entidades.Entidade;
import controle.Contexto;

public abstract class Projetil extends Entidade{   



    double radius;

    public double getRadius() {
        return radius;
    }

    public void updateMove(Contexto ctx){
        long delta = ctx.getDelta();
        long Maxheight = ctx.getHEIGHT();


        if(cord_y < 0 || cord_y > Maxheight) {

            state = INACTIVE;
        }
        else {

            cord_x += velocity_X * delta;
            cord_y += velocity_Y * delta;
        }
    }
}






