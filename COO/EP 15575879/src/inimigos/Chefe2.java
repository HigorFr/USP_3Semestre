package inimigos;

import gamelib.GameLib;
import controle.Contexto;

import java.awt.*;

public class Chefe2 extends Chefe {


   private long proximaExplosao = 0;
   private long tempoUltimoDano = 0;
   private double baseY;
   private double tempoTotal = 0;
   private double rotacao = 0;

    public Chefe2(long vida,double x, double y) {
        radius = 60;
        this.vida = vida;
        vidaMaxima = vida;
        cord_x = x;
        cord_y = y;
        baseY = y;
        velocity_X = 0.15;
        angle = 0;
        state = ACTIVE;
    }

    @Override
    public double getRadius() {
        return radius;
    }

    public void update(Contexto ctx) {
        long tempoAtual = ctx.getCurrentTime();
        long delta = ctx.getDelta();


        if (tempoAtual - tempoUltimoDano > cooldowndano && recebeuBala(ctx)) {
            vida--;
            tempoUltimoDano = tempoAtual;
            if (vida <= 0) {
                explodir(tempoAtual);
                return;
            }
        }

        if (confereEstadoBoss(tempoAtual, vida)) {

            tempoTotal += delta;

            // Movimento oscilante
            cord_y = baseY + 30 * Math.sin(tempoTotal / 300.0);

            // Movimento horizontal limitado
            if (cord_x < 60 || cord_x > GameLib.WIDTH - 60) {
                velocity_X *= -1;
            }
            cord_x += velocity_X * delta;

            // Rotação lenta
            rotacao += 0.005 * delta;

            // Ataques
            if (tempoAtual > proximoTiro) {
                dispararColunaVertical(ctx);
                proximoTiro = tempoAtual + 370;
            }

            if (tempoAtual > proximaExplosao) {
                dispararGradeCentral(ctx);
                proximaExplosao = tempoAtual + 1230;
            }

            // Desenho do chefe como diamante
            // Camada 1: Diamante central grande (cor base)
            GameLib.setColor(new Color(255, 140, 0)); // Laranja forte
            GameLib.drawRotatedDiamond(cord_x, cord_y, radius + 5, rotacao);

            // Camada 2: Diamante médio com rotação diferente
            GameLib.setColor(Color.ORANGE); // Laranja
            GameLib.drawRotatedDiamond(cord_x, cord_y, radius, rotacao + 45);

            // Camada 3: Diamante menor com contraste
            GameLib.setColor(Color.YELLOW); // Amarelo, destaca no meio
            GameLib.drawRotatedDiamond(cord_x, cord_y, radius - 5, -rotacao);

            // Camada 4: Diamantes satélites (orbitando o centro)
            double angle1 = Math.toRadians(rotacao);
            double angle2 = Math.toRadians(rotacao + 120);
            double angle3 = Math.toRadians(rotacao + 240);
            double satelliteDist = 25.0;

            double sat1_x = cord_x + Math.cos(angle1) * satelliteDist;
            double sat1_y = cord_y + Math.sin(angle1) * satelliteDist;

            double sat2_x = cord_x + Math.cos(angle2) * satelliteDist;
            double sat2_y = cord_y + Math.sin(angle2) * satelliteDist;

            double sat3_x = cord_x + Math.cos(angle3) * satelliteDist;
            double sat3_y = cord_y + Math.sin(angle3) * satelliteDist;

            GameLib.setColor(Color.RED);
            GameLib.drawRotatedDiamond(sat1_x, sat1_y, radius / 2, rotacao);

            GameLib.setColor(Color.RED);
            GameLib.drawRotatedDiamond(sat2_x, sat2_y, radius / 2, rotacao);

            GameLib.setColor(Color.RED);
            GameLib.drawRotatedDiamond(sat3_x, sat3_y, radius / 2, rotacao);


            desenharBarraDeVida();
        }

    }





}
