package inimigos;

import gamelib.GameLib;
import projéteis.EProjetil;
import projéteis.Projetil;
import controle.Contexto;

import java.awt.*;

public abstract class Chefe extends  Inimigo{

    double radius;
    long vida;
    long vidaMaxima;
    long proximoTiro = 0;



    public boolean confereEstadoBoss(long tempoAtual,long vida) {
        if(state == INACTIVE) return false;

        if(state == EXPLODING){
            if(tempoAtual > explosion_end){
                state = INACTIVE;
                return false;
            }

            double alpha = (tempoAtual - explosion_start) / (explosion_end - explosion_start);
            GameLib.drawExplosion(cord_x, cord_y, alpha);


        }

        if(state == ACTIVE){
            if(vida == 0) {
                state = INACTIVE;
                return false;
            }
            return true;
        }
        return false;
    }

    protected void dispararGradeCentral(Contexto ctx) {
        int linhas = 3;
        int colunas = 12;
        double espacamento = 10.0;

        double inicioX = cord_x - (colunas - 1) * espacamento / 2.0;
        double inicioY = cord_y - (linhas - 1) * espacamento / 2.0;

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                Projetil p = new EProjetil();
                p.setCord_x(inicioX + j * espacamento);
                p.setCord_y(inicioY + i * espacamento);
                p.setVelocity_X(0.0);
                p.setVelocity_Y(0.3); // todos indo pra baixo, como uma parede
                p.setState(ACTIVE);
                ctx.addEProjetil(p);
            }
        }
    }

    protected void dispararColunaVertical(Contexto ctx) {
        int quantidade = 7; // número de projéteis na coluna
        double espacamento = 10.0;

        for (int i = 0; i < quantidade; i++) {
            Projetil p = new EProjetil();
            p.setCord_x(cord_x); // mesma coluna X
            p.setCord_y(cord_y - i * espacamento); // projéteis empilhados pra cima
            p.setVelocity_X(0.0);
            p.setVelocity_Y(0.4); // descendo
            p.setState(ACTIVE);
            ctx.addEProjetil(p);
        }
    }


    protected void desenharBarraDeVida() {
        int barraX = GameLib.WIDTH/2;
        int barraY = GameLib.HEIGHT - 45;
        int largura = 300;
        int altura = 20;

        double proporcao = (double) vida / vidaMaxima;
        int larguraAtual = (int) (largura * proporcao);

        GameLib.setColor(new Color(86, 14, 14));
        GameLib.fillRect(barraX, barraY, largura, altura);
        GameLib.setColor(Color.RED);
        GameLib.fillRect(barraX, barraY, larguraAtual, altura);
    }

    protected void dispararRajada(Contexto ctx) {
        for (int i = -10; i <= 10; i++) {
            Projetil p = new EProjetil();
            p.setCord_x(cord_x);
            p.setCord_y(cord_y);
            p.setVelocity_X(i * 0.2); // -0.2, 0, 0.2
            p.setVelocity_Y(0.4 * (1.0));
            p.setState(ACTIVE);
            ctx.addEProjetil(p);
        }
    }

    protected void dispararRadial(Contexto ctx) {
        int numProjetis = 24;
        for (int i = 0; i < numProjetis; i++) {
            double ang = 2 * Math.PI * i / numProjetis;
            Projetil p = new EProjetil();
            p.setCord_x(cord_x);
            p.setCord_y(cord_y);
            p.setVelocity_X(Math.cos(ang) * 0.3);
            p.setVelocity_Y(Math.sin(ang) * 0.3 * (-1.0));
            p.setState(ACTIVE);
            ctx.addEProjetil(p);
        }
    }
}
