package projéteis;
import gamelib.GameLib;
import controle.Contexto;
import java.awt.Color;

public class EProjetil extends Projetil{



    public EProjetil(){
        radius = 2.0;
        state = ACTIVE;
    } 

    @Override



    public void update(Contexto ctx){
        if(state == ACTIVE){
            updateMove(ctx);

            GameLib.setColor(Color.RED);
            GameLib.drawCircle(cord_x, cord_y, radius);
        }
    }
}