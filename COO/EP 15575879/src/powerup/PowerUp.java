package powerup;

import entidades.Entidade;
import entidades.Player;
import gamelib.GameLib;
import controle.Contexto;

import java.awt.*;

public abstract class PowerUp extends Entidade {


    public  boolean colidiu = false;


    boolean aplicado = false;
    long inicio;
    long duracao;
    static double radius = 5.0;
    public double angle;


    public  abstract void aplicar(Player p, long tempoAtual);
    public  abstract void remover(Player p);



    public boolean isAplicado() {
        return aplicado;
    }

    public void Colidiu() {
        this.colidiu = true;
    }

    public boolean confereEstado() {
        if(state == INACTIVE) return false;

        if(state == ACTIVE){
            if(cord_y > GameLib.HEIGHT + 10 || cord_x > GameLib.WIDTH + 10 || cord_x < -10 || cord_y < -10) {
                state = INACTIVE;
                return false;
            }
            return true;
        }
        return false;
    }

    public void desenhar(long tempoAtual){
        float hue = (tempoAtual % 5000) / 5000f; // valor entre 0.0 e 1.0 que gira a cada 5 segundos

        Color corAnimada = Color.getHSBColor(hue, 1.0f, 1.0f);
        GameLib.setColor(corAnimada);


        GameLib.fillCircle(cord_x, cord_y, getRadius());
    }


    public void update(Contexto ctx){

        long tempoAtual = ctx.getCurrentTime();
        long delta = ctx.getDelta();
        Player j = ctx.getJogador();

        if(confereEstado() && !colidiu) {
            cord_x += velocity_X * Math.cos(angle) * delta;
            cord_y += velocity_X * Math.sin(angle) * delta * (-1.0);
            desenhar(tempoAtual);
        }

        if(confereEstado() && colidiu) {
            if (!aplicado) {
                aplicar(ctx.getJogador(), tempoAtual);
            } else {
                GameLib.drawPlayer(j.getCord_x(), j.getCord_y(), 18, Color.BLUE);
                if (tempoAtual - inicio >= duracao) remover(ctx.getJogador());
            }
        }
    }
}

