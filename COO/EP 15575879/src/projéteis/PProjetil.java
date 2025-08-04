package projéteis;
import gamelib.GameLib;
import controle.Contexto;
import java.awt.Color;


public class PProjetil extends Projetil{


    public PProjetil(){
        this.state = ACTIVE;
        radius = 1.0;
    }

    @Override


    public void update(Contexto ctx){

        if(state == ACTIVE){

            updateMove(ctx);

            GameLib.setColor(Color.GREEN);
            GameLib.drawLine(cord_x, cord_y - 5, cord_x, cord_y + 5);
            GameLib.drawLine(cord_x - 1, cord_y - 3, cord_x - 1, cord_y + 3);
            GameLib.drawLine(cord_x + 1, cord_y - 3, cord_x + 1, cord_y + 3);
        }
    }
}