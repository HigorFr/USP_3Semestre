package inimigos;

import projéteis.EProjetil;
import projéteis.Projetil;
import controle.Contexto;
import gamelib.GameLib;
import java.awt.Color;


public class Inimigo1 extends Inimigo {

    static double radius = 9.0;

    public Inimigo1(long currentTime, double x, double y){
        cord_x = x;
        cord_y = y;
        velocity_X = 0.2 + Math.random() * 0.15;
        angle = (3 * Math.PI) / 2;
        RV = 0.0;
        state = ACTIVE;
        nextShoot = currentTime + 500;

    }

    public double getRadius() {return radius;}
    


    public void update(Contexto ctx){

        long tempoAtual = ctx.getCurrentTime();
        long delta = ctx.getDelta();

        if(recebeuBala(ctx)) explodir(tempoAtual);

        if(confereEstado(tempoAtual)){
            cord_x += velocity_X * Math.cos(angle) * delta;
            cord_y += velocity_X * Math.sin(angle) * delta * (-1.0);
            angle += RV * delta;
            
            if(tempoAtual > nextShoot && cord_y < ctx.getJogador().getCord_y()){

                Projetil p = new EProjetil();

                p.setCord_x(cord_x);
                p.setCord_y(cord_y);
                p.setVelocity_X(Math.cos(angle) * 0.45);
                p.setVelocity_Y(Math.sin(angle) * 0.45 * (-1.0));
                p.setState(ACTIVE);

                ctx.addEProjetil(p);

                nextShoot = (long) (tempoAtual + 200 + Math.random() * 500);




            }

            GameLib.setColor(Color.CYAN);
            GameLib.drawCircle(cord_x, cord_y, getRadius());
        }
    }
}