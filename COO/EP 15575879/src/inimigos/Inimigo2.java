package inimigos;
import gamelib.GameLib;
import java.awt.Color;
import projéteis.*;
import controle.Contexto;


public class Inimigo2 extends Inimigo {
    

    static double radius = 12.0;

    public Inimigo2(double x, double y) {
        cord_x = x;
        cord_y = y;
        velocity_X = 0.42;
        velocity_Y = 0.0;
        angle = (3 * Math.PI) / 2;
        state = ACTIVE;
    }


    public double getRadius() {
        return radius;
    }


    public void update(Contexto ctx){
        long delta = ctx.getDelta();
        long tempoAtual = ctx.getCurrentTime();

        if(recebeuBala(ctx)) explodir(ctx.getCurrentTime());
        
        if(confereEstado(tempoAtual)){
            


            boolean shootNow = false;
            double previousY = cord_y;                      
            cord_x += velocity_X * Math.cos(angle) * delta;
            cord_y += velocity_X * Math.sin(angle) * delta * (-1.0);
            angle += RV * delta;
            
            double threshold = GameLib.HEIGHT * 0.30;
            
            if(previousY < threshold && cord_y >= threshold) {
                
                if(cord_x < GameLib.WIDTH / 2.0) RV = 0.003;
                else RV = -0.003;
            }
            
            if(RV > 0 && Math.abs(angle - 3 * Math.PI) < 0.05){
                
                RV = 0.0;
                angle = 3 * Math.PI;
                shootNow = true;
            }
            
            if(RV < 0 && Math.abs(angle) < 0.05){
                
                RV = 0.0;
                angle = 0.0;
                shootNow = true;
            }
                          
            
            if(shootNow){

                double [] angles = { Math.PI/2 + Math.PI/8, Math.PI/2, Math.PI/2 - Math.PI/8 };
                
                for (int k = 0; k < angles.length; k++){


                    Projetil p = new EProjetil();


                    double a = angles[k] + Math.random() * Math.PI/6 - Math.PI/12;
                    double vx = Math.cos(a);
                    double vy = Math.sin(a);


                    p.setCord_x(cord_x);
                    p.setCord_y(cord_y);
                    p.setVelocity_X(vx * 0.30);
                    p.setVelocity_Y(vy * 0.30);
                    p.setState(ACTIVE);

                    ctx.addEProjetil(p);



                }

            }

            GameLib.setColor(Color.MAGENTA);
            GameLib.drawDiamond(cord_x, cord_y, radius);
        }
    }
}






